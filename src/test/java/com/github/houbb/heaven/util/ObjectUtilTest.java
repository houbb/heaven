package com.github.houbb.heaven.util;

import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ObjectUtilTest {

    @Test
    public void getValueByPathTest() {
        User user = new User();

        user.setUsername("你的号");

        Object value = ObjectUtil.getValueByPath(user, "username");
        Assert.assertEquals(value, "你的号");
    }

    @Test
    public void getValueByPathContextTest() {
        User user = new User();
        user.setUsername("你的号");

        Map<String, Map<String, String>> data = new HashMap<>();

        Map<String, String> map = new HashMap<>();
        map.put("username", "1234");
        data.put("map", map);

        Object value = ObjectUtil.getValueByPath(data, "map.username");
        Assert.assertEquals(value, "1234");
    }

}
