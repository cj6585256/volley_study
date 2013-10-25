package com.chen.mullistdemo.adapter;

import java.util.List;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chen.mullistdemo.bean.ListItemBean;

public class MainAdapter extends BaseAdapter {
	private Context context;
	private List<ListItemBean> items;
	public MainAdapter(Context context, List<ListItemBean> items) {
		this.context = context;
		this.items = items;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public ListItemBean getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView textView = null;
		if(convertView == null) {
			textView = new TextView(context);
			textView.setPadding(8, 8, 8, 8);
			textView.setGravity(Gravity.CENTER);
			textView.setTextSize(20);
			textView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
			convertView = textView;
		} 
		((TextView)convertView).setText(getItem(position).getName());
		return convertView;
	}


}
