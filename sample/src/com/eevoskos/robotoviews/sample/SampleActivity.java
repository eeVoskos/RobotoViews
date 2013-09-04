package com.eevoskos.robotoviews.sample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class SampleActivity extends FragmentActivity {

    public static final String EXTRA_LAYOUT_ID = "layout_id";
    public static final String EXTRA_TITLE = "title_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutResId = getIntent().getIntExtra(EXTRA_LAYOUT_ID, 0);
        String title = getIntent().getStringExtra(EXTRA_TITLE);
        setContentView(layoutResId);
        setTitle(title);
    }

}
