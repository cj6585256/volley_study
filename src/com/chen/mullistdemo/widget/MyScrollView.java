package com.chen.mullistdemo.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;

/**
 * 
 * @author chen
 *
 */
public class MyScrollView extends ScrollView implements OnTouchListener{
	private ScrollCallBack scrollCallBack;
	private View view;
	private Handler refrshHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case 1:
				//view.getMeasuredHeight()代表LinearLayout需要的高度
				//getScrollY()代表Y轴的上边线 +getHeight()固定不变的屏幕高度，如果大于原有LinearLayout高度则证明是向上划
//				System.out.println("===getScrollY()"+getScrollY());
//				System.out.println("===getHeight()"+getHeight());
				if (view.getMeasuredHeight() <= getScrollY() + getHeight()) {  
                    if (scrollCallBack != null) {  
                    	scrollCallBack.onBottom();  
                    }  

                } else if (getScrollY() == 0) {  
                    if (scrollCallBack != null) {  
                    	scrollCallBack.onTop();  
                    }  
                } else {  
                    if (scrollCallBack != null) {  
                    	scrollCallBack.onScroll();  
                    }  
                }  
				break;

			default:
				break;
			}
		}
		
	};
    
	public MyScrollView(Context context) {
		super(context);
	}

	public MyScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	public MyScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		System.out.println();
		return super.dispatchKeyEvent(event);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			return super.onTouchEvent(event);
		case MotionEvent.ACTION_UP:
			  if (view != null && scrollCallBack != null) {  
				  refrshHandler.sendMessageDelayed(refrshHandler.obtainMessage(1), 200);  
              }  
			return true;
		default:
			break;
		}
		return super.onTouchEvent(event);
	}
	
	public int computeVerticalScrollRange() {
		return super.computeVerticalScrollRange();
	}
	
	public int computeVerticalScrollOffset() {  
	    return super.computeVerticalScrollOffset();  
	}  
	
	
	public void setScrollCallBack(ScrollCallBack scrollCallBack) {  
        this.scrollCallBack = scrollCallBack; 
        this.view = getChildAt(0); //为了获得它的MeasuredHeight，然后和滚动条的ScrollY+getHeight作比较。
		this.setOnTouchListener(this);
    }  
	
	/**
	 * 
	 *接口回调
	 */
	public interface ScrollCallBack {
		public void onTop();
		public void onBottom();
		public void onScroll();
	}
}
