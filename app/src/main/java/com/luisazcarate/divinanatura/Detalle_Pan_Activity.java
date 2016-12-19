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
import com.squareup.picasso.Picasso;
import org.parceler.Parcels;
import butterknife.Bind;
import butterknife.ButterKnife;
import static com.luisazcarate.divinanatura.R.id.imgPan;


public class Detalle_Pan_Activity extends AppCompatActivity implements View.OnClickListener{

    private static final int MAX_WIDTH = 170;
    private static final int MAX_HEIGHT = 130;


    @Bind(imgPan)
    ImageView imagenPan;
    @Bind(R.id.tvnombrePan_Detalle)
    TextView nombrePan_Detalle;
    @Bind(R.id.tvPrecio)
    TextView tvPrecio;
    @Bind(R.id.tvDescripcion_Detalle)
    TextView tvdescripcion;
    @Bind(R.id.tvPeso)
    TextView txtPeso;
    @Bind(R.id.edtCantidad)
    EditText edCantidad;
    @Bind(R.id.btnPedir)
    Button btnquiero;
    private DatabaseReference mDataBase;
    private FirebaseUser mFirebaseUser;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pan);
        ButterKnife.bind(this);
        btnquiero.setOnClickListener(this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        setUpDetalle();
    }

    private void setUpDetalle() {

        Pan panDetalle = Parcels.unwrap(getIntent().getParcelableExtra("mPan"));

        Picasso.with(Detalle_Pan_Activity.this)
                .load(panDetalle.getFoto())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .placeholder(R.drawable.pan)
                .error(R.drawable.pan)
                .into(imagenPan);
        nombrePan_Detalle.setText(panDetalle.getNombre());
        tvPrecio.setText(panDetalle.getPrecio());
        tvdescripcion.setText(panDetalle.getDescripcion());
        txtPeso.setText(panDetalle.getPeso());
    }

    @Override
    public void onClick(View view) {

        hacerPedido();
        finish();

    }

    private void hacerPedido() {

        mDataBase = FirebaseDatabase.getInstance().getReference().child(Constantes.REF_PEDIDOS);
        String NombrePan = nombrePan_Detalle.getText().toString();
        int cant = Integer.valueOf(edCantidad.getText().toString());
        String emailUs = mFirebaseUser.getEmail();
        Pedido ped = new Pedido(NombrePan, cant, emailUs);
        mDataBase.push().setValue(ped);

        edCantidad.setText("");

        Toast.makeText(this, "Pedido Realizado", Toast.LENGTH_SHORT).show();

    }

}
