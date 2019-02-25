package com.github.houbb.heaven.util.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
* <p> ArgUtil Tester. </p>
* <p> 2019-02-20 22:09:41.577 </p>
*
* @author houbinbin
* @version 0.0.1-SNAPSHOT
*/
public class ArgUtilTest {

    /**
    *
    * https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
    * Method: notNull(object, name)
    */
    @Test
    public void notNullTest() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                ArgUtil.notNull(null, "Param"));

        assertEquals("Param can not be null!", exception.getMessage());
    }

    /**
    *
    * Method: notNull(object, name, errMsg)
    */
    @Test
    public void notNullObjectNameErrMsgTest() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                ArgUtil.notNull(null, "Param", "不能为空"));

        assertEquals("Param 不能为空", exception.getMessage());
    }

    /**
    *
    * Method: notEmpty(string, name)
    */
    @Test
    public void notEmptyTest() throws Exception {
        //1. null
        Exception exceptionNull = assertThrows(IllegalArgumentException.class, () ->
                ArgUtil.notEmpty(null, "String"));
        assertEquals("String can not be null!", exceptionNull.getMessage());

        //2. empty
        Exception exceptionEmpty = assertThrows(IllegalArgumentException.class, () ->
                ArgUtil.notEmpty("", "String"));
        assertEquals("String can not be null!", exceptionEmpty.getMessage());
    }



    /**
    *
    * Method: equals(except, real, msg)
    */
    @Test
    public void equalsTest() throws Exception {
        Exception exceptionEquals = assertThrows(IllegalArgumentException.class, () ->
                ArgUtil.equals("A", "B", "String"));
        assertEquals("Except:<A>, Real:<B>, Msg:<String>", exceptionEquals.getMessage());

        ArgUtil.equals("A", "A", "String");
    }

    /**
    *
    * Method: isEqualsLen(string, len)
    */
    @Test
    public void isEqualsLenTest() throws Exception {
        assertEquals(true, ArgUtil.isEqualsLen("XXX", 3));
        assertEquals(true, ArgUtil.isEqualsLen("", 0));
        assertEquals(true, ArgUtil.isEqualsLen(" ", 1));
        assertEquals(true, ArgUtil.isEqualsLen(null, 0));
    }

    /**
    *
    * Method: isNotEqualsLen(string, len)
    */
    @Test
    public void isNotEqualsLenTest() throws Exception {
        assertEquals(true, ArgUtil.isNotEqualsLen("XXX", 2));
        assertEquals(true, ArgUtil.isNotEqualsLen("", 1));
        assertEquals(true, ArgUtil.isNotEqualsLen(" ", 0));
        assertEquals(true, ArgUtil.isNotEqualsLen(null, 1));
    }

    /**
    *
    * Method: isFitMaxLen(string, maxLen)
    */
    @Test
    public void isFitMaxLenTest() throws Exception {
        assertEquals(true, ArgUtil.isFitMaxLen(null, 5));
        assertEquals(true, ArgUtil.isFitMaxLen("", 5));
        assertEquals(true, ArgUtil.isFitMaxLen(" ", 5));
        assertEquals(true, ArgUtil.isFitMaxLen(" XXX", 5));
        assertEquals(true, ArgUtil.isFitMaxLen("12345", 5));
    }

    /**
    *
    * Method: isNotFitMaxLen(string, maxLen)
    */
    @Test
    public void isNotFitMaxLenTest() throws Exception {
        assertEquals(true, ArgUtil.isNotFitMaxLen(null, -1));
        assertEquals(true, ArgUtil.isNotFitMaxLen("", -1));
        assertEquals(true, ArgUtil.isNotFitMaxLen(" ", 0));
        assertEquals(true, ArgUtil.isNotFitMaxLen(" XXX", 3));
        assertEquals(true, ArgUtil.isNotFitMaxLen("12345", 4));
    }

    /**
    *
    * Method: isFitMinLen(string, minLen)
    */
    @Test
    public void isFitMinLenTest() throws Exception {
        assertEquals(true, ArgUtil.isFitMinLen(null, 0));
        assertEquals(true, ArgUtil.isFitMinLen("", 0));
        assertEquals(true, ArgUtil.isFitMinLen(" ", 1));
        assertEquals(true, ArgUtil.isFitMinLen(" XXX", 4));
        assertEquals(true, ArgUtil.isFitMinLen("12345", 5));
    }

    /**
    *
    * Method: isNotFitMinLen(string, minLen)
    */
    @Test
    public void isNotFitMinLenTest() throws Exception {
        assertEquals(false, ArgUtil.isNotFitMinLen(null, 0));
        assertEquals(false, ArgUtil.isNotFitMinLen("", 0));
        assertEquals(false, ArgUtil.isNotFitMinLen(" ", 1));
        assertEquals(false, ArgUtil.isNotFitMinLen(" XXX", 4));
        assertEquals(false, ArgUtil.isNotFitMinLen("12345", 5));
    }

    /**
    *
    * Method: isNumber(number)
    */
    @Test
    public void isNumberTest() throws Exception {
        assertEquals(true, ArgUtil.isNumber("12345"));
        assertEquals(true, ArgUtil.isNumber("-12345"));
        assertEquals(true, ArgUtil.isNumber("12345.23"));
        assertEquals(true, ArgUtil.isNumber("-12345312"));
        assertEquals(true, ArgUtil.isNumber("-12345312.9999"));
    }

    /**
    *
    * Method: isNotNumber(number)
    */
    @Test
    public void isNotNumberTest() throws Exception {
        assertEquals(false, ArgUtil.isNotNumber("12345"));
        assertEquals(false, ArgUtil.isNotNumber("-12345"));
        assertEquals(false, ArgUtil.isNotNumber("12345.23"));
        assertEquals(false, ArgUtil.isNotNumber("-12345312"));
        assertEquals(false, ArgUtil.isNotNumber("-12345312.9999"));
    }

    /**
    *
    * Method: isMatchesRegex(string, regex)
    */
    @Test
    public void isMatchesRegexTest() throws Exception {
    }

    /**
    *
    * Method: isNotMatchesRegex(string, regex)
    */
    @Test
    public void isNotMatchesRegexTest() throws Exception {
    }


}
