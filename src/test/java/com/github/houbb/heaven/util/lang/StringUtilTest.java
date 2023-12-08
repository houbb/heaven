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

    @Test
    public void toCharSetTest() {
        final String text = "123456789";

        Assert.assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9]", StringUtil.toCharSet(text).toString());
    }

}
