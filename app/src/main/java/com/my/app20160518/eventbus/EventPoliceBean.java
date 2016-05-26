package com.my.app20160518.eventbus;

import com.my.app20160518.bean.PoliceBean;

/**
 * EventBus传递PoliceBean
 *
 * Created by YJH on 2016/5/26.
 */
public class EventPoliceBean {

    private PoliceBean bean;

    public EventPoliceBean(PoliceBean bean) {
        this.bean = bean;
    }

    public PoliceBean getBean() {
        return bean;
    }

    public void setBean(PoliceBean bean) {
        this.bean = bean;
    }
}
