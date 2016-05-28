package com.my.app20160518.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * Created by YJH on 2016/5/28.
 */
public class BarChartView extends View {

    private static String TAG = "BarChartView------>";
    private float progressValue;
    /**
     * 父容器
     */
    private View parentView;
    private Context context;
    private int parentViewHeight;
    private int parentViewWidth;

    public BarChartView(Context context,View parentView,float progressValue) {
        super(context);
        Log.d(TAG, "111");
        this.parentView=parentView;
        this.progressValue=progressValue;
        getParentViewWH(this.parentView);
        measure((int) (this.parentViewWidth*this.progressValue),this.parentViewHeight);
    }

    public BarChartView(Context context) {
        super(context);
        Log.d(TAG, "111");
    }

    public BarChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "222");
    }

    public BarChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d(TAG, "333");
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BarChartView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Log.d(TAG, "444");
    }

    public void setParentView(View parentView) {
        this.parentView = parentView;
        getParentViewWH(this.parentView);



    }

    public int getParentViewWidth() {
        return parentViewWidth;
    }

    private void getParentViewWH(final View parentView) {
        ViewTreeObserver vto = parentView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                parentView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                Log.d("此组件高度 =", "" + parentView.getHeight());
                Log.d("此组件宽度 =", "" + parentView.getWidth());

                parentViewHeight = parentView.getHeight();   //得到父容器的高度
                parentViewWidth = parentView.getWidth();     //得到父容器的宽度
            }
        });
    }
}
