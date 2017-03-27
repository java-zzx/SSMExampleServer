package com.github.ichenkaihua.test.common;



import org.junit.Test;

import ssm.autoCode.portal.utils.FileUtils;
import ssm.autoCode.portal.utils.RandomUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


public class CommonTest {


    @Test
    public void testSimpleDateFromat() {
//        String timeFromatedString = DateUtils.getCurrentTimeFromatedString();
//        assertNotNull(timeFromatedString);
//        System.out.println(timeFromatedString);
    }

    @Test
    public void testRandomString() {
        String randomString = RandomUtils.randomString();
        assertNotNull(randomString);
        System.out.println(randomString);
    }


    @Test
    public void testFileUtls() {
        String fileType = FileUtils.getFileType("sfdsafasfimage");
        System.out.println(fileType);
    }

}
