package com.luisazcarate.divinanatura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.luisazcarate.divinanatura.ViewHolder.Chat_ViewHolder;
import com.luisazcarate.divinanatura.modelo.Chat;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener{

    private DatabaseReference mChatRef;
    private FirebaseRecyclerAdapter menRecyclerAdapter;
    private FirebaseUser firebaseUser;
    @Bind(R.id.rvChat)
    RecyclerView rvChateo;
    @Bind(R.id.btn_Enviar)
    ImageButton enviarButton;
    @Bind(R.id.edMensaje)
    EditText mensajeEd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);
        mChatRef = FirebaseDatabase.getInstance().getReference().child(Constantes.REF_CHAT);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        enviarButton.setOnClickListener(this);
        setUpRecyclerChat();
        setupAdapter();
    }

    private void setUpRecyclerChat() {

        //Query ultimosCincuenta = mChatRef.limitToLast(50);

        menRecyclerAdapter = new FirebaseRecyclerAdapter<Chat, Chat_ViewHolder>(Chat.class, R.layout.chat_list_item,
                Chat_ViewHolder.class, mChatRef) {
            @Override
            protected void populateViewHolder(Chat_ViewHolder viewHolder, Chat model, int position) {

                viewHolder.bindChat(model);
            }
        };
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //linearLayoutManager.setReverseLayout(false);
        //rvChateo.setHasFixedSize(true);
    }
    private void setupAdapter() {
        rvChateo.setLayoutManager(new LinearLayoutManager(this));
        rvChateo.setAdapter(menRecyclerAdapter);
        menRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if (menRecyclerAdapter != null) {
            menRecyclerAdapter.cleanup();
        }
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if (id == R.id.btn_Enviar) {

                String name = "User " + firebaseUser.getEmail();
                String mensagge = mensajeEd.getText().toString();

                Chat chat = new Chat(name, mensagge);
                mChatRef.push().setValue(chat, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference reference) {
                        if (databaseError != null) {
                            Toast.makeText(ChatActivity.this, "Mensaje erroneo", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(ChatActivity.this, "Mensaje enviado", Toast.LENGTH_SHORT).show();
                    }
                });
        }
    }
}
