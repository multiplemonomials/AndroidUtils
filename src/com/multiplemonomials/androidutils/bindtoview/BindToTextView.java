package com.multiplemonomials.androidutils.bindtoview;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class BindToTextView implements OnClickListener{
	String _format;
	Object[] _things;
	TextView _textView;
	
	public BindToTextView(TextView textView, String format, Object... things)
	{
		this._format = format;
		this._things = things;
		this._textView = textView;
	}
	
	public void onClick(View view)
	{
		String text = String.format(_format, _things);
		_textView.setText(text);
	}

}
