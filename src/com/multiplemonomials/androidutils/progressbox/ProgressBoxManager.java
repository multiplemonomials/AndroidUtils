package com.multiplemonomials.androidutils.progressbox;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressBoxManager 
{
	Context someContext;
	
	ProgressDialog progressDialog;
	
	public ProgressBoxManager(Context context)
	{
		someContext = context;
	}

	public void updateLayerProgressBar(int progress)
	{
		if(progressDialog != null)
		{
			progressDialog.setMessage("Parsing Layer " + progress + "...");
		}
		
	}
	
	public void closeLayerProgressBar()
	{
		if(progressDialog != null)
		{
			progressDialog.dismiss();
		}
		
	}

	
	public void showLayerProgressBar(String title, String text)
	{
		progressDialog = new ProgressDialog(someContext);
		progressDialog.setTitle(title);
		progressDialog.setMessage(text);
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.show();
		
	}
}
