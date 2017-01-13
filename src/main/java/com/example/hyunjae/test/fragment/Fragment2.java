package com.example.hyunjae.test.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hyunjae.test.R;

/**
 * Created by swj15 on 2017-01-05.
 */

public class Fragment2 extends Fragment{

    public Fragment2() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment2,container,false);

        return rootView;
    }
}
