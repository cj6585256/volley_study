package com.chen.mullistdemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import com.chen.mullistdemo.R;

public class MainActivity extends Activity implements OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.imageCacheBtn).setOnClickListener(this);
        findViewById(R.id.imageRequestBtn).setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.imageCacheBtn:
			intent = new Intent(this,NetworkActivity.class);
			break;
		case R.id.imageRequestBtn:
			intent = new Intent(this,ImageRequestActivity.class);
			break;
		default:
			break;
		}
		startActivity(intent);
	}
}
