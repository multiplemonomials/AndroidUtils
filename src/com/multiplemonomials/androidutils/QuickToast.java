package com.multiplemonomials.androidutils;

import android.content.Context;
import android.widget.Toast;

public class QuickToast {
	
	Context context;
	
	public void showQuickToast(String toShow)
	{
		Toast toast = Toast.makeText(context, toShow, Toast.LENGTH_SHORT);
		toast.show();
	}
	
	public QuickToast(Context context)
	{
		this.context = context;
	}

}
