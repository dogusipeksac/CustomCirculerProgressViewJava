
package com.example.customcirculerprogressbarjava;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Paint.Cap;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;


public class CircularProgressView extends View {
    private final Paint progressPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint backgroundPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private  RectF rect=new RectF();
    private  float startAngle = 90f;
    private  float maxAngle = 360f;
    private  int maxProgress = 100;
    private  float diameter = 0f;
    private float  angle = 0f;


    public CircularProgressView(Context context) {
        super(context);

    }

    public CircularProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircularProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircularProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        progressPaint.setStyle(Paint.Style.STROKE);
        backgroundPaint.setStyle(Paint.Style.STROKE);
        drawCircle(this.maxAngle, canvas, backgroundPaint);
        drawCircle(angle, canvas, progressPaint);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        diameter = (float) Math.min(width, height);
        updateRect();
    }

    private void updateRect() {
        float strokeWidth = backgroundPaint.getStrokeWidth();
        rect.set(strokeWidth, strokeWidth, diameter - strokeWidth, diameter - strokeWidth);
    }

    private void drawCircle(float angle, Canvas canvas, Paint paint) {
        canvas.drawArc(this.rect, this.startAngle, angle, false, paint);
    }

    private  float calculateAngle(float progress) {
        return this.maxAngle / (float)this.maxProgress * progress;
    }

    public  void setProgress(@FloatRange(from = 0.0D,to = 100.0D) float progress) {
        this.angle = this.calculateAngle(progress);
        this.invalidate();
    }

    public  void setProgressColor(int color) {
        this.progressPaint.setColor(color);
        this.invalidate();
    }

    public  void setProgressBackgroundColor(int color) {
        this.backgroundPaint.setColor(color);
        this.invalidate();
    }

    public  void setProgressWidth(float width) {
        progressPaint.setStrokeWidth(width);
        backgroundPaint.setStrokeWidth(width);
        this.updateRect();
        this.invalidate();
    }

    public  void setRounded(boolean rounded) {
        this.progressPaint.setStrokeCap(rounded ? Cap.ROUND : Cap.BUTT);
        this.invalidate();
    }




}
