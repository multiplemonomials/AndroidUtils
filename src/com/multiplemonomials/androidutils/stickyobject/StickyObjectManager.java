package com.multiplemonomials.androidutils.stickyobject;

import java.io.Serializable;
import java.util.HashMap;

import android.os.Bundle;
import android.util.Log;

public class StickyObjectManager {
	
	static final String STICKY_OBJECT_MANAGER_KEY = "StickyObjects";

	private static final String TAG = "StickyObjectManager";
	
	HashMap<String, StickyObject> objects;
	
	public void onSaveInstanceState(Bundle bundle)
	{
		for(String key : objects.keySet())
		{
			bundle.putParcelable(key, objects.get(key));
		}
		
		bundle.putSerializable(STICKY_OBJECT_MANAGER_KEY, objects);
	}
	
	@SuppressWarnings("unchecked")
	public StickyObjectManager(Bundle bundle)
	{
		if(bundle == null)
		{
			objects = new HashMap<String, StickyObject>();
			return;
		}
		
		Serializable serializable = bundle.getSerializable(STICKY_OBJECT_MANAGER_KEY);
		if(serializable instanceof HashMap<?, ?>)
		{
			objects = (HashMap<String, StickyObject>) serializable;
		}
		else
		{
			Log.e(TAG, "Something went wrong");
			Log.e(TAG, "object we pulled out of savedInstanceState was not a hashmap");
			Log.e(TAG, "are you using the key, \"StickyObjects\"");
		}
		
		assert(objects != null);
		
		for(String key : objects.keySet())
		{
			objects.put(key, (StickyObject) bundle.getParcelable(key));
		}
	}
	
	public void put(Object object, String key)
	{
		StickyObject stickyObject = new StickyObject(object);
		objects.put(key, stickyObject);
	}
	
	public Object get(String key)
	{
		assert(objects != null);
		StickyObject stickyObject = objects.get(key);
		assert(stickyObject != null);
		return stickyObject.getObject();
	}

}
