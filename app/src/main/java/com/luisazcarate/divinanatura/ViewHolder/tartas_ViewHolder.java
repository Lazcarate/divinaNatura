package com.luisazcarate.divinanatura.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luisazcarate.divinanatura.Detalle_Pan_Activity;
import com.luisazcarate.divinanatura.Detalle_Tarta_Activity;
import com.luisazcarate.divinanatura.R;
import com.luisazcarate.divinanatura.modelo.Pan;
import com.luisazcarate.divinanatura.modelo.Tarta;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

/**
 * Created by Luis on 19/12/16.
 */

public class Tartas_ViewHolder extends RecyclerView.ViewHolder {

    private static final int MAX_WIDTH = 170;
    private static final int MAX_HEIGHT = 130;

    Context mContext;
    View view;
    private ImageView imgTarta;
    private TextView txtNombre_tarta;

    public Tartas_ViewHolder(View itemView) {

        super(itemView);
        view = itemView;
        mContext = view.getContext();
        imgTarta = (ImageView) view.findViewById(R.id.imgTarta);
        txtNombre_tarta = (TextView) view.findViewById(R.id.tvNombreTarta);
    }
    public void BindTarta(final Tarta mTarta) {

        Picasso.with(mContext)
                .load(mTarta.getFoto())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .placeholder(R.drawable.pan)
                .error(R.drawable.pan)
                .into(imgTarta);
        txtNombre_tarta.setText(mTarta.getNombre());
        imgTarta.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          Intent intent = new Intent(mContext, Detalle_Tarta_Activity.class);
                                          intent.putExtra("mTarta", Parcels.wrap(mTarta));
                                          mContext.startActivity(intent);
                                      }
                                  }
        );
    }

}
