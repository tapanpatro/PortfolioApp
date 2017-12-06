package com.omniroid.tapan.portfolioapp.view.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.mxn.soul.flowingdrawer_core.ElasticDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;
import com.mxn.soul.flowingdrawer_core.FlowingMenuLayout;
import com.omniroid.tapan.portfolioapp.HomeFragment;
import com.omniroid.tapan.portfolioapp.R;
import com.omniroid.tapan.portfolioapp.Utils.Util;
import com.omniroid.tapan.portfolioapp.view.HireMeFragment;
import com.omniroid.tapan.portfolioapp.view.fragment.PortfolioFragment;
import com.omniroid.tapan.portfolioapp.view.fragment.ProfileFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.omniroid.tapan.portfolioapp.Utils.Util.AnimationType.SLIDE_RIGHT;

/**
 *
 *
 * */





/** Interstitial
 * APP ID ADMOB = ca-app-pub-6662509822018991~1375543197 //ca-app-pub-6662509822018991~1375543197
 * Ad unit ID: ca-app-pub-6662509822018991/8604254380
 *
 *
 *
 * BANER
 *
 * App ID: ca-app-pub-6662509822018991~1375543197
 * Ad unit ID: ca-app-pub-6662509822018991/3351927703
 *
 *
 * */

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeFragment.OpenUpTheDrawer {

    private HomeFragment homeFragment;

    private FlowingDrawer mDrawer;
    FlowingMenuLayout flowingMenuLayout;

    @BindView(R.id.ll_main_home)
    LinearLayout mLinearHome;

    @BindView(R.id.ll_main_profile)
    LinearLayout mLinearProfile;

    @BindView(R.id.ll_main_portfolio)
    LinearLayout mLinearPortfolio;

    @BindView(R.id.ll_main_hireme)
    LinearLayout mLinearHireMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        AdView adView = new AdView(this);

        homeFragment = new HomeFragment();
        homeFragment.openUpTheDrawer = this;

        Window window = this.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        window.setStatusBarColor(this.getResources().getColor(R.color.status));

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        //getSupportFragmentManager().beginTransaction().replace(R.id.content, new HomeFragment()).addToBackStack(null).commit();
        Util.switchFragmentWithAnimation(R.id.content,homeFragment,this,null,SLIDE_RIGHT);
        //Util.switchFragmentWithAnimation(R.id.content,new HireMeFragment(),this,null,SLIDE_RIGHT);
        mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);
        //to open this drawer
        //mDrawer.openMenu(true);
        mDrawer.setTouchMode(ElasticDrawer.FOCUSABLES_TOUCH_MODE);
        mDrawer.setOnDrawerStateChangeListener(new ElasticDrawer.OnDrawerStateChangeListener() {
            @Override
            public void onDrawerStateChange(int oldState, int newState) {
                if (newState == ElasticDrawer.STATE_CLOSED) {
                    Log.i("MainActivityStateChange", "Drawer STATE_CLOSED");
                }
                if (newState == ElasticDrawer.STATE_OPENING) {
                    Log.i("MainActivityStateChange", "Drawer STATE_OPENING");
                }
                if (newState == ElasticDrawer.STATE_DRAGGING_OPEN) {
                    Log.i("MainActivityStateChange", "Drawer STATE_OPENING");
                }
            }

            @Override
            public void onDrawerSlide(float openRatio, int offsetPixels) {
                Log.i("MainActivity", "openRatio=" + openRatio + " ,offsetPixels=" + offsetPixels);
            }
        });


        flowingMenuLayout =  (FlowingMenuLayout) findViewById(R.id.menulayout);

        mLinearHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.switchFragmentWithAnimation(R.id.content,new HomeFragment(),HomeActivity.this,null,SLIDE_RIGHT);
                mDrawer.closeMenu(true);
            }
        });

        mLinearProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.switchFragmentWithAnimation(R.id.content,new ProfileFragment(),HomeActivity.this,null,SLIDE_RIGHT);
                mDrawer.closeMenu(true);
            }
        });

        mLinearPortfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.switchFragmentWithAnimation(R.id.content,new PortfolioFragment(),HomeActivity.this,null,SLIDE_RIGHT);
                mDrawer.closeMenu(true);
            }
        });

        mLinearHireMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.switchFragmentWithAnimation(R.id.content,new HireMeFragment(),HomeActivity.this,null,SLIDE_RIGHT);
                mDrawer.closeMenu(true);
            }
        });
    }

    @Override
    public void onBackPressed() {
        FlowingDrawer mDrawer = (FlowingDrawer) findViewById(R.id.drawerlayout);
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mDrawer.getDrawerState() == ElasticDrawer.STATE_OPEN) {
            //
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void openDrawer(boolean isDrawerAlreadyOpened) {

        if (isDrawerAlreadyOpened){
            mDrawer.closeMenu(true);
        }else {
            mDrawer.openMenu(true);
        }

    }
}
