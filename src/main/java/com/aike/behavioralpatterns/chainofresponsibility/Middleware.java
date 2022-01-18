package com.aike.behavioralpatterns.chainofresponsibility;

public abstract class Middleware {
    private Middleware next;

    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(String userName, String password);

    protected boolean checkNext(String userName, String password) {
        if (next == null) {
            return true;
        }
        return next.check(userName, password);
    }

}
