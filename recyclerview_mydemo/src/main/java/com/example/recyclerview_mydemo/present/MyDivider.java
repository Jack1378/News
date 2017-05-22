package com.example.recyclerview_mydemo.present;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

import java.lang.reflect.GenericArrayType;

/**
 * name ：李飞宇
 * Date: 2017/5/19
 * desc: 自定义下划线
 */

public class MyDivider extends RecyclerView.ItemDecoration{
    private Context mcontext;
    private final int widthPixels;
    public MyDivider(Context context){
        this.mcontext = context;
        DisplayMetrics bm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(bm);
        widthPixels = bm.widthPixels;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
//        c.drawARGB(0,100,200,300,paint);
        int childCount = parent.getChildCount();
        for (int i = 0;i< childCount;i++){
            View childAt = parent.getChildAt(i);
            int right = childAt.getRight();
            int top = childAt.getTop();
            int left = childAt.getLeft();
            int bottom = childAt.getBottom();
            RectF rectF = new RectF(left, bottom, widthPixels, bottom + 6);
            c.drawRect(rectF, paint);
        }


    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }
}
