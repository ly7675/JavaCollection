package com.mtxul.it.concurrent.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 线程状态
 *
 * @User: MTXUL
 * @Date: 2022/9/3
 */
@Slf4j
public class _01Demo {
    @Test
    public void ct1() throws InterruptedException {
        Runnable runnable = () -> log.info("execute task");
        Thread thread = new Thread(runnable);
        log.info("  >>>> {} >>>>", thread.getState());
        thread.start();
        log.info("  >>>> {} >>>>", thread.getState());
        Thread.sleep(1000);
        log.info("  >>>> {} >>>>", thread.getState());
    }


}
