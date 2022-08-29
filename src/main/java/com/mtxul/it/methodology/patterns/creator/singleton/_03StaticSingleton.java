package com.mtxul.it.methodology.patterns.creator.singleton;

/**
 * @BelongsProject: JavaCollection
 * @BelongsPackage: com.mtxul.it.methodology.patterns.singleton
 * @Author: MTXUL
 * @CreateTime: 2022
 * @Description:
 */
public class _03StaticSingleton {

    private _03StaticSingleton() {
    }

    public static _03StaticSingleton getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final _03StaticSingleton INSTANCE = new _03StaticSingleton();
    }
}
