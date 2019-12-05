package com.design.struct.adpter;


/**
 * 适配器类
 * <p>
 * 适配器模式分为对象适配器模式和类适配器模式
 * 前者是组合旧类(也就是待扩展的类)，后者是具体适配器去继承旧类
 * 根据 组合优先于继承的设计原则,我们采用前者进行设计
 *
 * @author tanjiang
 */
public class Adapter implements Target {

    Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void send() {
        System.out.println("适配器扩展的方法");
    }

    /**
     * 适配器类具体的request方法仍然使用 待适配类中的request方法,
     * 这样就达到了适配器类既保留了旧类功能，又新增了功能,满足了新的需求
     */
    public void request() {
        adaptee.request();
    }
}
