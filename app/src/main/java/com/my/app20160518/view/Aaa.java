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
    private BarChartView bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aaa);

        bar = (BarChartView) findViewById(R.id.bar);
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
                lp.width = (int) (ll.getWidth() * 0.8);     //设置数值
                view2.setLayoutParams(lp);
            }
        });

        bar = new BarChartView(this, ll, 0.8f);
//        bar.setParentView(ll);
//        ViewGroup.LayoutParams lp = bar.getLayoutParams();
//        lp.width = (int) (bar.getParentViewWidth() * 0.6);
//        bar.setLayoutParams(lp);

    }

}
