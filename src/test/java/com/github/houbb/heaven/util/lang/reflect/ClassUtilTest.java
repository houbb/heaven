package com.github.houbb.heaven.util.lang.reflect;

import com.github.houbb.heaven.util.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;

public class ClassUtilTest {

    @Test
    public void getFieldTest() {
        Field field = ClassUtil.getField(User.class, "username");

        Assert.assertEquals("username", field.getName());
    }

}
