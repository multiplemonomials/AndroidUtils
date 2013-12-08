package com.multiplemonomials.androidutils.bindtoview;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * This is like a BindToAdapterView except it works with a a spinner
 * @author Jamie
 *
 */


public class BindToButton extends Binder<Button, Button> implements OnClickListener
{

	public BindToButton(Object target) {
		super(target);
		// TODO Auto-generated constructor stub
	}

	@Override
	void setListener(Button toListen) 
	{
		toListen.setOnClickListener(this);
	}

	@Override
	Class<?>[] getArgsClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{View.class};
	}

	@Override
	public void onClick(View v) {
		Log.i(TAG, "Button ID: " + v.getId());
		super.onItemClick((Button)v);
		
	}
	
	boolean debugMode()
	{
		return false;
	}
	
	@Override
	void subBind(Button position)
	{
		position.setOnClickListener(this);
	}

}

