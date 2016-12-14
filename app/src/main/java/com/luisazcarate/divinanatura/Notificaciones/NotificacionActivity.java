package com.luisazcarate.divinanatura.Notificaciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.luisazcarate.divinanatura.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NotificacionActivity extends AppCompatActivity {

    @Bind(R.id.tvNotificacion)
    TextView tvnotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);
        ButterKnife.bind(this);
        mostrarNotificacion();

    }

    private void mostrarNotificacion() {

        if(getIntent().getExtras() != null){
            for(String key: getIntent().getExtras().keySet()){
                String valor = getIntent().getExtras().getString(key);
                tvnotify.append("Tiulo" + key + "\n" + "Descripcion:" + valor);
            }
        }
    }


}
