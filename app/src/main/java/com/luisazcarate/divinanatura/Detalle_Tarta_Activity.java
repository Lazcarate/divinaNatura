package com.luisazcarate.divinanatura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.luisazcarate.divinanatura.modelo.Pan;
import com.luisazcarate.divinanatura.modelo.Pedido;
import com.luisazcarate.divinanatura.modelo.Tarta;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.luisazcarate.divinanatura.R.id.imgPan;
import static com.luisazcarate.divinanatura.R.id.imgTarta;
import static com.luisazcarate.divinanatura.R.id.tvnombre_tarta_detalle;

public class Detalle_Tarta_Activity extends AppCompatActivity implements View.OnClickListener{

    private static final int MAX_WIDTH = 170;
    private static final int MAX_HEIGHT = 130;


    @Bind(R.id.imgTarta)
    ImageView imagen_Tarta;
    @Bind(R.id.tvnombre_tarta_detalle)
    TextView nombre_tartaDetalle;
    @Bind(R.id.tvPrecio_tarta)
    TextView tvprecioTarta;
    @Bind(R.id.tvDescripcion_Tarta)
    TextView tvdescripcionTarta;
    @Bind(R.id.tvPeso_tarta)
    TextView txtPesoTarta;
    @Bind(R.id.edtCuantas)
    EditText edCuanto;
    @Bind(R.id.btnPedir_tarta)
    Button btnquieroTarta;
    private DatabaseReference mDataBaseTarta;
    private FirebaseUser mFirebaseUser;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_tarta);
        ButterKnife.bind(this);
        btnquieroTarta.setOnClickListener(this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        setUpDetalleTarta();
    }

    private void setUpDetalleTarta() {

        Tarta tartaDetalle = Parcels.unwrap(getIntent().getParcelableExtra("mTarta"));

        Picasso.with(Detalle_Tarta_Activity.this)
                .load(tartaDetalle.getFoto())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .placeholder(R.drawable.pan)
                .error(R.drawable.pan)
                .into(imagen_Tarta);
        nombre_tartaDetalle.setText(tartaDetalle.getNombre());
        tvprecioTarta.setText(tartaDetalle.getPrecio());
        tvdescripcionTarta.setText(tartaDetalle.getDescripcion());
        txtPesoTarta.setText(tartaDetalle.getPeso());
    }

    @Override
    public void onClick(View view) {

        hacerPedidoTartas();
        finish();

    }

    private void hacerPedidoTartas() {

        mDataBaseTarta = FirebaseDatabase.getInstance().getReference().child(Constantes.REF_TARTAS);
        String NombreTarta = nombre_tartaDetalle.getText().toString();
        int cant = Integer.valueOf(edCuanto.getText().toString());
        String emailUs = mFirebaseUser.getEmail();
        Pedido ped = new Pedido(NombreTarta, cant, emailUs);
        mDataBaseTarta.push().setValue(ped);

        edCuanto.setText("");

        Toast.makeText(this, "Pedido Realizado", Toast.LENGTH_SHORT).show();

    }
}
