package com.eevoskos.robotoviews.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import com.eevoskos.robotoviews.R;
import com.eevoskos.robotoviews.Roboto;

public class RobotoAutoCompleteTextView extends AutoCompleteTextView {

    public RobotoAutoCompleteTextView(Context context) {
        super(context);
        robotize(context, null, 0);
    }

    public RobotoAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        robotize(context, attrs, 0);
    }

    public RobotoAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        robotize(context, attrs, defStyle);
    }

    private void robotize(Context context, AttributeSet attrs, int defStyle) {
        if (isInEditMode()) {
            return;
        }
        TypedArray a = getContext().obtainStyledAttributes(attrs,
                R.styleable.RobotoAutoCompleteTextView, defStyle, 0);
        int value = 0;
        try {
            value = a.getInteger(R.styleable.RobotoAutoCompleteTextView_typeface, 0);
        } finally {
            a.recycle();
        }
        Typeface typeface = Roboto.getInstance(context).getTypeface(value);
        setTypeface(typeface);
    }

}
