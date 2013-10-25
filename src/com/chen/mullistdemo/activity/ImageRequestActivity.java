package com.chen.mullistdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.chen.mullistdemo.R;
import com.chen.mullistdemo.adapter.MyAdapter;
import com.chen.mullistdemo.adapter.NetWorkAdapter;
import com.chen.mullistdemo.bean.UrlBean;
import com.huewu.pla.lib.MultiColumnListView;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.PLA_AbsListView.OnScrollListener;

public class ImageRequestActivity extends Activity implements OnScrollListener{
	private MultiColumnListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int itemWidth = (width - 20)/3; //随便写了个20 限定大小，不限定也可以
        listView = (MultiColumnListView) findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter(this,UrlBean.urls,itemWidth));
        listView.setOnScrollListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onScrollStateChanged(PLA_AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onScroll(PLA_AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		
	}
    
}
