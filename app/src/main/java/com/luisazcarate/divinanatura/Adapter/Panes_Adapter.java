package com.luisazcarate.divinanatura.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.luisazcarate.divinanatura.R;
import com.luisazcarate.divinanatura.modelo.Pan;
import com.squareup.picasso.Picasso;



/**
 * Created by Luis on 10/12/16.
 */

public class Panes_Adapter extends RecyclerView.ViewHolder{

    Context mContext;
    View view;


    public Panes_Adapter(View itemView) {
        super(itemView);
        view = itemView;
        mContext = view.getContext();

    }
    public void BindPan(Pan mPan) {

        ImageView imgPan = (ImageView) view.findViewById(R.id.imgPan);
        TextView txtNombre = (TextView) view.findViewById(R.id.tvNombreCV);

        Picasso.with(mContext).load(mPan.getFoto())
                .placeholder(R.drawable.pan)
                .error(R.drawable.pan)
                .into(imgPan);
        txtNombre.setText(mPan.getNombre());

    }

}
