package com.multiplemonomials.androidutils.bindtoview;

import android.view.Menu;
import android.view.MenuItem;

/** 
 * Allows you to bind positions on a menu to functions in your class.
 * 
 * Call
 * {@code}
 * bindToMenu.bind(R.id.menu_settings, "onClickSettings")
 * to bind void onClickSettings(MeniItem foo) in your class to R.id.menu_settings
 * 
 * @author jamie
 *
 */
public class BindToMenu extends Binder<Menu, Integer>
{

	public BindToMenu(Object target) {
		super(null, target);
		// TODO Auto-generated constructor stub
	}

	@Override
	void setListener(Menu toListen) {
		
	}
	
	public void onOptionsItemSelected(MenuItem menuItem)
	{
		super.onItemClick(menuItem.getItemId(), menuItem);
	}

	@Override
	Class<?>[] getArgsClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[]{MenuItem.class};
	}

}
