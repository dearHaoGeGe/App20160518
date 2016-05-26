package com.my.app20160518.eventbus;

import com.my.app20160518.bean.BankBean;

/**
 * EventBus传递BankBean
 *
 * Created by YJH on 2016/5/26.
 */
public class EventBankBean {

    private BankBean bean;

    public EventBankBean(BankBean bean) {
        this.bean = bean;
    }

    public BankBean getBean() {
        return bean;
    }

    public void setBean(BankBean bean) {
        this.bean = bean;
    }
}
