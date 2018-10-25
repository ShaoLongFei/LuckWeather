package com.example.liuyue.luckweather.widget.weather;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.media.ThumbnailUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.liuyue.luckweather.R;


public abstract class BaseAnimView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    public BaseAnimView(Context context, Bitmap bitmap) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        this.bitmap = bitmap;
        holder.setFormat(PixelFormat.TRANSLUCENT); // 顶层绘制SurfaceView设成透明
        init();
    }

    /**
     * 初始化
     */
    protected void init() {
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        windowWidth = rect.width();
        windowHeight = rect.height();
        mSrcRect= new Rect(0, 0, windowWidth, windowHeight);
        mDestRect=new Rect(0,0,windowWidth,windowHeight);
    }

    /**
     * 画子类
     */
    protected abstract void drawSub(Canvas canvas);

    /**
     * 动画逻辑处理
     */
    protected abstract void animLogic();

    protected abstract void reset();

    /**
     * @return 线程睡眠时间，值越大，动画越慢，值越小，动画越快
     */
    protected int sleepTime() {
        return sleepTime;
    }


    protected float getFitSize(float size) {
        return size * windowWidth / 1080;
    }

    protected void startAnim() {
        isRunning = true;
        new Thread(this).start();
    }

    protected void doLogic() {
        while (isRunning) {
            Canvas canvas = null;
            synchronized (this) {
                try {
                    canvas = holder.lockCanvas();
                    if (canvas != null) {
                        canvas.drawBitmap(bitmap,mSrcRect,mDestRect,null);
                        drawSub(canvas);
                        animLogic();
                        holder.unlockCanvasAndPost(canvas);
                    }
                    Thread.sleep(sleepTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void callStop() {
        isRunning = false;
    }

    //////////////////////////////////////////////
    protected Thread thread;
    protected Bitmap bitmap;
    protected int windowWidth; //屏幕宽
    protected int windowHeight; //屏幕高
    protected Rect mSrcRect,mDestRect;
    protected int sleepTime = 30;
    protected SurfaceHolder holder;
    private boolean isRunning;
}