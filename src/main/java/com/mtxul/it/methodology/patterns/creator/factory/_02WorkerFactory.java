package com.mtxul.it.methodology.patterns.creator.factory;

/**
 * @BelongsProject: JavaCollection
 * @BelongsPackage: com.mtxul.it.methodology.patterns.factory
 * @Author: MTXUL
 * @CreateTime: 2022
 * @Description:
 */
public abstract class _02WorkerFactory {
    public abstract _02WorkerFactory getWorker();

    public void doSome() {
        _02WorkerFactory worker = getWorker();
        // worker.xxx
    }

    static class StudentFactory02 extends _02WorkerFactory {
        @Override
        public _02WorkerFactory getWorker() {
            return new StudentFactory02();
        }
    }

    static class TeacherFactory02 extends _02WorkerFactory {
        @Override
        public _02WorkerFactory getWorker() {
            return new TeacherFactory02();
        }
    }

    static class DoctorFactory02 extends _02WorkerFactory {
        @Override
        public _02WorkerFactory getWorker() {
            return new DoctorFactory02();
        }
    }
}
