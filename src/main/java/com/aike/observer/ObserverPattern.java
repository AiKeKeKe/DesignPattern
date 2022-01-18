package com.aike.observer;

import java.util.ArrayList;

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver());
        subject.notifys();
    }

}
//抽象目标subject
abstract class Subject{
    //定义一个观察者集合用于存储所有观察者对象
    ArrayList<Observer> observers = new ArrayList<>();
    //注册方法，用于向观察者集合中增加一个观察者
    public void attach(Observer observer) {
        observers.add(observer);
    }
    //注销方法，用于在观察者集合中删除一个观察者
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    //声明抽象通知方法
    public abstract void notifys();
}
//抽象目标类Subject的一个具体子类
class ConcreteSubject extends Subject{
    //实现通知方法
    public void notifys() {
        //遍历观察者集合，调用每一个观察者的响应方法
        for(Object obs:observers) {
            System.out.println("通知所有观察者");
            ((Observer)obs).update();
        }
    }
}
//抽象观察者
interface Observer{
    void update();
}
class ConcreteObserver implements Observer {
    //实现响应方法
    public void update() {
        //具体响应代码
        System.out.println("观察者收到");
    }
}
