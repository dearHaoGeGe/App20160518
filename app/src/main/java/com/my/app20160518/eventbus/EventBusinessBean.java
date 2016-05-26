package com.my.app20160518.eventbus;

import com.my.app20160518.bean.BusinessBean;

/**
 * EventBus传递BusinessBean
 *
 * Created by YJH on 2016/5/27.
 */
public class EventBusinessBean {

    private BusinessBean bean;

    public EventBusinessBean(BusinessBean bean) {
        this.bean = bean;
    }

    public BusinessBean getBean() {
        return bean;
    }

    public void setBean(BusinessBean bean) {
        this.bean = bean;
    }
}
