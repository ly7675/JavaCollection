package com.mtxul.it.concurrent.future;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.*;

import static com.mtxul.it.util.ThreadUtil.fastSleep;
import static com.mtxul.it.util.ThreadUtil.recordThreadName;
import static org.junit.Assert.assertFalse;

/**
 * @User: MTXUL
 * @Date: 2022/9/5
 */
@Slf4j
public class _01CompletableFuture {
    private long startTime;
    private long endTime;

    @Before
    public void startTime() {
        System.out.println("################ start test case #####################");
        startTime = System.currentTimeMillis();
    }

    @After
    public void endTime() {
        endTime = System.currentTimeMillis();
        System.out.println("################ cost time :" + (endTime - startTime) + " #####################");
        System.out.println("################ end test case #####################");
    }

    /**
     * 默认线程池
     */
    @Test
    public void m1() {
        // 默认线程池 同一jvm里面的CompletableFuture及并行流共同使用这个
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        // 自定义线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    /**
     * 异步执行 静态方法 runAsync
     */
    @Test
    public void async() throws InterruptedException {
        //使用默认线程池
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> log.info("Hello World!"));
        assertFalse(cf.isDone());
        //使用自定义线程池
        CompletableFuture.runAsync(() -> log.info("Hello World!"), Executors.newSingleThreadExecutor());

    }

    /**
     * 静态方法 supplyAsync 有返回值
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    @SneakyThrows
    public void supplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<String> f = CompletableFuture.supplyAsync(() -> {
            try {
                //ForkJoinPool.commonPool-worker-1线程
                recordThreadName();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        //阻塞等待3秒
        String result = f.get();
        //main线程
        recordThreadName();
        log.info(result);
    }


    @Test
    @SneakyThrows
    public void noAsync() {
        CompletableFuture<String> future = CompletableFuture.completedFuture("hello");
        System.out.println(future.join());
        CompletableFuture<Object> completableFuture = CompletableFuture.failedFuture(new RuntimeException("RX"));
        System.out.println(completableFuture.get());
    }

    /**
     * 任务一：订购航班
     * 任务二：订购酒店
     * 任务三：订购租车服务
     * <p>
     * 三依赖一二任务完成
     */
    @Test
    @SneakyThrows
    public void done1() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> log.info("订购航班"));
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> log.info("订购酒店"));
        CompletableFuture.allOf(future, future1).thenRunAsync(() -> log.info("订购租车服务"));
        Thread.sleep(1000);
    }

    /**
     * 将多个CompletableFuture串行执行
     * thenApply
     * thenAccept
     * thenRun
     * thenCompose
     */
    @Test
    @SneakyThrows
    public void then() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            recordThreadName();
            return "I";
        });
        CompletableFuture<String> future1 = future.thenApply((result) -> {
            fastSleep();
            recordThreadName();
            return result + " Love";
        });
        CompletableFuture<String> future2 = future1.thenApply((result) -> {
            fastSleep(3);
            recordThreadName();
            return result + " XD";
        });
        log.info(future2.get());
    }

    /**
     * 串行执行关系-串行执行异步
     */
    @Test
    @SneakyThrows
    public void thenAsync() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            recordThreadName();
            return "I";
        });
        CompletableFuture<String> future1 = future.thenApplyAsync(result -> {
            fastSleep();
            recordThreadName();
            return result + " Love";
        });
        CompletableFuture<String> future2 = future1.thenApplyAsync(result -> {
            fastSleep(3);
            recordThreadName();
            return result + " XD";
        });
        log.info(future2.get());
    }


    /**
     * AND 汇聚关系代表所有任务完成之后，才能进行下一个任务。
     * thenCombine
     * thenAcceptBoth
     * runAfterBoth
     * all
     */
    @Test
    @SneakyThrows
    public void and() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            fastSleep();
            log.info("  >>>> {} >>>>", "做核酸");
            return "做核酸";
        });
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            fastSleep(2);
            log.info("  >>>> {} >>>>", "绿码");
            return "绿码";
        });

        // 有返回值
        System.out.println("------------------thenCombine--------------------------");

        CompletableFuture<String> future2 = future.thenCombine(future1, (s1, s2) -> {
            log.info("  >>>> {},{} >>>>", s1, s2);
            return "恭喜完成核酸";
        });
        System.out.println(future2.join());

        // 无返回值
        System.out.println("------------------thenAcceptBoth--------------------------");
        future.thenAcceptBoth(future1, (s1, s2) -> {
            if (s2.equals("绿码")) {
                log.info("  >>>> {} >>>>", "恭喜完成核酸");
            }
        });

        System.out.println("------------------runAfterBoth--------------------------");
        future.runAfterBoth(future1, () -> {
            log.info("  >>>> {} >>>>", "恭喜完成核酸");
        });
    }

    /**
     * 买长途汽车票  或 买火车票 回家
     * OR 汇聚关系代表只要多个任务中任一任务完成，就可以接着接着执行下一任务
     * applyToEither
     * acceptEither
     * runAfterEither
     * anyOf
     */
    @Test
    @SneakyThrows
    public void or() {
        CompletableFuture<String> bus = CompletableFuture.supplyAsync(() -> {
            int i = new Random().nextInt(10);
            fastSleep(i);
            log.info("  >>>> {} >>>>", "购买汽车票成功" + i);
            return "购买汽车票成功";
        });
        CompletableFuture<String> train = CompletableFuture.supplyAsync(() -> {
            int i = new Random().nextInt(10);
            fastSleep(i);
            log.info("  >>>> {} >>>>", "购买火车票成功" + i);
            return "购买火车票成功";
        });


        System.out.println(bus.applyToEither(train, s -> {
            log.info("  >>>> {} >>>>", "回家");
            return "回家";
        }).join());
    }

    /**
     * 异常处理
     * CompletableFuture 方法执行过程若产生异常，当调用 get，join 获取任务结果才会抛出异常。'
     * exceptionally:使用方式类似于 try..catch 中 catch代码块中异常处理。
     * <p>
     * 类似于 try..catch..finanlly 中 finally 代码块。无论是否发生异常，都将会执行的
     * whenComplete : 无返回值
     * handle ： 有返回值
     */
    @Test
    @SneakyThrows
    public void exec() {
        //System.out.println(
        //        CompletableFuture.supplyAsync(
        //                () -> 1 / 0)
        //        .thenApply(integer -> integer * 10)
        //        .exceptionally(ex -> {
        //            log.info("  >>>> {} >>>>", ex.getMessage());
        //            return 1;
        //        })
        //        .join());

        System.out.println(
                CompletableFuture.supplyAsync(
                                () -> 1 / 1)
                        .thenApply(integer -> integer * 10)
                        .handle((result, exe) -> {
                            if (Objects.isNull(exe)) {
                                return result;
                            } else {
                                log.info("  >>>> {} >>>>", exe.getMessage());
                                return 0;
                            }
                        })
                        .join());
    }


}
