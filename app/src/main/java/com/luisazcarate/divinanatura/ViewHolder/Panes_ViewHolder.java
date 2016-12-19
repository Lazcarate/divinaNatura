package com.luisazcarate.divinanatura.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.luisazcarate.divinanatura.Detalle_Pan_Activity;
import com.luisazcarate.divinanatura.R;
import com.luisazcarate.divinanatura.modelo.Pan;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;


/**
 * Created by Luis on 10/12/16.
 */

public class Panes_ViewHolder extends RecyclerView.ViewHolder{

    private static final int MAX_WIDTH = 170;
    private static final int MAX_HEIGHT = 130;

    Context mContext;
    View view;
    private ImageView imgPan;
    private TextView txtNombre;


    public Panes_ViewHolder(View itemView) {

        super(itemView);
        view = itemView;
        mContext = view.getContext();
        imgPan = (ImageView) view.findViewById(R.id.imgPan);
        txtNombre = (TextView) view.findViewById(R.id.tvNombreCV);

    }
    public void BindPan(final Pan mPan) {

        Picasso.with(mContext)
                .load(mPan.getFoto())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .placeholder(R.drawable.pan)
                .error(R.drawable.pan)
                .into(imgPan);
        txtNombre.setText(mPan.getNombre());
        imgPan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, Detalle_Pan_Activity.class);
                intent.putExtra("mPan", Parcels.wrap(mPan));
               /* if((Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)){
                   //activity.getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
                    activity.getWindow().setExitTransition(new Explode());
                    mContext.startActivity(intent, ActivityOptionsCompat
                            .makeSceneTransitionAnimation(activity, view, "").toBundle());
                }
                else
                {*/
                mContext.startActivity(intent);

            }
        }
    );
    }

}
