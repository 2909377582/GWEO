//public：这是方法的访问修饰符，表示该方法是公共的，可以在类外部访问。
//String：这是方法的返回类型，表示该方法将返回一个String类型的值。
//getKey()：这是方法的名称，通常用来描述方法的行为。在这里，getKey 表示获取对象的 key 属性值。
//{ return key; }：这是方法体，它包含了方法的具体实现。在这里，它返回了 key 成员变量的值。
//这个方法允许其他类或对象通过调用 getKey() 方法来获取 key 的值
// 因为 key 是一个私有成员变量，外部无法直接访问。
// 这是一种封装的方式，允许你控制对对象属性的访问并提供对属性的安全访问。
package com.example.gweo_sb.controller;

public class Data {
    private String upload_domain;
    private String load_Content;

    public String getUpload_domain() {
        return upload_domain;
    }

    public String getLoad_Content() {
        return load_Content;
    }
}




