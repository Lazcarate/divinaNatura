package com.luisazcarate.divinanatura;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProductosActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabLayout)
    TabLayout tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        ButterKnife.bind(this);
        mAuth = FirebaseAuth.getInstance();

        setUpFragmentAdapter();
        setUpViewPager();



        if(toolbar != null){
            setSupportActionBar(toolbar);
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.logout){
            mAuth.signOut();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setUpFragmentAdapter(){

        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            Fragment[] fragments = new Fragment[]{
                    new RecyclerView_fragment_panes(),
                    new RecyclerView_fragment_tartas(),
                    new RecyclerView_fragment_chat()
            };

            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }
        };
    }


    private void setUpViewPager(){

        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.pan_48);
        tabLayout.getTabAt(1).setIcon(R.drawable.cupcake_48);
        tabLayout.getTabAt(2);

    }

}
