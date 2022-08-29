package com.mtxul.it.methodology.patterns.creator.factory;

public class _01SimpleFactory {
    public static Worker getWorker(int type) {
        return switch (type) {
            case 1 -> new Student();
            case 2 -> new Teacher();
            default -> new Doctor();
        };
    }

    public static void main(String[] args) {
        getWorker(1);
        getWorker(2);
        getWorker(3);
    }

    interface Worker {
    }

    static class Student implements Worker {
        {
            System.out.println("student init");
        }
    }

    static class Teacher implements Worker {
        {
            System.out.println("teacher init");
        }
    }

    static class Doctor implements Worker {
        {
            System.out.println("doctor init");
        }
    }
}
