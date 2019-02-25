package com.github.houbb.heaven.util.trick;

/**
* <p> ConsoleProgressBar Tester. </p>
* <p> 2019-02-25 16:31:39.707 </p>
*
* @author binbin.hou
* @version 0.0.2-SNAPSHOT
*/
public class ConsoleProgressBarTest {

    /**
     * 显示进度
     * @param args 方法入参
     * @throws InterruptedException if any
     */
    public static void main(String[] args) throws InterruptedException {
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, 100, 100, '=');
        for (int i = 1; i <= 100; i++) {
            cpb.show(i);
            Thread.sleep(20);
        }
    }

}
