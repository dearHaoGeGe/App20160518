package com.my.app20160518.bean;

/**
 * 银行详情信息实体类
 * <p>
 * Created by YJH on 2016/5/24.
 */
public class BankBean {

    private String name;                //姓名
    private String bank_Account;        //开户网点
    private String account_Number;      //开户账号
    private long opening_Time;          //开户日期
    private long account_Balance;       //可用资产数额
    private boolean account_Status;     //账户状态

    private String helpUnit;            //执协单位
    private String new_AccountCode;      //开户网点代码
    private String amount_Of_Assets;     //资产数额
    private String account_Type;         //账户类别
    private String currency;            //计价币种
    private String postCode;            //邮政编码
    private String notesOnTheNotes;     //钞汇标志
    private String newAccountBankAddress;   //开户银行地址
    private String relatedCapitalAccount;   //关联资金账户
    private String address;              //通讯地址
    private long feedbackTime;           //反馈时间
    private long dataStopTime;           //数据截止时间
    private long LogoutAccountDate;     //销户日期
    private String phone;               //联系电话
    private String remarks;             //备注

    public BankBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBank_Account() {
        return bank_Account;
    }

    public void setBank_Account(String bank_Account) {
        this.bank_Account = bank_Account;
    }

    public String getAccount_Number() {
        return account_Number;
    }

    public void setAccount_Number(String account_Number) {
        this.account_Number = account_Number;
    }

    public long getOpening_Time() {
        return opening_Time;
    }

    public void setOpening_Time(long opening_Time) {
        this.opening_Time = opening_Time;
    }

    public long getAccount_Balance() {
        return account_Balance;
    }

    public void setAccount_Balance(long account_Balance) {
        this.account_Balance = account_Balance;
    }

    public boolean isAccount_Status() {
        return account_Status;
    }

    public void setAccount_Status(boolean account_Status) {
        this.account_Status = account_Status;
    }

    public String getHelpUnit() {
        return helpUnit;
    }

    public void setHelpUnit(String helpUnit) {
        this.helpUnit = helpUnit;
    }

    public String getNew_AccountCode() {
        return new_AccountCode;
    }

    public void setNew_AccountCode(String new_AccountCode) {
        this.new_AccountCode = new_AccountCode;
    }

    public String getAmount_Of_Assets() {
        return amount_Of_Assets;
    }

    public void setAmount_Of_Assets(String amount_Of_Assets) {
        this.amount_Of_Assets = amount_Of_Assets;
    }

    public String getAccount_Type() {
        return account_Type;
    }

    public void setAccount_Type(String account_Type) {
        this.account_Type = account_Type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getNotesOnTheNotes() {
        return notesOnTheNotes;
    }

    public void setNotesOnTheNotes(String notesOnTheNotes) {
        this.notesOnTheNotes = notesOnTheNotes;
    }

    public String getNewAccountBankAddress() {
        return newAccountBankAddress;
    }

    public void setNewAccountBankAddress(String newAccountBankAddress) {
        this.newAccountBankAddress = newAccountBankAddress;
    }

    public String getRelatedCapitalAccount() {
        return relatedCapitalAccount;
    }

    public void setRelatedCapitalAccount(String relatedCapitalAccount) {
        this.relatedCapitalAccount = relatedCapitalAccount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(long feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public long getDataStopTime() {
        return dataStopTime;
    }

    public void setDataStopTime(long dataStopTime) {
        this.dataStopTime = dataStopTime;
    }

    public long getLogoutAccountDate() {
        return LogoutAccountDate;
    }

    public void setLogoutAccountDate(long logoutAccountDate) {
        LogoutAccountDate = logoutAccountDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
