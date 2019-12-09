package com.design.struct.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author tanjiang
 */
public class JdkDynamicProxy {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new Target());
        Subject subject = (Subject) proxyFactory.getInstance();
        subject.request();
    }
}

/**
 * 动态代理对象是通过反射来代理对象,相对于cglib更加消耗内存,但可以减少代理类的数量,使用更加灵活
 *
 * 动态代理在运行时动态的生成字节码文件加载至虚拟机中 静态代理是在编译时生成一个实际存在的class文件
 *
 * 动态代理要求目标对象一定要实现接口,否则不支持代理
 */
class ProxyFactory {

    /**
     * 被代理对象,依赖注入
     */
    Object object;

    public ProxyFactory(Object object) {
        this.object = object;
    }

    public  Object getInstance() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("开启事务");

                //执行目标对象方法
                method.invoke(object, args);

                System.out.println("关闭事务");
                return null;
            }
        });
    }
}








