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
import com.luisazcarate.divinanatura.ViewHolder.Panes_ViewHolder;
import com.luisazcarate.divinanatura.modelo.Pan;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Luis on 9/12/16.
 */

public class RecyclerView_fragment_panes extends Fragment {

    @Bind(R.id.rvPanes)
    RecyclerView recyclerViewPanes;
    private DatabaseReference mPanReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;




    public RecyclerView_fragment_panes() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_panes, container, false);
        ButterKnife.bind(this, view);
        mPanReference = FirebaseDatabase.getInstance().getReference().child(Constantes.REF_PANES);
        setUpFireBaseAdapter();

        return view;
    }

    private void setUpFireBaseAdapter() {

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Pan, Panes_ViewHolder>(Pan.class, R.layout.pan_list_item,
                Panes_ViewHolder.class, mPanReference) {
            @Override
            protected void populateViewHolder(Panes_ViewHolder viewHolder, Pan model, int position) {

                viewHolder.BindPan(model);
            }
        };

        mFirebaseAdapter.notifyDataSetChanged();
        recyclerViewPanes.setHasFixedSize(true);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        recyclerViewPanes.setLayoutManager(glm);
        recyclerViewPanes.setAdapter(mFirebaseAdapter);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mFirebaseAdapter != null) {
            mFirebaseAdapter.cleanup();
        }
    }
}