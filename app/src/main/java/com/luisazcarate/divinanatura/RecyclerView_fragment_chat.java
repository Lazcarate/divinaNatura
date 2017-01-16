package com.luisazcarate.divinanatura;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.luisazcarate.divinanatura.modelo.Chat;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Luis on 16/12/16.
 */

public class RecyclerView_fragment_chat extends Fragment implements View.OnClickListener {


    private DatabaseReference mChatRef;
    private FirebaseUser firebaseUser;
    @Bind(R.id.btn_Enviar)
    Button enviarButton;
    @Bind(R.id.edMensaje)
    EditText mensajeEd;
    @Bind(R.id.btn_chat)
    Button irChat;


    public RecyclerView_fragment_chat() {

        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        ButterKnife.bind(this, view);
        mChatRef = FirebaseDatabase.getInstance().getReference().child(Constantes.REF_CHAT);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        enviarButton.setOnClickListener(this);
        irChat.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id) {

            case R.id.btn_Enviar:

                String uid = firebaseUser.getUid();
                String name = "User " + firebaseUser.getEmail();
                String mensagge = mensajeEd.getText().toString();

                Chat chat = new Chat(name, mensagge, uid);
                mChatRef.push().setValue(chat, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference reference) {
                        if (databaseError != null) {
                            Toast.makeText(getActivity(), "Mensaje erroneo", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(getActivity(), "Mensaje enviado", Toast.LENGTH_SHORT).show();
                    }
                });

                mensajeEd.setText("");
                startActivity(new Intent(getActivity(), ChatActivity.class));

                break;

            case R.id.btn_chat:

                startActivity(new Intent(getActivity(), ChatActivity.class));
                break;
        }

    }
}
