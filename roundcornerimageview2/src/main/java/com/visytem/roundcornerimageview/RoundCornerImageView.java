package com.visytem.roundcornerimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by zhangmeng on 2017/6/5.
 */

public class RoundCornerImageView extends AppCompatImageView {

    private float roundCorner;

    public RoundCornerImageView(Context context) {
        this(context, null);
    }

    public RoundCornerImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RoundCornerImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundCornerImageView);
        roundCorner = typedArray.getFloat(R.styleable.RoundCornerImageView_roundCorner, 10.0f);
        typedArray.recycle();


    }


    @Override
    protected void onDraw(Canvas canvas) {
        Path path = new Path();
        int w = getWidth();
        int h = getHeight();
        path.addRoundRect(new RectF(0, 0, w, h), roundCorner, roundCorner, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
