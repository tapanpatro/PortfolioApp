package com.omniroid.tapan.portfolioapp.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.omniroid.tapan.portfolioapp.R;
import com.omniroid.tapan.portfolioapp.Utils.GradientBackgroundPainter;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortfolioFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.card_wedding)
    CardView mCardWedding;

    @BindView(R.id.card_ecomm)
    CardView mCardEcomm;

    @BindView(R.id.card_freelance)
    CardView mCardFreelance;

    @BindView(R.id.card_other)
    CardView mCardOther;

    private InterstitialAd mInterstitialAd;

    private GradientBackgroundPainter gradientBackgroundPainter;
    private GradientBackgroundPainter gradientBackgroundPainter1;
    private GradientBackgroundPainter gradientBackgroundPainter2;
    private GradientBackgroundPainter gradientBackgroundPainter3;

    private PortfolioDetailFragment portfolioDetailFragment;

    private View rootView;

    public PortfolioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_portfolio, container, false);
        ButterKnife.bind(this, rootView);

        MobileAds.initialize(getActivity(), getString(R.string.app_banner_app_id));


        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getString(R.string.app_inter_unit_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        /*  portfolioDetailFragment = new PortfolioDetailFragment();

                Bundle bundle = new

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager
                        .beginTransaction();

                fragmentTransaction.replace(R.id.content, portfolioDetailFragment);
                fragmentTransaction.addToBackStack(TAG);
                fragmentTransaction.commit();*/

        mCardEcomm.setOnClickListener(this);
        mCardFreelance.setOnClickListener(this);
        mCardOther.setOnClickListener(this);
        mCardWedding.setOnClickListener(this);

        final int[] drawables = new int[3];
        drawables[0] = R.drawable.gradient_1;
        drawables[1] = R.drawable.gradient_2;
        drawables[2] = R.drawable.gradient_3;

        final int[] drawables_1 = new int[3];
        drawables_1[1] = R.drawable.gradient_1;
        drawables_1[2] = R.drawable.gradient_2;
        drawables_1[0] = R.drawable.gradient_3;

        final int[] drawables_2 = new int[3];
        drawables_2[2] = R.drawable.gradient_1;
        drawables_2[0] = R.drawable.gradient_2;
        drawables_2[1] = R.drawable.gradient_3;

        final int[] drawables_3 = new int[3];
        drawables_3[2] = R.drawable.gradient_1;
        drawables_3[0] = R.drawable.gradient_2;
        drawables_3[1] = R.drawable.gradient_3;


        gradientBackgroundPainter = new GradientBackgroundPainter(mCardWedding, drawables);
        gradientBackgroundPainter.start();

        gradientBackgroundPainter1 = new GradientBackgroundPainter(mCardEcomm, drawables_1);
        gradientBackgroundPainter1.start();

        gradientBackgroundPainter2 = new GradientBackgroundPainter(mCardFreelance, drawables_2);
        gradientBackgroundPainter2.start();

        gradientBackgroundPainter3 = new GradientBackgroundPainter(mCardOther, drawables_3);
        gradientBackgroundPainter3.start();

        return rootView;
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id) {

            case R.id.card_wedding:

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                portfolioDetailFragment = new PortfolioDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putString("openType","wedding");
                portfolioDetailFragment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager
                        .beginTransaction();
                fragmentTransaction.replace(R.id.content, portfolioDetailFragment);
                fragmentTransaction.addToBackStack(TAG);
                fragmentTransaction.commit();


                break;

            case R.id.card_ecomm:

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                portfolioDetailFragment = new PortfolioDetailFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putString("openType","ecom");
                portfolioDetailFragment.setArguments(bundle1);
                FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1
                        .beginTransaction();
                fragmentTransaction1.replace(R.id.content, portfolioDetailFragment);
                fragmentTransaction1.addToBackStack(TAG);
                fragmentTransaction1.commit();

                break;

            case R.id.card_freelance:

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                portfolioDetailFragment = new PortfolioDetailFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putString("openType","free");
                portfolioDetailFragment.setArguments(bundle2);
                FragmentManager fragmentManager2 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2
                        .beginTransaction();
                fragmentTransaction2.replace(R.id.content, portfolioDetailFragment);
                fragmentTransaction2.addToBackStack(TAG);
                fragmentTransaction2.commit();

                break;

            case R.id.card_other:

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                portfolioDetailFragment = new PortfolioDetailFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putString("openType","other");
                portfolioDetailFragment.setArguments(bundle3);
                FragmentManager fragmentManager3 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3
                        .beginTransaction();
                fragmentTransaction3.replace(R.id.content, portfolioDetailFragment);
                fragmentTransaction3.addToBackStack(TAG);
                fragmentTransaction3.commit();

                break;

        }

    }
}
