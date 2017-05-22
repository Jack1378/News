package com.baway.myrecycleview.present;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;

/**
 * name ：李飞宇
 * Date: 2017/5/18
 * desc:
 */

public class MyDivider extends RecyclerView.ItemDecoration{
    private Context pContext;
    public MyDivider(Context context){
        this.pContext = context;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        //画笔
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        c.drawCircle(300,400,100,paint);
    }
    //在上面
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }
}
