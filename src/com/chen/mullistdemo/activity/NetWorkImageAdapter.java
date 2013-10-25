package com.chen.mullistdemo.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.chen.mullistdemo.R;
import com.chen.mullistdemo.tool.VolleyTool;

public class NetWorkImageAdapter extends BaseAdapter {
	private Context context;
	private String[] urls;
	public NetWorkImageAdapter(Context context,
			String[] urls) {
		this.context = context;
		this.urls = urls;
	}

	@Override
	public int getCount() {
		return urls.length;
	}

	@Override
	public String getItem(int position) {
		return urls[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		NetWorkHolder holder = null;
		if( null == convertView ) {
			convertView = LayoutInflater.from(context).inflate(R.layout.network_imageview_item, null);
			holder = new NetWorkHolder();
			holder.itemImage = (NetworkImageView) convertView.findViewById(R.id.itemImage);
			holder.itemText = (TextView) convertView.findViewById(R.id.itemText);
			convertView.setTag(holder);
		} else {
			holder = (NetWorkHolder) convertView.getTag();
		}
		String url = getItem(position);
		//NetworkImageView  setDefaultImageResId()设置默认图
		//setErrorImageResId()设置下载出错的图
		holder.itemImage.setImageUrl(url, VolleyTool.getInstance(context).getmImageLoader());
		holder.itemText.setText(url.substring(url.length() - 8));
		return convertView;
	}
	
	class NetWorkHolder {
		NetworkImageView itemImage;
		TextView itemText;
	}
}
