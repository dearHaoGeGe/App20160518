package com.my.app20160518;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class InvestigationOfFeedbackActivity extends FragmentActivity {

    private InvestigationCaseFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigation_of_feedback);

        initView();
        initFragmentManager();
    }

    private void initView() {
        fragment = InvestigationCaseFragment.newInstance();
    }

    /**
     * 把InvestigationCaseFragment添加到InvestigationOfFeedbackActivity上面
     */
    private void initFragmentManager() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frameLayout_InvestigationOfFeedbackAct, fragment);
        ft.commit();
    }
}
