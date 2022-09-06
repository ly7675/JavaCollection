package com.mtxul.it.methodology.patterns.structure.proxy;

import java.net.URL;

/**
 * @User: MTXUL
 * @Date: 2022/9/5
 */
public class HighResolutionImage implements Image {

    private final URL imageURL;
    private final long startTime;
    private final int height;
    private final int width;

    public HighResolutionImage(URL imageURL) {
        this.imageURL = imageURL;
        this.startTime = System.currentTimeMillis();
        this.width = 600;
        this.height = 600;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isLoad() {
        // 模拟图片加载，延迟 3s 加载完成
        long endTime = System.currentTimeMillis();
        return endTime - startTime > 3000;
    }

    @Override
    public void showImage() {
        System.out.println("Real Image: " + imageURL);
    }
}
