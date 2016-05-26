package com.my.app20160518.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.my.app20160518.R;
import com.my.app20160518.fragment.InvestigationCaseFragment;

public class InvestigationOfFeedbackActivity extends FragmentActivity {

    private InvestigationCaseFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.investigation_of_feedback_activity);

        initView();

    }

    private void initView() {
        fragment = InvestigationCaseFragment.newInstance();
        initFragmentManager(fragment);
    }

    /**
     * 把InvestigationCaseFragment添加到InvestigationOfFeedbackActivity上面
     */
    public void initFragmentManager(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frameLayout_InvestigationOfFeedbackAct, fragment);
        ft.commit();
    }

}