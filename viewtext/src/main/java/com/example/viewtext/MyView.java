package com.example.viewtext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * name ：李飞宇
 * Date: 2017/5/15
 * desc:
 */

public class MyView extends View {

    //    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        super(context, attrs, defStyleAttr);

    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs,0);
    }

    public MyView(Context context) {
//        super(context);
        this(context,null);
    }
//    int类型32位 前两位是—mode 后30具体大小的值 (模式四种，只用到3种 1.EXACTLY  2.AT_MOST  3.UNSPECIFIED )
//____________(要重写的三个方法
// 1.onMeasure(买热)——测量
// 2.onLayout ———布局
// 3.onDraw(照)———绘画）

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);

    }
//左上右下
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }
//纸canvas 笔paint
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
//        paint.setStyle(Paint.Style.STROKE);

        paint.setColor(Color.BLUE);
        canvas.drawCircle(200,400,150,paint);

        canvas.drawArc(80,100,200,200,0,180,false,paint);


    }

}
