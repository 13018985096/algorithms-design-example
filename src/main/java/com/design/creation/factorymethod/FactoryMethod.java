package com.design.creation.factorymethod;

public class FactoryMethod {

    public static void main(String[] args) {
        ISplitFactory iSplitFactory = new SplitFactory();
        iSplitFactory.create(FileSplitter.class);
    }

}


interface ISplitFactory {
    <T extends Splitter> T create(Class<T> c);
}


class SplitFactory implements ISplitFactory {

    public <T extends Splitter> T create(Class<T> c) {
        Splitter splitter = null;
        try {
            splitter = (Splitter) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {

        }
        return (T) splitter;
    }
}


/**
 * 拆分器
 */
interface Splitter {
    /**
     * 拆分方法
     */
    void spilt();
}

/**
 * 文件拆分器
 */
class FileSplitter implements Splitter {
    public void spilt() {
        System.out.println("我是一个文件拆分器");
    }
}


class PictureSplitter implements Splitter {

    public void spilt() {
        System.out.println("我是一个图片拆分器");
    }
}




