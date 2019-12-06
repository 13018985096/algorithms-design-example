package com.design.struct.flyweight;


import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式 属于结构型设计模型 运用共享技术解决性能问题
 *
 * 比如创建一个字体对象,系统启动的时候,将所有相关字符全部加载至内存,当去使用的时候,去内存中判断是否已经创建了该字符,
 * 若创建了直接从内存中取出,否则创建新的字符对象,并将对象存入至内存当中
 *
 * @author tanjiang
 */
public class FontFactory {

    Map<String, Font> map;

    FontFactory() {
        map = new HashMap<String, Font>();
    }
    Font getFount(String key) {
        //判断缓存当中是否已经存在创建的对象
        Font font = null;
        if (map.containsKey(key)) {
            font = map.get(key);
        } else {
            font = new Font();
            map.put(key, font);
        }
        return font;
    }
}
