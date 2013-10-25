package com.chen.mullistdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.chen.mullistdemo.R;
import com.chen.mullistdemo.tool.VolleyTool;

public class ImageLoaderAdapter extends BaseAdapter {
	private Context context;
	private String[] urls;
	public ImageLoaderAdapter(Context ctx, String[] urls) {
		this.context = ctx;
		this.urls = urls;
	}

	@Override
	public int getCount() {
		return urls.length;
	}

	@Override
	public String getItem(int position) {
		// TODO Auto-generated method stub
		return urls[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		NetWorkAdapterHolder holder;
		if(convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
			holder = new NetWorkAdapterHolder();
			holder.itemImage = (ImageView) convertView.findViewById(R.id.itemImage);
			holder.itemText = (TextView) convertView.findViewById(R.id.itemText);
			convertView.setTag(holder);
		} else {
			holder = (NetWorkAdapterHolder) convertView.getTag();
		}
		String url = getItem(position);
		//android.R.drawable.ic_menu_rotate代表默认图 
		//android.R.drawable.ic_delete代表加载失败的图
		ImageListener listener = ImageLoader.getImageListener(holder.itemImage, 
				android.R.drawable.ic_menu_rotate, android.R.drawable.ic_delete);
		VolleyTool.getInstance(context).getmImageLoader().get(url, listener);
		return convertView;
	}
	
	class NetWorkAdapterHolder {
		ImageView itemImage;
		TextView itemText;
	}

}
