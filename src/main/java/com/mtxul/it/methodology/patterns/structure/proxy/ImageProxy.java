package com.mtxul.it.methodology.patterns.structure.proxy;

/**
 * target: 控制对其它对象的访问,增强功能。
 *
 * @User: MTXUL
 * @Date: 2022/9/5
 */
public class ImageProxy implements Image {
    private final HighResolutionImage highResolutionImage;

    public ImageProxy(HighResolutionImage highResolutionImage) {
        this.highResolutionImage = highResolutionImage;
    }

    @Override
    public void showImage() {
        while (!highResolutionImage.isLoad()) {
            try {
                System.out.println("Temp Image: " + highResolutionImage.getWidth() + " " + highResolutionImage.getHeight());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        highResolutionImage.showImage();
    }
}
