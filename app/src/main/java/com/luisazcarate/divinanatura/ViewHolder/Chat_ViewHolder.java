package com.luisazcarate.divinanatura.ViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.luisazcarate.divinanatura.R;
import com.luisazcarate.divinanatura.modelo.Chat;

/**
 * Created by Luis on 16/12/16.
 */

public class Chat_ViewHolder extends RecyclerView.ViewHolder {

   Context mContext;
    View view;
    private final TextView tvautor;
    private final TextView tvmensaje;


    public Chat_ViewHolder(View itemView) {

        super(itemView);
        view = itemView;
        mContext = view.getContext();
        tvautor = (TextView) view.findViewById(R.id.nomautor);
        tvmensaje = (TextView) view.findViewById(R.id.textomensaje);

    }
    public void bindChat(final Chat chat){

        tvautor.setText(chat.getAutor());
        tvmensaje.setText(chat.getMensaje());
    }

}


