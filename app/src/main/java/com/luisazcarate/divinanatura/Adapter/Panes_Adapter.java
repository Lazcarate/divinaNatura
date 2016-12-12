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

import java.util.ArrayList;
import java.util.zip.Inflater;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Luis on 10/12/16.
 */

public class Panes_Adapter extends RecyclerView.Adapter<Panes_Adapter.PanViewHolder>{

    private Context mContext;
    private ArrayList<Pan> mPanes = new ArrayList<>();

    public Panes_Adapter(Context mContext, ArrayList<Pan> mPanes) {
        this.mContext = mContext;
        this.mPanes = mPanes;
    }

    @Override
    public PanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pan_list_item, parent, false);

        return new PanViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PanViewHolder holder, int position) {

        Pan mPan = mPanes.get(position);
        Picasso.with(mContext).load(mPan.getUrl_foto())
                .placeholder(R.drawable.pan)
                .error(R.drawable.pan)
                .into(holder.imgPan);
        holder.tvNombre.setText(mPan.getNombre());

    }

    @Override
    public int getItemCount() {
        return mPanes.size();
    }

    public static class PanViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.imgPan) ImageView imgPan;
        @Bind(R.id.tvNombreCV) TextView tvNombre;


        public PanViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
