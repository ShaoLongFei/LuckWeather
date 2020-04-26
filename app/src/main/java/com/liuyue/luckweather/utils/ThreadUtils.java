package com.liuyue.luckweather.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by 流月 on 2018/4/21.
 *
 * @description
 */

public class ThreadUtils {

    private ExecutorService fixedThreadPool=null;
    private ExecutorService singleThreadExecutor = null;
    private ScheduledExecutorService scheduledExecutorService = null;
    private Executor mainThread=null;

    public static enum EnumFactory {
        singletonFactory;

        private ThreadUtils mThreadUtils = new ThreadUtils();

        private EnumFactory() {
        }

        public ThreadUtils getIntance() {
            return this.mThreadUtils;
        }
    }

    public ExecutorService getFixedThreadPool(){
        if (fixedThreadPool==null){
            fixedThreadPool= Executors.newFixedThreadPool(2);
        }
        return fixedThreadPool;
    }

    public ExecutorService getSingleThreadExecutor(){
        if (singleThreadExecutor==null){
            singleThreadExecutor= Executors.newSingleThreadExecutor();
        }
        return singleThreadExecutor;
    }

    public ScheduledExecutorService getScheduledExecutorService(){
        if (scheduledExecutorService==null){
            scheduledExecutorService= Executors.newScheduledThreadPool(1);
        }
        return scheduledExecutorService;
    }

    public Executor getMainThread(){
        if (mainThread==null){
            mainThread=new MainThreadExecutor();
        }
        return mainThread;
    }

    private class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
