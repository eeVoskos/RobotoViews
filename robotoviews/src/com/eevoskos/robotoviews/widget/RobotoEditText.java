package com.eevoskos.robotoviews.widget;

import com.eevoskos.robotoviews.R;
import com.eevoskos.robotoviews.Roboto;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class RobotoEditText extends EditText {

    public RobotoEditText(Context context) {
        super(context);
        robotize(context, null, 0);
    }

    public RobotoEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        robotize(context, attrs, 0);
    }

    public RobotoEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        robotize(context, attrs, defStyle);
    }

    private void robotize(Context context, AttributeSet attrs, int defStyle) {
        if (isInEditMode()) {
            return;
        }
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.RobotoEditText,
                defStyle, 0);
        int value = 0;
        try {
            value = a.getInteger(R.styleable.RobotoEditText_typeface, 0);
        } finally {
            a.recycle();
        }
        Typeface typeface = Roboto.getInstance(context).getTypeface(value);
        setTypeface(typeface);
    }

}
