package com.omniroid.tapan.portfolioapp.view.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.omniroid.tapan.portfolioapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortfolioDetailFragment extends Fragment {


    /**
        Main 4 Layouts for Wedding, Ecommerce, Freelance, Other
     */

    @BindView(R.id.ll_wedding)
    LinearLayout mLinearWedding;
    @BindView(R.id.ll_ecom)
    LinearLayout mLinearEcom;
    @BindView(R.id.ll_freelance)
    LinearLayout mLinearFreelance;
    @BindView(R.id.ll_other)
    LinearLayout mLinearOther;

    /****************************************************************/



    /**
        CardView and Their Detail Layouts For Wedding Layout
     */

    @BindView(R.id.card_view_putta)
    CardView mCardPutta;
    @BindView(R.id.card_view_nayapu)
    CardView mCardNayapu;

    @BindView(R.id.ll_nayapu_detail)
    LinearLayout mLinearNayapuDetail;
    @BindView(R.id.ll_putta_detail)
    LinearLayout mLinearPuttaDetail;

    @BindView(R.id.btn_download_putta)
    Button mButtonDownloadPutta;

    @BindView(R.id.btn_download_nayapu)
    Button mButtonDownloadNaypu;


    /****************************************************************/



    private View rootView;

    public PortfolioDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_portfolio_detail, container, false);
        ButterKnife.bind(this,rootView);

        Bundle bundle = getArguments();
        String openType = bundle.getString("openType");

        setUpThePAge(openType);

        setUpDownloadButton();

        mCardPutta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLinearPuttaDetail.setVisibility(View.VISIBLE);
                mLinearNayapuDetail.setVisibility(View.GONE);
            }
        });

        mCardNayapu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLinearPuttaDetail.setVisibility(View.GONE);
                mLinearNayapuDetail.setVisibility(View.VISIBLE);
            }
        });


        return rootView;
    }

    private void setUpDownloadButton() {

        mButtonDownloadPutta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.aapta.tapan.aaptauidemo"));
                startActivity(intent);
            }
        });

        mButtonDownloadNaypu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.aapta.tapan.nayapun"));
                startActivity(intent);
            }
        });

    }

    private void setUpThePAge(String openType) {

        switch (openType) {

            case "wedding":
                mLinearWedding.setVisibility(View.VISIBLE);
                mLinearEcom.setVisibility(View.GONE);
                mLinearFreelance.setVisibility(View.GONE);
                mLinearOther.setVisibility(View.GONE);
                break;

            case "ecom":
                mLinearWedding.setVisibility(View.GONE);
                mLinearEcom.setVisibility(View.VISIBLE);
                mLinearFreelance.setVisibility(View.GONE);
                mLinearOther.setVisibility(View.GONE);
                break;

            case "free":
                mLinearWedding.setVisibility(View.GONE);
                mLinearEcom.setVisibility(View.GONE);
                mLinearFreelance.setVisibility(View.VISIBLE);
                mLinearOther.setVisibility(View.GONE);
                break;

            case "other":
                mLinearWedding.setVisibility(View.GONE);
                mLinearEcom.setVisibility(View.GONE);
                mLinearFreelance.setVisibility(View.GONE);
                mLinearOther.setVisibility(View.VISIBLE);
                break;


        }


    }

}
