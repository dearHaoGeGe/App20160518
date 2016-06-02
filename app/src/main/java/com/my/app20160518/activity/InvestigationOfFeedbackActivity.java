package com.my.app20160518.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.my.app20160518.R;
import com.my.app20160518.fragment.InvestigationCaseFragment;
import com.my.app20160518.service.ReceiveMessageService;

public class InvestigationOfFeedbackActivity extends FragmentActivity {

    private InvestigationCaseFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.investigation_of_feedback_activity);

        initView();
        startReceiveMessageService();
    }

    private void initView() {
        fragment = InvestigationCaseFragment.newInstance();
        initFragmentManager(fragment);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(new Intent(this,ReceiveMessageService.class));
    }

    /**
     * 启动服务
     */
    private void startReceiveMessageService(){
        startService(new Intent(this,ReceiveMessageService.class));
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