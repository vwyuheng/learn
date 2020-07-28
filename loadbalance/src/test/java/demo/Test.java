package demo;

import java.util.concurrent.TimeUnit;

/**
 * 编写代码，使用3个线程，1个线程打印X，一个线程打印Y，一个线程打印Z，同时执行连续打印10次"XYZ"。
 *
 */
public class Test {

    private static volatile Integer Count = 0;

    private static volatile Integer a = 0;

    public static void main(String[] args) {
        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (a == 0) {
                        System.out.print("X");
                        a = 1;
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (a == 1) {
                        System.out.print("Y");
                        a = 2;
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        Thread three = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    if (a == 2) {
                        System.out.println("Z");
                        a = 0;
                        Count++;
                        if(Count == 10) {
                            System.exit(0);
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        one.start();
        two.start();
        three.start();
    }
}