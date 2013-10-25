package com.chen.mullistdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.chen.mullistdemo.R;
import com.chen.mullistdemo.R.id;
import com.chen.mullistdemo.R.layout;
import com.chen.mullistdemo.cache.BitmapCache;

public class NetWorkAdapter extends BaseAdapter {
	private Context context;
	private String[] urls;
    private ImageLoader mImageLoader;
	public NetWorkAdapter(Context ctx, String[] urls) {
		this.context = ctx;
		this.urls = urls;
		mImageLoader = new ImageLoader(Volley.newRequestQueue(ctx), new BitmapCache());
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
		ImageListener listener = ImageLoader.getImageListener(holder.itemImage, android.R.drawable.ic_menu_rotate, android.R.drawable.ic_delete);
        mImageLoader.get(url, listener);
		return convertView;
	}
	
	class NetWorkAdapterHolder {
		ImageView itemImage;
		TextView itemText;
	}

}
