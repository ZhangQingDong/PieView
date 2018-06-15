package com.example.zqd.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: com.example.zqd.test</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 *
 * @author zhangqingdong
 * @date 2018/6/14 11:18
 */
public class PieView extends View {

    private Paint mPaint = new Paint();
    private List<DataBean> list = new ArrayList<>();
    private float radius = 200;
    private float startAngle = -90;

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initPaint();
    }

    private void initPaint() {
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(1f);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.GRAY);
        RectF rectF = new RectF(getWidth() / 2 - this.radius, getHeight() / 2 - this.radius, getWidth() / 2 + this.radius, getHeight() / 2 + this.radius);
        canvas.drawOval(rectF, mPaint);
        if (this.list.isEmpty()) {
            return;
        }
        for (DataBean dataBean : this.list) {
            mPaint.setColor(dataBean.getColor());
            canvas.drawArc(rectF, startAngle, dataBean.getAngle(), true, mPaint);
            startAngle += dataBean.getAngle();
        }
    }

    /**
     * 设置数据
     *
     * @param list
     */
    public void setData(List<DataBean> list) {
        calculatorAngle(list);
        this.list = list;
        invalidate();
    }

    /**
     * 重写invalidate重置startAngle
     */
    @Override
    public void invalidate() {
        super.invalidate();
        startAngle = -90;
    }

    /**
     * 计算相关角度
     *
     * @param list
     */
    public void calculatorAngle(List<DataBean> list) {
        double sum = 0f;
        for (DataBean dataBean : list) {
            sum += dataBean.getValue();
        }
        for (DataBean dataBean : list) {
            dataBean.setAngle((float) (dataBean.getValue() / sum * 360));
        }
    }

}
