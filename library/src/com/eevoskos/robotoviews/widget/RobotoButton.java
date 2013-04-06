package com.eevoskos.robotoviews.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import com.eevoskos.robotoviews.R;
import com.eevoskos.robotoviews.Roboto;

public class RobotoButton extends Button {

    public RobotoButton(Context context) {
        super(context);
        robotize(context, null, 0);
    }

    public RobotoButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        robotize(context, attrs, 0);
    }

    public RobotoButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        robotize(context, attrs, defStyle);
    }

    private void robotize(Context context, AttributeSet attrs, int defStyle) {
        if (isInEditMode()) {
            return;
        }
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.RobotoButton,
                defStyle, 0);
        int value = 0;
        try {
            value = a.getInteger(R.styleable.RobotoButton_typeface, 0);
        } finally {
            a.recycle();
        }
        Typeface typeface = Roboto.getInstance(context).getTypeface(value);
        setTypeface(typeface);
    }

}
