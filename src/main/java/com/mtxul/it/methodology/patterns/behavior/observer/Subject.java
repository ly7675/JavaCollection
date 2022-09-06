package com.mtxul.it.methodology.patterns.behavior.observer;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public interface Subject {
    void resisterObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();
}
