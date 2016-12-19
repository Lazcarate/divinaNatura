package com.luisazcarate.divinanatura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.luisazcarate.divinanatura.ViewHolder.Chat_ViewHolder;
import com.luisazcarate.divinanatura.modelo.Chat;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChatActivity extends AppCompatActivity {

    private DatabaseReference mChatRef;
    private FirebaseRecyclerAdapter menRecyclerAdapter;
    @Bind(R.id.rvChat)
    RecyclerView rvChateo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);
        mChatRef = FirebaseDatabase.getInstance().getReference().child(Constantes.REF_CHAT);
        setUpRecyclerChat();
    }

    private void setUpRecyclerChat() {

        Query ultimosCincuenta = mChatRef.limitToLast(50);

        menRecyclerAdapter = new FirebaseRecyclerAdapter<Chat, Chat_ViewHolder>(Chat.class, R.layout.chat_list_item,
                Chat_ViewHolder.class, ultimosCincuenta) {
            @Override
            protected void populateViewHolder(Chat_ViewHolder viewHolder, Chat model, int position) {

                viewHolder.bindChat(model);
            }
        };
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setReverseLayout(false);
        rvChateo.setHasFixedSize(false);
        rvChateo.setLayoutManager(linearLayoutManager);
        rvChateo.setAdapter(menRecyclerAdapter);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if (menRecyclerAdapter != null) {
            menRecyclerAdapter.cleanup();
        }
    }
}