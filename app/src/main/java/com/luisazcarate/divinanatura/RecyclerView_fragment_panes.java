package com.luisazcarate.divinanatura;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.luisazcarate.divinanatura.Adapter.Panes_Adapter;
import com.luisazcarate.divinanatura.modelo.Pan;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by Luis on 9/12/16.
 */

public class RecyclerView_fragment_panes extends Fragment{

    private ArrayList<Pan>panes;
    @Bind(R.id.rvPanes)
    RecyclerView recyclerViewPanes;
    private Panes_Adapter madapterPanes;
    private DatabaseReference mPanReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;


    public RecyclerView_fragment_panes() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_panes, container, false);
    }
}
