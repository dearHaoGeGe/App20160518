package com.my.app20160518.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.my.app20160518.R;

/**
 * Created by YJH on 2016/5/28.
 */
public class Aaa extends Activity {

    private View view1, view2;
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aaa);

        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        ll = (LinearLayout) findViewById(R.id.ll);

        ViewTreeObserver vto2 = ll.getViewTreeObserver();
        vto2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ll.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                Log.d("8------height =", "" + ll.getHeight());
                Log.d("8------width =", "" + ll.getWidth());

                ViewGroup.LayoutParams lp = view2.getLayoutParams();
                lp.width = (int) (ll.getWidth() * 0.6);
                view2.setLayoutParams(lp);
            }
        });

        //此方法不要用一直在回调浪费资源
//        ViewTreeObserver vto = ll.getViewTreeObserver();
//        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
//            public boolean onPreDraw() {
//                int height = ll.getMeasuredHeight();
//                int width = ll.getMeasuredWidth();
//
//                Log.d("------height =", "" + height);
//                Log.d("------width =", "" + width);
//
//                Log.d("000", "000");
//                ViewGroup.LayoutParams lp = view2.getLayoutParams();
//                lp.width = (int) (width * 0.6);
//                view2.setLayoutParams(lp);
//
//                return true;
//            }
//        });
    }


    //        //在代码中设置界面大小的方法:
//
//        Display display = getWindowManager().getDefaultDisplay(); // 为获取屏幕宽、高
//        Window window = getWindow();
//        WindowManager.LayoutParams windowLayoutParams = window.getAttributes(); // 获取对话框当前的参数值
//        windowLayoutParams.width = (int) (display.getWidth() * 0.7); // 宽度设置为屏幕的0.95
//        windowLayoutParams.height = (int) (display.getHeight() * 0.1); // 高度设置为屏幕的0.6
//        windowLayoutParams.alpha = 0.5f;// 设置透明度
}
