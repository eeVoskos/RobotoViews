
package com.eevoskos.robotoviews.sample;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.eevoskos.robotoviews.Roboto;
import com.eevoskos.robotoviews.widget.RobotoCheckedTextView;

public class RobotoCheckedTextViewSampleFragment extends ListFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new RobotoCheckedTextViewAdapter());
    }

    class RobotoCheckedTextViewAdapter extends BaseAdapter {

        Roboto roboto;
        LayoutInflater inflater;
        SparseBooleanArray checked = new SparseBooleanArray();

        RobotoCheckedTextViewAdapter() {
            roboto = Roboto.getInstance(getActivity());
            inflater = LayoutInflater.from(getActivity());
        }

        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public String getItem(int position) {
            return roboto.getTypeface(position).toString();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = inflater.inflate(R.layout.list_item_checkedtextview, parent, false);
            final RobotoCheckedTextView ctv = (RobotoCheckedTextView) view.findViewById(R.id.text);
            ctv.setChecked(checked.get(position));
            ctv.setTypeface(roboto.getTypeface(position));
            ctv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ctv.toggle();
                    checked.append(position, ctv.isChecked());
                }
            });
            return view;
        }

    }

}
