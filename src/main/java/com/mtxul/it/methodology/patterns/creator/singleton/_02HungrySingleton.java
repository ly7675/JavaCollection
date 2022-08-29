package com.mtxul.it.methodology.patterns.creator.singleton;

/**
 * @BelongsProject: JavaCollection
 * @BelongsPackage: com.mtxul.it.methodology.patterns.singleton
 * @Author: MTXUL
 * @CreateTime: 2022
 * @Description:
 */
public class _02HungrySingleton {
    private static final _02HungrySingleton instance = new _02HungrySingleton();

    private _02HungrySingleton() {

    }

    public static _02HungrySingleton GetInstance() {
        return instance;
    }
}
