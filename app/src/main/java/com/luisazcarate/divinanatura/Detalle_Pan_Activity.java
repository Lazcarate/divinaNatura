package com.luisazcarate.divinanatura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.luisazcarate.divinanatura.modelo.Pan;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;
import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.luisazcarate.divinanatura.R.id.imgPan;
import static com.luisazcarate.divinanatura.R.id.tvDescripcion_Detalle;
import static com.luisazcarate.divinanatura.R.id.tvPeso;
import static com.luisazcarate.divinanatura.R.id.tvPrecio;

public class Detalle_Pan_Activity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pan);
        ButterKnife.bind(this);
        Pan panDetalle = (Pan) Parcels.unwrap(getIntent().getParcelableExtra("mPan"));

        Picasso.with(Detalle_Pan_Activity.this)
                .load(panDetalle.getFoto())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .placeholder(R.drawable.pan)
                .error(R.drawable.pan)
                .into(imagenPan);
        nombrePan_Detalle.setText(panDetalle.getNombre());
        tvPrecio.setText(panDetalle.getPrecio());
        tvdescripcion.setText(panDetalle.getDescripcion());
        nombrePan_Detalle.setText(panDetalle.getNombre());
        txtPeso.setText(panDetalle.getPeso());
    }
}
