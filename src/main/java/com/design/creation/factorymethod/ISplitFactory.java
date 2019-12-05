package com.design.creation.factorymethod;

public interface ISplitFactory {
    <T extends Splitter> T create(Class<T> c);
}
