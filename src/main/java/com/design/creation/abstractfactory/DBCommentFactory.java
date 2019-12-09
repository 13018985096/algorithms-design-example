package com.design.creation.abstractfactory;


/**
 * 抽象工厂模式
 * <p>
 * 动机:解决一系列相互依赖对象的创建
 * <p>
 * 比如创建DB相关api的实现、当前行业中有多种数据库,例如mysql、oracle 等等,各个数据库都有自己所拥有的对象。
 * 我们现在打比方每种数据库都有创建连接对象和创建读数据对象。 扩展一个新数据库的对象就很简单了。
 * <p>
 * 优点:该模式的优点是适合扩展一个新系列的对象创建,例如创建一个sqlserver系列,只需分别实现DBCommentFactory 和 DBConnect、DBReader等操作就行了。
 * <p>
 * 缺点:对扩展同一系列下新对象创建代价比较大,比如在DBCommentFactory中需要新增一个创建关闭流的对象,那之前的对象就需要变动了,这里就违背了开闭原则，
 */
public interface DBCommentFactory {

    /**
     * 创建一个连接
     *
     * @return
     */
    DBConnect createConnect();

    /**
     * 读相关数据
     *
     * @return
     */
    DBReader createReader();

}
