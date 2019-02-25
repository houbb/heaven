package com.github.houbb.heaven.util.lang;

import com.github.houbb.heaven.util.common.ArgUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
* <p> ObjectUtil Tester. </p>
* <p> 2019-02-20 22:09:41.569 </p>
*
* @author houbinbin
* @version 0.0.1-SNAPSHOT
*/
public class ObjectUtilTest {

    /**
    *
    * Method: isSameType(one, two)
    */
    @Test
    public void isSameTypeTest() throws Exception {

    }

    /**
    *
    * Method: isNotSameType(one, two)
    */
    @Test
    public void isNotSameTypeTest() throws Exception {
    }

    /**
     *
     * Method: isNull(object)
     */
    @Test
    public void isNullTest() throws Exception {
        assertEquals(true, ObjectUtil.isNull(null));
        assertEquals(false, ObjectUtil.isNull(""));
    }

    /**
     *
     * Method: isNotNull(object)
     */
    @Test
    public void isNotNullTest() throws Exception {
        assertEquals(false, ObjectUtil.isNotNull(null));
        assertEquals(true, ObjectUtil.isNotNull(""));
    }

    /**
    *
    * Method: isEmpty(object)
    */
    @Test
    public void isEmptyTest() throws Exception {
    }

    /**
    *
    * Method: isNotEmpty(object)
    */
    @Test
    public void isNotEmptyTest() throws Exception {
    }

    /**
    *
    * Method: isEquals(except, real)
    */
    @Test
    public void isEqualsTest() throws Exception {
    }

    /**
    *
    * Method: isNotEquals(except, real)
    */
    @Test
    public void isNotEqualsTest() throws Exception {
    }


}
