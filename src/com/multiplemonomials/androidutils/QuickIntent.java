package com.multiplemonomials.androidutils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class QuickIntent {
	
	public static void callQuickIntent(Activity activity, Uri uri, String intentData)
	{
		Intent intent = new Intent();
		intent.setAction(intentData);
		intent.setData(uri);
		activity.startActivity(intent);
	}

}
