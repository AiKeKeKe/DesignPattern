package com.aike.behavioralpatterns.chainofresponsibility;

/**
 * 请求数量限制
 */
public class ThrottlingMiddleware extends Middleware {

    private int requestPerMinute;
    private int request;
    private long currentTime;

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    @Override
    public boolean check(String userName, String password) {
        System.out.println("ThrottlingMiddleware");
        if (System.currentTimeMillis() > currentTime + 60000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }
        request++;
        if (request > requestPerMinute) {
            System.out.println("Request limit exceeded!");
            Thread.currentThread().stop();
        }
        return checkNext(userName, password);
    }
}
