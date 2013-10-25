package com.chen.mullistdemo.activity;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.chen.mullistdemo.R;
import com.chen.mullistdemo.tool.VolleyTool;

/**
 * jsonRequest
 * @author chen
 *
 */
public class JsonRequstAcitivity extends Activity implements OnClickListener,Listener<JSONObject>,ErrorListener{
	private Button requestBtn;
	private TextView dispText;
	private static final String URL = "http://httpbin.org/get?param1=hello";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_json_request);
		requestBtn = (Button) findViewById(R.id.requestBtn);
		dispText = (TextView) findViewById(R.id.dispText);
		requestBtn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		doJsonRequest();
	}
	
	private void doJsonRequest() {
		//第三个参数
		//A JSONObject to post with the request. Null is allowed and indicates no parameters will be posted along with request.
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
				Request.Method.GET,URL,null, JsonRequstAcitivity.this,JsonRequstAcitivity.this);
		VolleyTool.getInstance(this).getmRequestQueue().add(jsonObjectRequest);
	}
	@Override
	public void onResponse(JSONObject response) {
		//success 
		dispText.setText("Success::"+response.toString());
	}
	@Override
	public void onErrorResponse(VolleyError error) {
		dispText.setText("Fail::"+error.toString());
	}
}
