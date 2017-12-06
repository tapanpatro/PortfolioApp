package com.omniroid.tapan.portfolioapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.omniroid.tapan.portfolioapp.Utils.Util;
import com.omniroid.tapan.portfolioapp.view.fragment.PortfolioFragment;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.omniroid.tapan.portfolioapp.Utils.Util.AnimationType.SLIDE_RIGHT;


public class HomeFragment extends Fragment {


    @BindView(R.id.img_background)
    ImageView mImageBackground;

    @BindView(R.id.tv_greet)
    TextView mTextGreet;

    @BindView(R.id.text_clock)
    TextClock textClock;

    @BindView(R.id.btn_open_drawer)
    Button mButtonOpenDrawer;

    @BindView(R.id.btn_open_portfolio) //btn_open_portfolio
            Button mButtonOpenPortfolio;

    @BindView(R.id.adView)
    AdView mAdView;

    public OpenUpTheDrawer openUpTheDrawer;

    Typeface typeface_thin;

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,rootView);

        MobileAds.initialize(getActivity(), getString(R.string.app_banner_app_id));


        AdView adView = new AdView(getActivity());
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getString(R.string.app_banner_unit_id));


        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        typeface_thin = Typeface.createFromAsset(getActivity().getAssets(), "fonts/rb_light.ttf");
        mTextGreet.setTypeface(typeface_thin);
        textClock.setTypeface(typeface_thin);

        mButtonOpenPortfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Util.switchFragmentWithAnimation(R.id.content,new PortfolioFragment(),getActivity(),null,SLIDE_RIGHT);
            }
        });

        mButtonOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mButtonOpenDrawer.setVisibility(View.GONE);
                openUpTheDrawer.openDrawer(false);
            }
        });

        settUpTime();

        return rootView;
    }

    private void settUpTime(){

        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12){
            Toast.makeText(getActivity(), "Good Morning", Toast.LENGTH_SHORT).show();
            mTextGreet.setText(getString(R.string.splash_hi).concat(", "+getString(R.string.good_morning)));
            mImageBackground.setImageResource(R.drawable.ic_morning);
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            mTextGreet.setText(getString(R.string.splash_hi).concat(", "+getString(R.string.good_afternoon)));
            mImageBackground.setImageResource(R.drawable.ic_noon);
            Toast.makeText(getActivity(), "Good Afternoon", Toast.LENGTH_SHORT).show();
        }else if(timeOfDay >= 16 && timeOfDay < 21){
            mTextGreet.setText(getString(R.string.splash_hi).concat(", "+getString(R.string.good_evening)));
            mImageBackground.setImageResource(R.drawable.ic_afternoon);
            Toast.makeText(getActivity(), "Good Evening", Toast.LENGTH_SHORT).show();
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            mTextGreet.setText(getString(R.string.splash_hi).concat(", "+getString(R.string.good_night)));
            mImageBackground.setImageResource(R.drawable.ic_night);
            Toast.makeText(getActivity(), "Good Night", Toast.LENGTH_SHORT).show();
        }

    }

    public interface OpenUpTheDrawer{
        void openDrawer(boolean isDrawerAlreadyOpened);
    }

}
