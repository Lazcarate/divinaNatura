package com.luisazcarate.divinanatura;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.luisazcarate.divinanatura.ViewHolder.Tartas_ViewHolder;
import com.luisazcarate.divinanatura.modelo.Tarta;



import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Luis on 9/12/16.
 */

public class RecyclerView_fragment_tartas extends Fragment{

    @Bind(R.id.rvTartas)
    RecyclerView recyclerViewtartas;
    private DatabaseReference mTartaReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    public RecyclerView_fragment_tartas() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_tartas, container, false);

        ButterKnife.bind(this, v);
        mTartaReference = FirebaseDatabase.getInstance().getReference().child(Constantes.REF_TARTAS);
        iniciarFireBaseAdapter();

        return v;
    }

    private void iniciarFireBaseAdapter() {

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Tarta, Tartas_ViewHolder>(Tarta.class, R.layout.tarta_list_item,
                Tartas_ViewHolder.class, mTartaReference) {

            @Override
            protected void populateViewHolder(Tartas_ViewHolder viewHolder, Tarta model, int position) {

                viewHolder.BindTarta(model);

            }
        };

        recyclerViewtartas.setHasFixedSize(true);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        recyclerViewtartas.setLayoutManager(glm);
        recyclerViewtartas.setAdapter(mFirebaseAdapter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mFirebaseAdapter != null) {
            mFirebaseAdapter.cleanup();
        }
    }
    }

