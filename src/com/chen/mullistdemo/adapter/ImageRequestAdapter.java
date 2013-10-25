package com.chen.mullistdemo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.ImageRequest;
import com.chen.mullistdemo.R;
import com.chen.mullistdemo.activity.ImageRequestActivity;
import com.chen.mullistdemo.tool.VolleyTool;

public class ImageRequestAdapter extends BaseAdapter { //implements Listener<Bitmap>,ErrorListener{
	private Context context;
	private String[] urls;	
	private int itemWidth;
	public ImageRequestAdapter(Context context, String[] urls, int itemWidth) {
		this.context = context;
		this.urls = urls;
		this.itemWidth = itemWidth;
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
		if(convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.imageloader_item,null);
		}
		final ImageView itemImage = (ImageView) convertView.findViewById(R.id.itemImage);
		TextView itemText = (TextView) convertView.findViewById(R.id.itemText);
		String url = getItem(position);
		RequestQueue requestQueue = VolleyTool.getInstance(context).getmRequestQueue();
		ImageRequest request = (ImageRequest) requestQueue.add(
				new ImageRequest(url, new Listener<Bitmap>() {

					@Override
					public void onResponse(Bitmap response) {
						itemImage.setImageBitmap(response);
					}
				}, itemWidth, 0, Config.RGB_565, null));
		request.setTag(ImageRequestActivity.class.getSimpleName());
		request.setShouldCache(true);
		//默认缓存位置data/data/包名/cache/volley,默认大小5MB
		//修改缓存默认存储位置和存储区大小帖子上面有介绍
		itemText.setText(url.substring(url.length() - 8));
		return convertView;
	}
	
	class MyAdapterHolder {
		ImageView itemImage;
		TextView itemText;
	}
}
