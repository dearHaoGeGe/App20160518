package com.my.app20160518.bean;

/**
 * Created by YJH on 2016/5/24.
 */
public class BankBean {

    private String name;                //姓名
    private String bank_Account;        //开户银行
    private String account_Opening;       //开户账号
    private long opening_Time;          //开户时间
    private long account_Balance;       //账户余额
    private boolean account_Status;     //开户状态

    public BankBean(String name, String bank_Account, String account_Opening, long opening_Time, long account_Balance, boolean account_Status) {
        this.name = name;
        this.bank_Account = bank_Account;
        this.account_Opening = account_Opening;
        this.opening_Time = opening_Time;
        this.account_Balance = account_Balance;
        this.account_Status = account_Status;
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

    public String getAccount_Opening() {
        return account_Opening;
    }

    public void setAccount_Opening(String account_Opening) {
        this.account_Opening = account_Opening;
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
}
