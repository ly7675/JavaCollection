package com.mtxul.it.methodology.patterns.creator.factory;

/**
 * @BelongsProject: JavaCollection
 * @BelongsPackage: com.mtxul.it.methodology.patterns.factory
 * @Author: MTXUL
 * @CreateTime: 2022
 * @Description:
 */
public abstract class _03AbstractFactory {
    public static void main(String[] args) {
        Student03AbstractFactory studentAbstractFactory = new Student03AbstractFactory();
    }

    abstract WorkerFactory createWorker();

    abstract WorkFactory createWork();

    interface WorkerFactory {
    }

    interface WorkFactory {
    }

    static class StudentFactory implements WorkerFactory {
    }

    static class StudentWork implements WorkFactory {
    }

    static class TeacherFactory implements WorkerFactory {
    }

    static class TeacherWork implements WorkFactory {
    }

    static class DoctorFactory implements WorkerFactory {
    }

    static class DoctorWork implements WorkFactory {
    }

    static class Student03AbstractFactory extends _03AbstractFactory {
        @Override
        WorkerFactory createWorker() {
            return new StudentFactory();
        }

        @Override
        WorkFactory createWork() {
            return new StudentWork();
        }
    }

}
