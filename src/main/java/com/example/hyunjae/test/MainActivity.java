package com.example.hyunjae.test;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hyunjae.test.adapter.SlidingMenuAdapter;
import com.example.hyunjae.test.fragment.Fragment1;
import com.example.hyunjae.test.model.ItemSlideMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ItemSlideMenu> listSlliding;
    private SlidingMenuAdapter adapter;
    private ListView listViewSliding;
    private DrawerLayout drawerLayout;

    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init component

        listViewSliding = (ListView) findViewById(R.id.lv_sliding_menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        listSlliding = new ArrayList<>();
        //Add item for sliding list
        listSlliding.add(new ItemSlideMenu(R.drawable.ic_action_setting,"경매하기"));
        listSlliding.add(new ItemSlideMenu(R.drawable.ic_action_about,"판매품목 목록"));
        listSlliding.add(new ItemSlideMenu(R.drawable.ic_action_kongji,"공지사항"));
        listSlliding.add(new ItemSlideMenu(R.drawable.ic_action_free,"자유게시판"));
        listSlliding.add(new ItemSlideMenu(R.drawable.ic_action_qa,"Q&A"));
        listSlliding.add(new ItemSlideMenu(R.drawable.ic_action_memo,"내역"));
        listSlliding.add(new ItemSlideMenu(R.drawable.ic_action_mypay,"내가 등록한 상품"));
        listSlliding.add(new ItemSlideMenu(R.drawable.ic_action_person,"개인정보 수정"));
        listSlliding.add(new ItemSlideMenu(R.drawable.ic_action_logout,"로그아웃"));
        listSlliding.add(new ItemSlideMenu(R.drawable.ic_action_adminout,"회원탈퇴"));
        listSlliding.add(new ItemSlideMenu(R.mipmap.ic_launcher,"Android"));
        adapter = new SlidingMenuAdapter(this , listSlliding);
        listViewSliding.setAdapter(adapter);

        //Display icon to open / close sliding list
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //set title
        setTitle(listSlliding.get(0).getTitle());
        // item select
        listViewSliding.setItemChecked(0,true);
        // close menu
        drawerLayout.closeDrawer(listViewSliding);

        //Display fragment 1 vhen start
        replaceFragment(0);
        // Handle on item clink

        listViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set title
                setTitle(listSlliding.get(position).getTitle());
                //item selected
                listViewSliding.setItemChecked(position, true);
                // Replace fragment
                replaceFragment(position);
                // closed menu
                drawerLayout.closeDrawer(listViewSliding);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.drawer_opened,R.string.drawer_closed){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    //Create method replace fragment
    private void replaceFragment(int pos) {
        Fragment1 fragment = null;
        switch (pos){
            case 0 :
                fragment = new Fragment1();
                break;

            case 1 :
                fragment = new Fragment1();
                break;
            case 2 :
                fragment = new Fragment1();
                break;
            default :
                fragment = new Fragment1();
                break;
        }
        if (null != fragment) {
            FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content,fragment);
            transaction.addToBackStack(null);
            transaction.commit();

        }

    }
}
