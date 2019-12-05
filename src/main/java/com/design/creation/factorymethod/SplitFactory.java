package com.design.creation.factorymethod;


public class SplitFactory implements ISplitFactory {

    public <T extends Splitter> T create(Class<T> c) {
        Splitter splitter = null;
        try {
            splitter = (Splitter)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {

        }
        return (T)splitter;
    }


    public static void main(String[] args) {
        ISplitFactory iSplitFactory = new SplitFactory();
        Splitter fileSplitter = iSplitFactory.create(FileSplitter.class);
        Splitter pictureSplitter = iSplitFactory.create(PictureSplitter.class);

        fileSplitter.spilt();
        pictureSplitter.spilt();
    }
}
