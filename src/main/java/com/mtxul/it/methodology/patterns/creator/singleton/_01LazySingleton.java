package com.mtxul.it.methodology.patterns.creator.singleton;

/**
 * @BelongsProject: JavaCollection
 * @BelongsPackage: com.mtxul.it.methodology.pattern.siglton
 * @Author: MTXUL
 * @CreateTime: 2022
 * @Description:
 */
public class _01LazySingleton {
    private volatile static _01LazySingleton instance;

    private _01LazySingleton() {

    }

    public static _01LazySingleton getInstance() {
        if (instance == null) {
            synchronized (_01LazySingleton.class) {
                if (instance == null) {
                    instance = new _01LazySingleton();
                }
            }
        }
        return instance;
    }
}
