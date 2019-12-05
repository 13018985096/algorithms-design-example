package com.design.struct.adpter;


/**
 * 目标抽象类
 *
 * @author tanjiang
 */
public interface Target {
    /**
     * 发送信息功能
     */
    void send();

    /**
     * 请求信息，这个方法是待适配类中的方法
     */
    void request();
}
