package com.my.app20160518.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.my.app20160518.R;
import com.my.app20160518.bean.BankBean;
import com.my.app20160518.eventbus.EventBankBean;

import de.greenrobot.event.EventBus;

/**
 * 银行详情Activity
 * <p>
 * Created by YJH on 2016/5/26.
 */
public class BankDetailsActivity extends Activity {

    private BankBean bankBean;;
    private static final String ACT_CREATE = "BankDetailsActivity已经创建";
    private TextView tv_HelpUnit_BankDetails_item, tv_AccountOpening_BankDetails_item,
            tv_AccountNumber_BankDetails_item, tv_NewAccountCode_BankDetails_item,
            tv_Amount_Of_Assets_BankDetails_item, tv_Account_Type_BankDetails_item,
            tv_Currency_BankDetails_item, tv_Date_Of_Account_BankDetails_item,
            tv_Account_Status_BankDetails_item, tv_PostCode_BankDetails_item,
            tv_Account_Balance_BankDetails_item, tv_NotesOnTheNotes_BankDetails_item,
            tv_NewAccountBankAddress_BankDetails_item, tv_RelatedCapitalAccount_BankDetails_item,
            tv_Address_BankDetails_item, tv_FeedbackTime_BankDetails_item,
            tv_Data_Stop_Time_BankDetails_item, tv_LogoutAccountDate_BankDetails_item,
            tv_Phone_BankDetails_item, tv_Remarks_BankDetails_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bank_details_activity);

        EventBus.getDefault().post(ACT_CREATE);
        //注册EventBus
        EventBus.getDefault().register(this);

        initView();

    }

    private void initView() {

        tv_HelpUnit_BankDetails_item = (TextView) findViewById(R.id.tv_HelpUnit_BankDetails_item);
        tv_AccountOpening_BankDetails_item = (TextView) findViewById(R.id.tv_AccountOpening_BankDetails_item);
        tv_AccountNumber_BankDetails_item = (TextView) findViewById(R.id.tv_AccountNumber_BankDetails_item);
        tv_NewAccountCode_BankDetails_item = (TextView) findViewById(R.id.tv_NewAccountCode_BankDetails_item);
        tv_Amount_Of_Assets_BankDetails_item = (TextView) findViewById(R.id.tv_Amount_Of_Assets_BankDetails_item);
        tv_Account_Type_BankDetails_item = (TextView) findViewById(R.id.tv_Account_Type_BankDetails_item);
        tv_Currency_BankDetails_item = (TextView) findViewById(R.id.tv_Currency_BankDetails_item);
        tv_Date_Of_Account_BankDetails_item = (TextView) findViewById(R.id.tv_Date_Of_Account_BankDetails_item);
        tv_Account_Status_BankDetails_item = (TextView) findViewById(R.id.tv_Account_Status_BankDetails_item);
        tv_PostCode_BankDetails_item = (TextView) findViewById(R.id.tv_PostCode_BankDetails_item);
        tv_Account_Balance_BankDetails_item = (TextView) findViewById(R.id.tv_Account_Balance_BankDetails_item);
        tv_NotesOnTheNotes_BankDetails_item = (TextView) findViewById(R.id.tv_NotesOnTheNotes_BankDetails_item);
        tv_NewAccountBankAddress_BankDetails_item = (TextView) findViewById(R.id.tv_NewAccountBankAddress_BankDetails_item);
        tv_RelatedCapitalAccount_BankDetails_item = (TextView) findViewById(R.id.tv_RelatedCapitalAccount_BankDetails_item);
        tv_Address_BankDetails_item = (TextView) findViewById(R.id.tv_Address_BankDetails_item);
        tv_FeedbackTime_BankDetails_item = (TextView) findViewById(R.id.tv_FeedbackTime_BankDetails_item);
        tv_Data_Stop_Time_BankDetails_item = (TextView) findViewById(R.id.tv_Data_Stop_Time_BankDetails_item);
        tv_LogoutAccountDate_BankDetails_item = (TextView) findViewById(R.id.tv_LogoutAccountDate_BankDetails_item);
        tv_Phone_BankDetails_item = (TextView) findViewById(R.id.tv_Phone_BankDetails_item);
        tv_Remarks_BankDetails_item = (TextView) findViewById(R.id.tv_Remarks_BankDetails_item);
    }

    private void initData() {
        if (bankBean.getHelpUnit() != null) {
            tv_HelpUnit_BankDetails_item.setText("执协单位:" + bankBean.getHelpUnit());
        } else {
            tv_HelpUnit_BankDetails_item.setText("执协单位:");
        }

        if (bankBean.getBank_Account() != null) {
            tv_AccountOpening_BankDetails_item.setText("开户网点:" + bankBean.getBank_Account());
        } else {
            tv_AccountOpening_BankDetails_item.setText("开户网点:");
        }

        if (bankBean.getAccount_Number() != null) {
            tv_AccountNumber_BankDetails_item.setText("开户账号:" + bankBean.getAccount_Number());
        } else {
            tv_AccountNumber_BankDetails_item.setText("开户账号:");
        }

        if (bankBean.getNew_AccountCode() != null) {
            tv_NewAccountCode_BankDetails_item.setText("开户网点代码:" + bankBean.getNew_AccountCode());
        } else {
            tv_NewAccountCode_BankDetails_item.setText("开户网点代码:");
        }

        if (bankBean.getAmount_Of_Assets() != null) {
            tv_Amount_Of_Assets_BankDetails_item.setText("资产数额:" + bankBean.getAmount_Of_Assets());
        } else {
            tv_Amount_Of_Assets_BankDetails_item.setText("资产数额:");
        }

        if (bankBean.getAccount_Type() != null) {
            tv_Account_Type_BankDetails_item.setText("账户类别:" + bankBean.getAccount_Type());
        } else {
            tv_Account_Type_BankDetails_item.setText("账户类别:");
        }

        if (bankBean.getCurrency() != null) {
            tv_Currency_BankDetails_item.setText("计价币种:" + bankBean.getCurrency());
        } else {
            tv_Currency_BankDetails_item.setText("计价币种:");
        }

        //暂时不做判断
        tv_Date_Of_Account_BankDetails_item.setText("开户日期:" + bankBean.getOpening_Time());

        if (bankBean.isAccount_Status()) {
            tv_Account_Status_BankDetails_item.setText("账户状态：正常");
        } else {
            tv_Account_Status_BankDetails_item.setText("账户状态：冻结");
        }

        if (bankBean.getPostCode() != null) {
            tv_PostCode_BankDetails_item.setText("邮政编码:" + bankBean.getPostCode());
        } else {
            tv_PostCode_BankDetails_item.setText("邮政编码:");
        }

        //暂时不做判断
        tv_Account_Balance_BankDetails_item.setText("可用资产数额:" + bankBean.getAccount_Balance());

        if (bankBean.getNotesOnTheNotes() != null) {
            tv_NotesOnTheNotes_BankDetails_item.setText("钞汇标志:" + bankBean.getNotesOnTheNotes());
        } else {
            tv_NotesOnTheNotes_BankDetails_item.setText("钞汇标志:");
        }

        if (bankBean.getNewAccountBankAddress() != null) {
            tv_NewAccountBankAddress_BankDetails_item.setText("开户银行地址:" + bankBean.getNewAccountBankAddress());
        } else {
            tv_NewAccountBankAddress_BankDetails_item.setText("开户银行地址:");
        }

        if (bankBean.getRelatedCapitalAccount() != null) {
            tv_RelatedCapitalAccount_BankDetails_item.setText("关联资金账户:" + bankBean.getRelatedCapitalAccount());
        } else {
            tv_RelatedCapitalAccount_BankDetails_item.setText("关联资金账户:");
        }

        if (bankBean.getAddress() != null) {
            tv_Address_BankDetails_item.setText("通讯地址:" + bankBean.getAddress());
        } else {
            tv_Address_BankDetails_item.setText("通讯地址:");
        }

        //暂时不做判断
        tv_FeedbackTime_BankDetails_item.setText("反馈时间:" + bankBean.getFeedbackTime());

        //暂时不做判断
        tv_Data_Stop_Time_BankDetails_item.setText("数据截止时间:" + bankBean.getDataStopTime());

        //暂时不做判断
        tv_LogoutAccountDate_BankDetails_item.setText("注销日期:" + bankBean.getLogoutAccountDate());

        if (bankBean.getPhone() != null) {
            tv_Phone_BankDetails_item.setText("联系电话:" + bankBean.getPhone());
        } else {
            tv_Phone_BankDetails_item.setText("联系电话:");
        }

        if (bankBean.getRemarks()!=null){
            tv_Remarks_BankDetails_item.setText("备注:"+bankBean.getRemarks());
        }else {
            tv_Remarks_BankDetails_item.setText("备注:");
        }
    }

    /**
     * 从BankDetailsActivity接到BankBean对象
     *
     * @param bean
     */
    public void onEventMainThread(EventBankBean bean) {
        bankBean = bean.getBean();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册EventBus
        EventBus.getDefault().unregister(this);
    }
}
