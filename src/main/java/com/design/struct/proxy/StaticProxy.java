package com.design.struct.proxy;

public class StaticProxy {

    public static void main(String[] args) {
        Subject subject = new Target();
        Subject proxy = new ProxyTarget(subject);
        proxy.request();
    }
}

/**
 * 目标对象和代理对象都需要实现该接口
 */
interface Subject {
    /**
     * 请求信息
     */
    void request();
}

/**
 * 目标对象
 */
class Target implements Subject {

    public void request() {
        System.out.println("请求信息");
    }
}


/**
 * 代理对象
 */
class ProxyTarget implements Subject {

    private Subject subject;

    public ProxyTarget(Subject subject) {
        this.subject = subject;
    }

    public void request() {
        System.out.println("开启事务");
        subject.request();
        System.out.println("关闭事务");
    }
}
