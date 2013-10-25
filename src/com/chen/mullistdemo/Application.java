package com.chen.mullistdemo;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;

import com.chen.mullistdemo.activity.ImageLoaderActivity;
import com.chen.mullistdemo.activity.ImageRequestActivity;
import com.chen.mullistdemo.activity.JsonRequestAcitivity;
import com.chen.mullistdemo.activity.NetWorkIVActivity;
import com.chen.mullistdemo.activity.WaterfallActivity;
import com.chen.mullistdemo.bean.ListItemBean;
import com.chen.mullistdemo.tool.VolleyTool;


/**
 * 目前没什么可做
 * @author chen
 *
 */
public class Application extends android.app.Application {
	private List<ListItemBean> items = new ArrayList<ListItemBean>();
	@Override
	public void onCreate() {
		super.onCreate();
		initMainItems();
	}

	private void initMainItems() {
		items.add(new ListItemBean("WaterFall",new Intent(this,WaterfallActivity.class)));
		items.add(new ListItemBean("ImageRequest",new Intent(this,ImageRequestActivity.class)));
		items.add(new ListItemBean("ImageLoader",new Intent(this,ImageLoaderActivity.class)));
		items.add(new ListItemBean("JsonRequest",new Intent(this,JsonRequestAcitivity.class)));
		items.add(new ListItemBean("NetworkImageView",new Intent(this,NetWorkIVActivity.class)));
	}
	
	public List<ListItemBean> getItems() {
		return items;
	}

	@Override
	public void onTerminate() {
		VolleyTool.getInstance(this).release();
		super.onTerminate();
	}
	
	
}
