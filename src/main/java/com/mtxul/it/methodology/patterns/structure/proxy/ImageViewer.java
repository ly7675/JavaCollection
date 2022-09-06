package com.mtxul.it.methodology.patterns.structure.proxy;

import java.net.URL;

/**
 * @User: MTXUL
 * @Date: 2022/9/5
 */
public class ImageViewer {
    public static void main(String[] args) throws Exception {
        String image = "http://image.jpg";
        URL url = new URL(image);
        HighResolutionImage highResolutionImage = new HighResolutionImage(url);
        ImageProxy imageProxy = new ImageProxy(highResolutionImage);
        imageProxy.showImage();
    }
}
