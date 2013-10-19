package com.multiplemonomials.androidutils;

import android.os.Handler;

public class HandlerHolder {
	
	public final static int DONE = 1;
	public final static int CANCELED = 2;
	public final static int ERROR = 3;
	public final static int TEXTMESSAGE = 4;
	public final static int GENERICRESULT = 5;
	public final static int GENERICGUIUPDATE = 6;
	
	private static HandlerHolder instance = null;
	
	public Handler handler;
	
	protected HandlerHolder()
	{
		
	}
	
	public static HandlerHolder getInstance()
	{
		if(instance == null)
		{
			instance = new HandlerHolder();
		}
		
		return instance;
	}
}
