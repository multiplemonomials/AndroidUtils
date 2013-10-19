package com.multiplemonomials.androidutils.stickyobject;

import android.os.Parcel;
import android.os.Parcelable;

public class StickyObject implements Parcelable{
	
	Object object;
	
	public Object getObject()
	{
		return object;
	}
	
	public StickyObject(Object object)
	{
		this.object = object;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	 public static final Parcelable.Creator<StickyObject> CREATOR = new Parcelable.Creator<StickyObject>() {
	        public StickyObject createFromParcel(Parcel in) {
	            return new StickyObject(in);
	        }
	 
	        public StickyObject[] newArray(int size) {
	            return new StickyObject[size];
	        }
	    };

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
	}
	
	

}
