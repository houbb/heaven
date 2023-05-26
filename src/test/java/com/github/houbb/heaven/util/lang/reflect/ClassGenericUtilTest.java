package com.github.houbb.heaven.util.lang.reflect;

import com.github.houbb.heaven.util.model.TestGenericStringUser;
import com.github.houbb.heaven.util.model.TestGenericTypeUser;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

public class ClassGenericUtilTest {

    @Test
    public void getGenericRuntimeTypeTest() {
        Type type1 = ClassGenericUtil.getGenericRuntimeType(new Wrapper<List<String>>());

        // 必须是内部匿名类才能获取到对应的信息？
        Type type2 = ClassGenericUtil.getGenericRuntimeType(new Wrapper<List<String>>() {});

        Assert.assertNull(type1);
        Assert.assertEquals("java.util.List<java.lang.String>", type2.toString());

        System.out.println(type1);
        System.out.println(type2);
    }

    @Test
    public void genericStringTest() {
        List<Field> fieldList = ClassUtil.getAllFieldList(TestGenericStringUser.class);

        for(Field field : fieldList) {
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(field.getClass());
            System.out.println(field.getGenericType());

            System.out.println(ReflectFieldUtil.getGenericParamType(field, 0));
            System.out.println("-------------------------------");
        }
    }

    @Test
    public void genericTypeTest() {
        Wrapper<TestGenericTypeUser<String>> wrapper = new Wrapper<>();

        TestGenericTypeUser<String> typeUser = new TestGenericTypeUser<>();

        List<Field> fieldList = ClassUtil.getAllFieldList(TestGenericTypeUser.class);

        for(Field field : fieldList) {
//            System.out.println(field.getName());
//            System.out.println(field.getType());
//            System.out.println(field.getClass());
//            System.out.println(field.getGenericType());

            // 创建一个匿名内部类？
//            System.out.println(ReflectFieldUtil.getGenericParamType(field, 0));
//            System.out.println("-------------------------------");
        }
    }

}
