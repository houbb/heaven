package com.github.houbb.heaven.util.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 网络工具类
 *
 * @author bbhou
 * @version 0.0.7
 * @since 0.0.7
 */
public final class NetUtil {

    private NetUtil(){}

    /**
     * 传入需要连接的IP，返回是否连接成功
     *
     * @param remoteInetAddress 远程地址
     * @return {@code true} 是
     */
    public static boolean isReachable(String remoteInetAddress) {
        return isReachable(remoteInetAddress, 5000);
    }

    /**
     * 传入需要连接的IP，返回是否连接成功
     * 注意：如果出现异常，只是简单的进行错误信息忽略
     * @param remoteInetAddress 远程地址
     * @param timeoutInMills   超时时间(milliseconds)
     * @return {@code true} 是
     */
    public static boolean isReachable(String remoteInetAddress, int timeoutInMills) {
        boolean reachable = false;
        try {
            InetAddress address = InetAddress.getByName(remoteInetAddress);
            reachable = address.isReachable(timeoutInMills);
        } catch (Exception e) {
            //ignore error
        }
        return reachable;
    }

    /**
     * 断言处于联网状态
     * 1. 这里可能会有一个问题，如果用户的 hosts 文件中有这个网址
     */
    public static void assertOnLine() {
        final String address = "translate.google.cn";
        try {
            InetAddress inetAddress = InetAddress.getByName(address);
        } catch (UnknownHostException e) {
            throw new RuntimeException("The net work is broken, " +
                    "check your network or set isCommentWhenNetworkBroken=true.");
        }
    }
}
