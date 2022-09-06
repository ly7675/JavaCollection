package com.mtxul.it.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @User: MTXUL
 * @Date: 2022/9/5
 */
@Slf4j
public class ThreadUtil {
    public static void fastSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void fastSleep(long sleepTime) {
        try {
            log.info("current thread is :" + Thread.currentThread().getName());
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void recordThreadName() {
        log.info("current thread is :" + Thread.currentThread().getName());
    }
}
