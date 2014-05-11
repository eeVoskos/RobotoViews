package com.eevoskos.robotoviews.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Switch;

import com.eevoskos.robotoviews.R;
import com.eevoskos.robotoviews.Roboto;

@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public class RobotoSwitch extends Switch {
	public RobotoSwitch(Context context) {
        super(context);
        robotize(context, null, 0);
    }

    public RobotoSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        robotize(context, attrs, 0);
    }

    public RobotoSwitch(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        robotize(context, attrs, defStyle);
    }

    private void robotize(Context context, AttributeSet attrs, int defStyle) {
        if (isInEditMode()) {
            return;
        }
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.RobotoSwitch,
                defStyle, 0);
        int value = 0;
        try {
            value = a.getInteger(R.styleable.RobotoSwitch_typeface, 0);
        } finally {
            a.recycle();
        }
        Typeface typeface = Roboto.getInstance(context).getTypeface(value);
        setTypeface(typeface);
    }
}