package com.sinoautodiagnoseos.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sinoautodiagnoseos.R;
import com.sinoautodiagnoseos.activity.PersonalCenterActivity;

/**
 * 云诊页面
 * Created by HQ_Demos on 2017/4/24.
 */

public class DiagnoseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_diagnose_pager, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
