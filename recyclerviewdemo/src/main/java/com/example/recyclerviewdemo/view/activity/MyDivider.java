package com.example.recyclerviewdemo.view.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * name ：李飞宇
 * Date: 2017/5/18
 * desc:
 */

public class MyDivider extends RecyclerView.ItemDecoration {
    private Context pContext;
    private final int widthPixels;

    public MyDivider(Context context) {
        this.pContext = context;
        //获取手机屏幕的整个宽度
        DisplayMetrics bm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(bm);
        widthPixels = bm.widthPixels;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        //画笔
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
//        c.drawCircle(300, 400, 100, paint);
//        c.clipRect(0,100,1000,110);

//        c.drawRect(rectF,paint);
        //找到总的Item的条目数
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            //获取每一个item控件视图
            View childAt = parent.getChildAt(i);
            //获取控件的左位置和下位置
            int right = childAt.getRight();
            int top = childAt.getTop();
            int left = childAt.getLeft();
            int bottom = childAt.getBottom();
            //矩形图片
            RectF rectF = new RectF(left, bottom, widthPixels, bottom + 6);
            c.drawRect(rectF, paint);

        }

    }

    //在上面
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }
}
