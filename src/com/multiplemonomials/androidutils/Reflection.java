package com.multiplemonomials.androidutils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {
	
	public void callMethodByName(Class<Object> classType, String name, Object target, Object... arguments)
	{
		Class<?> [] argumentClasses = new Class<?>[arguments.length];
		int counter = 0;
		for(Object object:arguments)
		{
			argumentClasses[counter++] = object.getClass();
		}
		
		Method m;
		try {
			m = classType.getClass().getMethod(name, argumentClasses);
			m.invoke(target, arguments);
		} catch (NoSuchMethodException exceptionName) {
			// TODO Auto-generated catch block
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
	
	

}
