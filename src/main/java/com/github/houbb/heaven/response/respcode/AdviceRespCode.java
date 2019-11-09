package com.github.houbb.heaven.response.respcode;

/**
 * 包含建议的响应码
 * @author binbin.hou
 * @since 0.1.38
 */
public interface AdviceRespCode extends RespCode {

    /**
     * 建议信息
     * @return 建议信息
     * @since 0.1.38
     */
    String getAdvice();

}
