package com.github.houbb.heaven.util.io.big;

/**
 * 文件输出
 *
 * @author binbin.hou
 * @since 0.1.159
 */
public class BigFileStringHandlerPrint implements IBigFileStringHandler {

    @Override
    public void handle(BigFileStringHandlerContext context) {
        int index = context.getIndex();
        String line = context.getLine();

        System.out.println(index + ": " + line);
    }

}
