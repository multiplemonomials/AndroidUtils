package com.multiplemonomials.androidutils.bindtoview;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class BindToAdapterView extends Binder<AdapterView<?>, Integer> implements OnItemClickListener
{

	public BindToAdapterView(AdapterView<?> source, Object target) {
		super(source, target);
		// TODO Auto-generated constructor stub
	}

	@Override
	void setListener(AdapterView<?> toListen) 
	{
		toListen.setOnItemClickListener(this);
	}

	@Override
	Class<?>[] getArgsClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{View.class, int.class, long.class};
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) 
	{
		super.onItemClick(position, view, position, id);
	}



}

