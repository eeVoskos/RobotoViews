package com.eevoskos.robotoviews.sample;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> items = new ArrayList<String>();
        items.add(getString(R.string.sample_textview));
        items.add(getString(R.string.sample_button));
        items.add(getString(R.string.sample_edittext));
        items.add(getString(R.string.sample_autocompletetextview));

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, items));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(this, SampleActivity.class);
        String title = (String) l.getItemAtPosition(position);
        if (TextUtils.equals(title, getString(R.string.sample_textview))) {
            intent.putExtra(SampleActivity.EXTRA_LAYOUT_ID, R.layout.activity_sample_textview);
        } else if (TextUtils.equals(title, getString(R.string.sample_edittext))) {
            intent.putExtra(SampleActivity.EXTRA_LAYOUT_ID, R.layout.activity_sample_edittext);
        } else if (TextUtils.equals(title, getString(R.string.sample_button))) {
            intent.putExtra(SampleActivity.EXTRA_LAYOUT_ID, R.layout.activity_sample_button);
        } else if (TextUtils.equals(title, getString(R.string.sample_autocompletetextview))) {
            intent.putExtra(SampleActivity.EXTRA_LAYOUT_ID,
                    R.layout.activity_sample_autocompletetextview);
        } else {
            return;
        }
        intent.putExtra(SampleActivity.EXTRA_TITLE, title);
        startActivity(intent);
    }

}
