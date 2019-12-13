package com.structures.linear.array;


/**
 * 支持动态扩容的数组
 */
public class DynamicArray {

    /**
     * 数组默认大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     *
     */
    private Object[] elementData;

    private int size;


    public DynamicArray() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public void add(Object object) {
        if ((size + 1) > DEFAULT_CAPACITY) {
            int oldCapacity = elementData.length;
            //扩大自身大小的1.5倍
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            elementData = new Object[newCapacity];
            System.arraycopy(elementData, 0, elementData, 0, oldCapacity);
        }
        elementData[size++] = object;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 11; i++) {
            dynamicArray.add(1);
        }
        System.out.println(dynamicArray.size);
    }
}
