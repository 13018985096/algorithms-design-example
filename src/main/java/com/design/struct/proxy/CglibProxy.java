package com.design.struct.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {

    public static void main(String[] args) {
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(new TargetDao());
        TargetDao targetDao = (TargetDao) cglibProxyFactory.getProxyInstance();
        System.out.println(targetDao.getClass());
        targetDao.connect();

    }

}


/**
 * jdk动态代理有一个限制,就是需要目标类实现一个接口,而cglib没有这个限制,cglib会继承目标对象,需要重写方法,所以代理方法不能为final类
 * <p>
 * cglib可以在运行时期扩展java类与实现接口,被许多AOP框架所使用,如SpringAOP、dnyaop等
 * <p>
 * cglib底层是通过一个小而快的字节码框架AMS,来转换字节码生成类
 */
class CglibProxyFactory implements MethodInterceptor {
    Object object;

    public CglibProxyFactory(Object object) {
        this.object = object;
    }

    /**
     * 获取代理对象实例
     *
     * @return 代理对象实例
     */
    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开启事务");
        method.invoke(object, objects);
        System.out.println("关闭事务");
        return null;
    }
}


/**
 * 目标对象
 */
class TargetDao {
    void connect() {
        System.out.println("连接数据库");
    }
}


