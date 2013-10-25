package com.chen.mullistdemo.bean;

import java.io.Serializable;

import android.content.Intent;

public class ListItemBean implements Serializable{
	/**
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Intent intent;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Intent getIntent() {
		return intent;
	}
	public void setIntent(Intent intent) {
		this.intent = intent;
	}
	public ListItemBean(String name, Intent intent) {
		super();
		this.name = name;
		this.intent = intent;
	}
	
}
