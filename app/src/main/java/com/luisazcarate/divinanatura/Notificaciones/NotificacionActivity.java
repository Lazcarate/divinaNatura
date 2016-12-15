package com.luisazcarate.divinanatura.Notificaciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.luisazcarate.divinanatura.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NotificacionActivity extends AppCompatActivity {


    @Bind(R.id.tvNotifiCuerpo)
    TextView tvnotidyBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);
        ButterKnife.bind(this);
        mostrarNotificacion();

    }

    private void mostrarNotificacion() {

        if(getIntent().hasExtra("cuerpo")){
                String valor = getIntent().getStringExtra("cuerpo");
                tvnotidyBody.setText(valor);
            return;
            }
        }
    }



