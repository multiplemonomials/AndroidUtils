package com.multiplemonomials.androidutils.bindtoview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

/**
 * This is like a BindToAdapterView except it works with a a spinner
 * @author Jamie
 *
 */


public class BindToSpinner extends Binder<Spinner, Integer> implements OnItemSelectedListener
{

	public BindToSpinner(Spinner source, Object target) {
		super(source, target);
		// TODO Auto-generated constructor stub
	}

	@Override
	void setListener(Spinner toListen) 
	{
		toListen.setOnItemSelectedListener(this);
	}

	@Override
	Class<?>[] getArgsClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{View.class, int.class, long.class};
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) 
	{
		super.onItemClick(position, view, position, id);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

}

