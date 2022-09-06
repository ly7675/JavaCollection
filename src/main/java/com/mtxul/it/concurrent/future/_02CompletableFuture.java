package com.mtxul.it.concurrent.future;

import com.mtxul.it.util.ThreadPoolUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

import static com.mtxul.it.util.ThreadUtil.fastSleep;

/**
 * @User: MTXUL
 * @Date: 2022/9/5
 */
@Slf4j
public class _02CompletableFuture {
    private long startTime;
    private ThreadPoolExecutor executor;

    @Before
    public void startTime() {
        System.out.println("################ start test case #####################");
        ThreadPoolUtils threadPool = new ThreadPoolUtils(4, 10, 20, "person");
        executor = threadPool.getExecutor();
        startTime = System.currentTimeMillis();
    }

    @After
    public void endTime() {
        long endTime = System.currentTimeMillis();
        System.out.println("################ cost time :" + (endTime - startTime) + " #####################");
        System.out.println("################ end test case #####################");
    }


    @Test
    @SneakyThrows
    public void m1() {
        log.info("  >>>> {} >>>>", "下班到家了");
        CompletableFuture<Void> water = CompletableFuture.runAsync(() -> {
            fastSleep(10);
            log.info("  >>>> {} >>>>", "热水烧好了");
        }, executor).thenRunAsync(() -> {
            fastSleep(2);
            log.info("  >>>> {} >>>>", "面泡好了");
        }, executor).thenRunAsync(() -> {
            fastSleep(2);
            log.info("  >>>> {} >>>>", "playGame");
        }, executor);
        System.out.println(water.get());
    }

    /**
     * 练习：泡茶过程
     * <p>
     * 1.洗茶壶 加水 烧水
     * 2.洗茶杯 放茶叶
     * 3.泡茶
     * （1.2异步）-3
     */
    @Test
    @SneakyThrows
    public void practiseOne() {
        // 茶壶准备工作
        CompletableFuture<Void> stepOne = CompletableFuture.runAsync(() -> {
            fastSleep(1);
            log.info("  >>>> {} >>>>", "洗茶壶");
        }).thenRun(() -> {
            fastSleep(1);
            log.info("  >>>> {} >>>>", "加水");

        }).thenRun(() -> {
            fastSleep(10);
            log.info("  >>>> {} >>>>", "烧水");
        });

        // 茶杯准备工作
        CompletableFuture<Void> stepTwo = CompletableFuture.runAsync(() -> {
            fastSleep(1);
            log.info("  >>>> {} >>>>", "洗茶杯");
        }).thenRun(() -> {
            fastSleep(1);
            log.info("  >>>> {} >>>>", "放茶叶");
        });

        // 最后泡茶阶段
        System.out.println(CompletableFuture.allOf(stepOne, stepTwo).thenRun(() -> {
            fastSleep(2);
            log.info("  >>>> {} >>>>", "泡茶");
        }).join());
    }
}
