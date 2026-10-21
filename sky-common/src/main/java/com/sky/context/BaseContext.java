package com.sky.context;

public class BaseContext {

    // tomcat服务器会为每个请求分配一个线程，也就是说当一个请求经过拦截器、controller,到达service层的时候，如果打印线程id会发现相等
    // 每个线程都有自己独立的内存空间，可以存储和获取数据，因此可以使用ThreadLocal来存储和获取拦截器，controller，service直接想要传递的数据
    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    // 向ThreadLocal中存储请求用户的id
    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }

    public static void removeCurrentId() {
        threadLocal.remove();
    }

}
