package com.my.app20160518.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.my.app20160518.R;
import com.my.app20160518.bean.BusinessBean;
import com.my.app20160518.eventbus.EventBankBean;
import com.my.app20160518.eventbus.EventBusinessBean;

import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * 工商详情Activity
 * <p/>
 * Created by YJH on 2016/5/26.
 */
public class BusinessDetailsActivity extends Activity {

    private BusinessBean bean;
    private static final String ACT_CREATE = "BusinessDetailsActivity已经创建";

    private TextView tv_FeedbackTime_BusinessCirclesDetails, tv_HelpUnit_PoliceDetails, tv_Business_Registration_Number_Or_IDNumber_PoliceDetails,
            tv_CompanyType_PoliceDetails, tv_Registered_Money_PoliceDetails, tv_Registered_Currency_PoliceDetails,
            tv_BusinessScope_PoliceDetails, tv_Create_Date__PoliceDetails, tv_Business_Term_PoliceDetails,
            tv_Job_PoliceDetails, tv_Legal_Representative_PoliceDetails, tv_Legal_Representative_Gender_PoliceDetails,
            tv_Legal_Representative_ID_PoliceDetails, tv_Legal_Representative_Phone_PoliceDetails, tv_Legal_Representative_Address_PoliceDetails,
            tv_Company_Address_PoliceDetails, tv_ID_Type_PoliceDetails, tv_Remarks_PoliceDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business_details_activity);

        EventBus.getDefault().post(ACT_CREATE);
        //注册EventBus
        EventBus.getDefault().register(this);

        initView();
    }

    private void initView() {
        tv_FeedbackTime_BusinessCirclesDetails = (TextView) findViewById(R.id.tv_FeedbackTime_BusinessCirclesDetails);
        tv_HelpUnit_PoliceDetails = (TextView) findViewById(R.id.tv_HelpUnit_PoliceDetails);
        tv_Business_Registration_Number_Or_IDNumber_PoliceDetails = (TextView) findViewById(R.id.tv_Business_Registration_Number_Or_IDNumber_PoliceDetails);
        tv_CompanyType_PoliceDetails = (TextView) findViewById(R.id.tv_CompanyType_PoliceDetails);
        tv_Registered_Money_PoliceDetails = (TextView) findViewById(R.id.tv_Registered_Money_PoliceDetails);
        tv_Registered_Currency_PoliceDetails = (TextView) findViewById(R.id.tv_Registered_Currency_PoliceDetails);
        tv_BusinessScope_PoliceDetails = (TextView) findViewById(R.id.tv_BusinessScope_PoliceDetails);
        tv_Create_Date__PoliceDetails = (TextView) findViewById(R.id.tv_Create_Date__PoliceDetails);
        tv_Business_Term_PoliceDetails = (TextView) findViewById(R.id.tv_Business_Term_PoliceDetails);
        tv_Job_PoliceDetails = (TextView) findViewById(R.id.tv_Job_PoliceDetails);
        tv_Legal_Representative_PoliceDetails = (TextView) findViewById(R.id.tv_Legal_Representative_PoliceDetails);
        tv_Legal_Representative_Gender_PoliceDetails = (TextView) findViewById(R.id.tv_Legal_Representative_Gender_PoliceDetails);
        tv_Legal_Representative_ID_PoliceDetails = (TextView) findViewById(R.id.tv_Legal_Representative_ID_PoliceDetails);
        tv_Legal_Representative_Phone_PoliceDetails = (TextView) findViewById(R.id.tv_Legal_Representative_Phone_PoliceDetails);
        tv_Legal_Representative_Address_PoliceDetails = (TextView) findViewById(R.id.tv_Legal_Representative_Address_PoliceDetails);
        tv_Company_Address_PoliceDetails = (TextView) findViewById(R.id.tv_Company_Address_PoliceDetails);
        tv_ID_Type_PoliceDetails = (TextView) findViewById(R.id.tv_ID_Type_PoliceDetails);
        tv_Remarks_PoliceDetails = (TextView) findViewById(R.id.tv_Remarks_PoliceDetails);
    }

    private void initData() {
        //暂时不做判断
        tv_FeedbackTime_BusinessCirclesDetails.setText("反馈时间：" + bean.getFeedbackTime());

        if (bean.getHelpUnit() != null) {
            tv_HelpUnit_PoliceDetails.setText("执协单位：" + bean.getHelpUnit());
        } else {
            tv_HelpUnit_PoliceDetails.setText("执协单位：");
        }

        //暂时不做判断
        tv_Business_Registration_Number_Or_IDNumber_PoliceDetails.setText("工商登记号或证件号：" + bean.getBusiness_Registration_Number_Or_IDNumber());

        if (bean.getCompanyType() != null) {
            tv_CompanyType_PoliceDetails.setText("公司类型：" + bean.getCompanyType());
        } else {
            tv_CompanyType_PoliceDetails.setText("公司类型：");
        }

        if (bean.getRegistered_Money() != null) {
            tv_Registered_Money_PoliceDetails.setText("注册资本：" + bean.getRegistered_Money());
        } else {
            tv_Registered_Money_PoliceDetails.setText("注册资本：");
        }

        if (bean.getRegistered_Currency() != null) {
            tv_Registered_Currency_PoliceDetails.setText("注册币种：" + bean.getRegistered_Currency());
        } else {
            tv_Registered_Currency_PoliceDetails.setText("注册币种：");
        }

        if (bean.getBusinessScope() != null) {
            tv_BusinessScope_PoliceDetails.setText("经营范围：" + bean.getBusinessScope());
        } else {
            tv_BusinessScope_PoliceDetails.setText("经营范围：");
        }

        //暂时不做判断
        tv_Create_Date__PoliceDetails.setText("成立日期：" + bean.getCreate_Date());

        if (bean.getBusiness_Term() != null) {
            tv_Business_Term_PoliceDetails.setText("营业期限：" + bean.getBusiness_Term());
        } else {
            tv_Business_Term_PoliceDetails.setText("营业期限：");
        }

        if (bean.getJob() != null) {
            tv_Job_PoliceDetails.setText("检查对象承担职务：" + bean.getJob());
        } else {
            tv_Job_PoliceDetails.setText("检查对象承担职务：");
        }

        if (bean.getLegal_Representative() != null) {
            tv_Legal_Representative_PoliceDetails.setText("法定代表人：" + bean.getLegal_Representative());
        } else {
            tv_Legal_Representative_PoliceDetails.setText("法定代表人：");
        }

        if (bean.getLegal_Representative_Gender() != null) {
            tv_Legal_Representative_Gender_PoliceDetails.setText("法定代表人性别：" + bean.getLegal_Representative_Gender());
        } else {
            tv_Legal_Representative_Gender_PoliceDetails.setText("法定代表人性别：");
        }

        if (bean.getLegal_Representative_ID() != null) {
            tv_Legal_Representative_ID_PoliceDetails.setText("法定代表人身份证号：" + bean.getLegal_Representative_ID());
        } else {
            tv_Legal_Representative_ID_PoliceDetails.setText("法定代表人身份证号：");
        }

        if (bean.getLegal_Representative_Phone() != null) {
            tv_Legal_Representative_Phone_PoliceDetails.setText("法定代表人电话：" + bean.getLegal_Representative_Phone());
        } else {
            tv_Legal_Representative_Phone_PoliceDetails.setText("法定代表人电话：");
        }

        if (bean.getLegal_Representative_Address() != null) {
            tv_Legal_Representative_Address_PoliceDetails.setText("法定代表人住所：" + bean.getLegal_Representative_Address());
        } else {
            tv_Legal_Representative_Address_PoliceDetails.setText("法定代表人住所：");
        }

        if (bean.getCompany_Address() != null) {
            tv_Company_Address_PoliceDetails.setText("公司地址：" + bean.getCompany_Address());
        } else {
            tv_Company_Address_PoliceDetails.setText("公司地址：");
        }

        if (bean.getID_Type() != null) {
            tv_ID_Type_PoliceDetails.setText("证件类型：" + bean.getID_Type());
        } else {
            tv_ID_Type_PoliceDetails.setText("证件类型：");
        }

        if (bean.getRemarks() != null) {
            tv_Remarks_PoliceDetails.setText("备注：" + bean.getRemarks());
        } else {
            tv_Remarks_PoliceDetails.setText("备注：");
        }

    }

    /**
     * 从BankDetailsFragment接到BankBean对象
     *
     * @param bean
     */
    public void onEventMainThread(EventBusinessBean bean) {
        this.bean = bean.getBean();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册EventBus
        EventBus.getDefault().unregister(this);
    }
}
