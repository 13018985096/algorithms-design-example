# algorithms-design-example
一些学习记录

JAVA内存模型:内存模型保证了共享内存的操作正确性,定义了共享内存在多线程程序读写操作的规范

JMM是一种规范，目的是解决由于多线程通过共享内存进行通信时，存在的本地内存数据不一致、编译器会对代码指令重排序、处理器会对代码乱序执行等带来的问题。

在单核系统进行多线程不会造成本地内存数据不一致的问题

可见性:缓存一致性
原子性:处理器优化
有序性: 指令重排序



设计模式:
   管理变化,提高复用
  
   七大设计原则:
   
    ````
     依赖倒置、接口隔离、开闭原则、单一职责、最少知道原则、组合优先继承原则、里式替换
    ````

   什么时候不用模式:
   ````
     代码可读性很差;需求理解尚浅;变化没有显现;不是系统的关键依赖点;项目没有复用价值;项目将要发布。
   ````