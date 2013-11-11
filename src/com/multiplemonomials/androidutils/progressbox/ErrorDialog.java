package com.multiplemonomials.androidutils.progressbox;

import com.multiplemonomials.androidutils.R;

import android.app.AlertDialog;
import android.content.Context;

public class ErrorDialog 
{
	public static void showErrorDialog(Context context, String title, String message)
	{
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		alertDialogBuilder.setTitle(title);
		alertDialogBuilder.setMessage(message);
		alertDialogBuilder.setIcon(R.drawable.ic_launcher);
		alertDialogBuilder.setPositiveButton(android.R.string.ok, null);
		alertDialogBuilder.show();
	}
	
	//this overload is for using r.strings
	public static void showErrorDialog(Context context, int title, String message)
	{
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		alertDialogBuilder.setTitle(title);
		alertDialogBuilder.setMessage(message);
		alertDialogBuilder.setIcon(R.drawable.ic_launcher);
		alertDialogBuilder.setPositiveButton(android.R.string.ok, null);
		alertDialogBuilder.show();
	}
}
