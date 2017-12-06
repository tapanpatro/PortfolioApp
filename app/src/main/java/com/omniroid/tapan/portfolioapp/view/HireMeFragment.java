package com.omniroid.tapan.portfolioapp.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.omniroid.tapan.portfolioapp.HireMe;
import com.omniroid.tapan.portfolioapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HireMeFragment extends Fragment {

    /**
     * Firebase Project Id: portfolio-app-547b7
     * */


    FirebaseDatabase database = FirebaseDatabase.getInstance();


    @BindView(R.id.et_hire_name)
    EditText mEditName;

    @BindView(R.id.et_hire_email)
    EditText mEditEmail;


    @BindView(R.id.et_hire_query)
    EditText mEditQuery;

    @BindView(R.id.btn_submit_hireme)
    Button mButtonHireMeSubmit;


    private View rootView;

    public HireMeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_hire_me, container, false);
        ButterKnife.bind(this,rootView);

        mButtonHireMeSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference myRef = database.getReference().child("queries");
                HireMe hireMe = new HireMe(mEditName.getText().toString().trim(),mEditEmail.getText().toString().trim(),mEditQuery.getText().toString().trim());
                myRef.push().setValue(hireMe, new DatabaseReference.CompletionListener(){
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        Toast.makeText(getActivity(), "Value was set. Error = "+databaseError, Toast.LENGTH_SHORT).show();
                    }
                });

                mEditName.setText("");
                mEditEmail.setText("");
                mEditQuery.setText("");
            }
        });





        return rootView;
    }

}
