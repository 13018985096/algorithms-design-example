package com.design.creation.single;


/**
 * 单例模式(饿汉)
 *
 * @author tanjiang
 */
public class SingleInstance {
    private static SingleInstance instance = new SingleInstance();

    private SingleInstance() {
    }

    public static SingleInstance getInstance() {
        return instance;
    }

}


/**
 * 枚举法
 */
enum MenuInstance {
    /**
     * 对象实例
     */
    INSTANCE
}


/**
 * 懒汉式(线程非安全的)
 */
class LazyInstance {
    private static LazyInstance instance;

    private LazyInstance() {
    }

    private static LazyInstance getInstance() {
        //当该对象还未实例化的时候,两个线程都执行到该位置,会导致创建不同的实例对象
        if (instance == null) {
            instance = new LazyInstance();
        }
        return instance;
    }
}

/**
 * 双重检验锁
 */
class DoubleVerifyInstance {

    private volatile static DoubleVerifyInstance instance;

    private DoubleVerifyInstance() {
    }

    private static DoubleVerifyInstance getInstance() {
        //当对象已经创建好了,减少线程再去拿锁对象的开销
        if (instance == null) {
            synchronized (DoubleVerifyInstance.class) {
                if (instance == null) {
                    //当实例如果未被volatile关键字修饰的话,同样会导致线程不安全的创建对象
                    //因为创建一个对象在执行指令中会有三个步骤:1.分配内存空间 2.在内存空间实例化对象 3.将引用指向这块内存空间
                    //这三个步骤可能会被重排序,2和3的位置颠倒,导致instance不为null,但此时的对象还未实例化,会导致线程拿到不正确的实例
                    instance = new DoubleVerifyInstance();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类创建实例
 */
class StaticInnerInstance {
    private StaticInnerInstance() {
    }

    private static class InnerInstance {
        private static StaticInnerInstance INSTANCE = new StaticInnerInstance();
    }

    public static StaticInnerInstance getInstance() {
        return InnerInstance.INSTANCE;
    }
}


