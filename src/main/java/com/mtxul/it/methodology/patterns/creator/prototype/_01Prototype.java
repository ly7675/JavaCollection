package com.mtxul.it.methodology.patterns.creator.prototype;

/**
 * @BelongsProject: JavaCollection
 * @BelongsPackage: com.mtxul.it.methodology.patterns.prototype
 * @Author: MTXUL
 * @CreateTime: 2022
 * @Description:
 */
public abstract class _01Prototype {

    public static void main(String[] args) {
        _01Prototype abc = new MyPrototype("abc");
        _01Prototype prototype = abc.myClone();
        System.out.println(abc);
        System.out.println(prototype);

    }

    abstract _01Prototype myClone();

    static class MyPrototype extends _01Prototype {
        private final String filed;

        public MyPrototype(String filed) {
            this.filed = filed;
        }

        @Override
        _01Prototype myClone() {
            return new MyPrototype(filed);
        }

        @Override
        public String toString() {
            return filed;
        }
    }
}
