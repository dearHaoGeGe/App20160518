package com.my.app20160518.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.my.app20160518.R;

/**
 * 定时接收消息的一个服务，APP要定时访问服务器，如果服务器有消息更新，
 * APP就Notification提醒用户
 * <p>
 * 参考：http://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650235966&idx=1&sn=59d052d4352203e5ca8070d9441038a4&scene=4#wechat_redirect
 * 参考：http://mp.weixin.qq.com/s?__biz=MzA5MzI3NjE2MA==&mid=2650236008&idx=1&sn=c7a1f1de9ee92e6d7a2d00f04821a8c3&scene=4#wechat_redirect
 * <p>
 * Created by YJH on 2016/6/2.
 */
public class ReceiveMessageService extends Service {

    private static final String TAG = "接收消息服务------>";

    private NotificationManager manager;

    private Handler mHandler;
    /**
     * 设置多少时间访问网络
     */
    private static int INTERVAL_TIME = 1000 * 10;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");

        timeRefreshNet();   //定时访问网络
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.d(TAG, "onLowMemory");
        startService(new Intent(this,this.getClass()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        startService(new Intent(this,this.getClass()));
    }

    /**
     * 定时去获取网络数据    INTERVAL_TIME=自定义
     */
    private void timeRefreshNet() {
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        Toast.makeText(ReceiveMessageService.this, "访问网络!", Toast.LENGTH_SHORT).show();
                        showNotification();     //显示Notification提醒
                        break;
                }
                return false;
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(INTERVAL_TIME);
                        mHandler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * 显示Notification
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void showNotification() {
        manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder b = new Notification.Builder(this);
        b.setContentTitle("叶良辰")  //标题
                .setContentText("我有一百种方法让你待不下去~")   //内容
                .setSubText("——记住我叫叶良辰")                //内容下面的一小段文字
                .setTicker("收到叶良辰发送过来的信息~")         //设置上升的动画
                .setWhen(System.currentTimeMillis())       //设置通知时间
                .setSmallIcon(R.drawable.yjh_item_icon)       //设置小图标，小图标一定要设，不然的话显示不出来
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))                       //设置大图标
                .setDefaults(Notification.DEFAULT_ALL)      //设置声音、震动、提示灯都默认
                .setAutoCancel(true);                     //设置点击后自动取消
        Notification n = b.build();
        manager.notify(1,n);
        //startForeground(1, n);
    }
}
