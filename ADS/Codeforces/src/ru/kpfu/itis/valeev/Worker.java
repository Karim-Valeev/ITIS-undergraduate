package ru.kpfu.itis.valeev;

public class Worker {
    public synchronized  void work() throws  InterruptedException{
        System.out.println(Thread.currentThread());
    }
}
