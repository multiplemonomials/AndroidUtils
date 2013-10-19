package com.multiplemonomials.androidutils.bindtoview;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import android.util.Log;

/**
 * This is the base class for a set of classes that bind UI elements to functions.
 * 
 * @author Jamie
 *
 */
public abstract class Binder<T1, KeyType>
{



	
	HashMap<KeyType, String> function_map;
	
	/**
	 * The object that the bound methods are called from.
	 */
	Object _boundTo;
	
	String TAG = "BindToListView";
	
	abstract Class<?>[] getArgsClasses();
	
	public Binder(T1 adapterView, Object target)
	{
		setListener(adapterView);
		_boundTo = target;
		
		function_map = new HashMap<KeyType, String>();
	}
	
	public Binder(Object target)
	{
		_boundTo = target;
		
		function_map = new HashMap<KeyType, String>();
	}
	
	public String getStringForPosition(KeyType key)
	{
		return "position " + key.toString();
	}
	
	abstract void setListener(T1 toListen);
	
	public void onItemClick(KeyType position, Object... args) 
	{
		
		//get the name of the method to call
		//hopefully this will always return a string
		String functionToCall = function_map.get(position);
		assert(functionToCall != "");
		
		if(functionToCall == null)
		{
			Log.e(TAG, "No binding for position " + position);
			return;
		}
		
		try 
		{
			Method m = _boundTo.getClass().getMethod(functionToCall, getArgsClasses());
			m.invoke(_boundTo, args);
		} 
		catch (NoSuchMethodException exceptionName) 
		{
			// TODO Auto-generated catch block
			Log.e(TAG, "Could not find method " + functionToCall);
			exceptionName.printStackTrace();
		} catch (IllegalArgumentException exceptionName) {
			// TODO Auto-generated catch block
			exceptionName.printStackTrace();
		} catch (IllegalAccessException exceptionName) {
			// TODO Auto-generated catch block
			exceptionName.printStackTrace();
		} catch (InvocationTargetException exceptionName) {
			// TODO Auto-generated catch block
			exceptionName.printStackTrace();
		}
		
		
	}
	
	boolean debugMode()
	{
		return true;
	}
	
	/**
	 * binds the specified position in the |T1| to a function in the class it was constructed with
	 * position starts at 0.
	 * 
	 * For example, 
	 * bindToListView.bind(0, "onFoo");
	 * would call the function
	 * <pre>
	 * {@code
	 * public void onFoo(View view, int position, long id)
	 *{
	 *	//foo
	 *}
	 *}
	 *</pre>
	when position 0 in the list view was pressed
	 * 
	 * @param position
	 * @param functionName
	 */
	public void bind(KeyType position, String functionName)
	{
		subBind(position);
		assert(functionName != null);
		assert(position != null);
		assert(function_map != null);
		if(debugMode())
		{
			Log.d(TAG, position.toString());
			Log.d(TAG, functionName);
		}
		function_map.put(position, functionName);
	}
	
	void subBind(KeyType position)
	{
		
	}


}
