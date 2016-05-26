package com.my.app20160518.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.my.app20160518.R;
import com.my.app20160518.bean.PoliceBean;
import com.my.app20160518.eventbus.EventBankBean;
import com.my.app20160518.eventbus.EventPoliceBean;

import de.greenrobot.event.EventBus;

/**
 * 公安详情页Activity
 * <p/>
 * Created by YJH on 2016/5/26.
 */
public class PoliceDetailsActivity extends Activity {

    private PoliceBean bean;
    private static final String ACT_CREATE = "PoliceDetailsActivity已经创建";
    private TextView tv_name_PoliceDetails, tv_Before_Name_PoliceDetails, tv_IDNumber_PoliceDetails,
            tv_House_Number_Relationship_PoliceDetails, tv_And_Host_Relationship_PoliceDetails, tv_Node_Type_PoliceDetails,
            tv_Marry_PoliceDetails, tv_Education_PoliceDetails, tv_Nation__PoliceDetails, tv_Job_PoliceDetails,
            tv_Gender_PoliceDetails, tv_Height_PoliceDetails, tv_Birthday_PoliceDetails, tv_Place_Of_Birth_PoliceDetails,
            tv_Domicile_Address_City_PoliceDetails, tv_Domicile_Address_PoliceDetails, tv_Police_Station_Name_PoliceDetails,
            tv_Public_Security_Name_PoliceDetails, tv_Other_Address_City_PoliceDetails, tv_Other_Address_PoliceDetails,
            tv_Employer_PoliceDetails, tv_Change_Date_PoliceDetails, tv_Where_Move_PoliceDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.police_details_activity);

        EventBus.getDefault().post(ACT_CREATE);
        //注册EventBus
        EventBus.getDefault().register(this);

        initView();
    }

    private void initView() {
        tv_name_PoliceDetails = (TextView) findViewById(R.id.tv_name_PoliceDetails);
        tv_Before_Name_PoliceDetails = (TextView) findViewById(R.id.tv_Before_Name_PoliceDetails);
        tv_IDNumber_PoliceDetails = (TextView) findViewById(R.id.tv_IDNumber_PoliceDetails);
        tv_House_Number_Relationship_PoliceDetails = (TextView) findViewById(R.id.tv_House_Number_Relationship_PoliceDetails);
        tv_And_Host_Relationship_PoliceDetails = (TextView) findViewById(R.id.tv_And_Host_Relationship_PoliceDetails);
        tv_Node_Type_PoliceDetails = (TextView) findViewById(R.id.tv_Node_Type_PoliceDetails);
        tv_Marry_PoliceDetails = (TextView) findViewById(R.id.tv_Marry_PoliceDetails);
        tv_Education_PoliceDetails = (TextView) findViewById(R.id.tv_Education_PoliceDetails);
        tv_Nation__PoliceDetails = (TextView) findViewById(R.id.tv_Nation__PoliceDetails);
        tv_Job_PoliceDetails = (TextView) findViewById(R.id.tv_Job_PoliceDetails);
        tv_Gender_PoliceDetails = (TextView) findViewById(R.id.tv_Gender_PoliceDetails);
        tv_Height_PoliceDetails = (TextView) findViewById(R.id.tv_Height_PoliceDetails);
        tv_Birthday_PoliceDetails = (TextView) findViewById(R.id.tv_Birthday_PoliceDetails);
        tv_Place_Of_Birth_PoliceDetails = (TextView) findViewById(R.id.tv_Place_Of_Birth_PoliceDetails);
        tv_Domicile_Address_City_PoliceDetails = (TextView) findViewById(R.id.tv_Domicile_Address_City_PoliceDetails);
        tv_Domicile_Address_PoliceDetails = (TextView) findViewById(R.id.tv_Domicile_Address_PoliceDetails);
        tv_Police_Station_Name_PoliceDetails = (TextView) findViewById(R.id.tv_Police_Station_Name_PoliceDetails);
        tv_Public_Security_Name_PoliceDetails = (TextView) findViewById(R.id.tv_Public_Security_Name_PoliceDetails);
        tv_Other_Address_City_PoliceDetails = (TextView) findViewById(R.id.tv_Other_Address_City_PoliceDetails);
        tv_Other_Address_PoliceDetails = (TextView) findViewById(R.id.tv_Other_Address_PoliceDetails);
        tv_Employer_PoliceDetails = (TextView) findViewById(R.id.tv_Employer_PoliceDetails);
        tv_Change_Date_PoliceDetails = (TextView) findViewById(R.id.tv_Change_Date_PoliceDetails);
        tv_Where_Move_PoliceDetails = (TextView) findViewById(R.id.tv_Where_Move_PoliceDetails);
    }

    private void initData() {
        if (bean.getName() != null) {
            tv_name_PoliceDetails.setText("姓名：" + bean.getName());
        } else {
            tv_name_PoliceDetails.setText("姓名：");
        }

        if (bean.getBefore_Name() != null) {
            tv_Before_Name_PoliceDetails.setText("曾用名：" + bean.getBefore_Name());
        } else {
            tv_Before_Name_PoliceDetails.setText("曾用名：");
        }

        if (bean.getIDNumber() != null) {
            tv_IDNumber_PoliceDetails.setText("证件号码：" + bean.getIDNumber());
        } else {
            tv_IDNumber_PoliceDetails.setText("证件号码：");
        }

        if (bean.getHouse_Number() != null) {
            tv_House_Number_Relationship_PoliceDetails.setText("户号：" + bean.getHouse_Number());
        } else {
            tv_House_Number_Relationship_PoliceDetails.setText("户号：");
        }

        if (bean.getAnd_Host_Relationship() != null) {
            tv_And_Host_Relationship_PoliceDetails.setText("和户主关系：" + bean.getAnd_Host_Relationship());
        } else {
            tv_And_Host_Relationship_PoliceDetails.setText("和户主关系：");
        }

        if (bean.getNode_Type() != null) {
            tv_Node_Type_PoliceDetails.setText("户类型：" + bean.getNode_Type());
        } else {
            tv_Node_Type_PoliceDetails.setText("户类型：");
        }

        if (bean.getMarry() != null) {
            tv_Marry_PoliceDetails.setText("婚姻情况：" + bean.getMarry());
        } else {
            tv_Marry_PoliceDetails.setText("婚姻情况：");
        }

        if (bean.getEducation() != null) {
            tv_Education_PoliceDetails.setText("文化程度：" + bean.getEducation());
        } else {
            tv_Education_PoliceDetails.setText("文化程度：");
        }

        if (bean.getNation() != null) {
            tv_Nation__PoliceDetails.setText("民族：" + bean.getNation());
        } else {
            tv_Nation__PoliceDetails.setText("民族：");
        }

        if (bean.getJob() != null) {
            tv_Job_PoliceDetails.setText("职业：" + bean.getJob());
        } else {
            tv_Job_PoliceDetails.setText("职业：");
        }

        if (bean.getGender() != null) {
            tv_Gender_PoliceDetails.setText("性别：" + bean.getGender());
        } else {
            tv_Gender_PoliceDetails.setText("性别：");
        }

        if (bean.getHeight() != null) {
            tv_Height_PoliceDetails.setText("身高：" + bean.getHeight());
        } else {
            tv_Height_PoliceDetails.setText("身高：");
        }

        //暂时不做判断
        tv_Birthday_PoliceDetails.setText("出生日期：" + bean.getBirthday());

        if (bean.getPlace_Of_Birth() != null) {
            tv_Place_Of_Birth_PoliceDetails.setText("出生地：" + bean.getPlace_Of_Birth());
        } else {
            tv_Place_Of_Birth_PoliceDetails.setText("出生地：");
        }

        if (bean.getDomicile_Address_City() != null) {
            tv_Domicile_Address_City_PoliceDetails.setText("户籍地所在地址省市县（区）：" + bean.getDomicile_Address_City());
        } else {
            tv_Domicile_Address_City_PoliceDetails.setText("户籍地所在地址省市县（区）：");
        }

        if (bean.getDomicile_Address() != null) {
            tv_Domicile_Address_PoliceDetails.setText("户籍地住址详址：" + bean.getDomicile_Address());
        } else {
            tv_Domicile_Address_PoliceDetails.setText("户籍地住址详址：");
        }

        if (bean.getPolice_Station_Name() != null) {
            tv_Police_Station_Name_PoliceDetails.setText("所属派出所名称：" + bean.getPolice_Station_Name());
        } else {
            tv_Police_Station_Name_PoliceDetails.setText("所属派出所名称：");
        }

        if (bean.getPublic_Security_Name() != null) {
            tv_Public_Security_Name_PoliceDetails.setText("所属公安机关名称：" + bean.getPublic_Security_Name());
        } else {
            tv_Public_Security_Name_PoliceDetails.setText("所属公安机关名称：");
        }

        if (bean.getOther_Address_City() != null) {
            tv_Other_Address_City_PoliceDetails.setText("其他住址省市县（区）：" + bean.getOther_Address_City());
        } else {
            tv_Other_Address_City_PoliceDetails.setText("其他住址省市县（区）：");
        }

        if (bean.getOther_Address() != null) {
            tv_Other_Address_PoliceDetails.setText("其他住址详地：" + bean.getOther_Address());
        } else {
            tv_Other_Address_PoliceDetails.setText("其他住址详地：");
        }

        if (bean.getEmployer() != null) {
            tv_Employer_PoliceDetails.setText("服务处所：" + bean.getEmployer());
        } else {
            tv_Employer_PoliceDetails.setText("服务处所：");
        }

        if (bean.getChange_Date() != null) {
            tv_Change_Date_PoliceDetails.setText("变动日期：" + bean.getChange_Date());
        } else {
            tv_Change_Date_PoliceDetails.setText("变动日期：");
        }

        if (bean.getWhere_Move() != null) {
            tv_Where_Move_PoliceDetails.setText("何地迁入：" + bean.getWhere_Move());
        } else {
            tv_Where_Move_PoliceDetails.setText("何地迁入：");
        }

    }

    /**
     * 从PoliceDetailsFragment接到PoliceBean对象
     *
     * @param bean
     */
    public void onEventMainThread(EventPoliceBean bean) {
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
