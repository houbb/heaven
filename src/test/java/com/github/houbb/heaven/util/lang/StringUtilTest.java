package com.github.houbb.heaven.util.lang;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StringUtilTest {

    @Test
    public void splitToListTest() {
        String ipList = "127.0.0.1";

        List<String> stringList = StringUtil.splitToList(ipList, '.');
        Assert.assertEquals("[127, 0, 0, 1]", stringList.toString());
    }
}
