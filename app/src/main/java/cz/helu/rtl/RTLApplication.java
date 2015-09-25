package cz.helu.rtl;


import android.app.Application;


public class RTLApplication extends Application
{
	private static RTLApplication mInstance;


	public static RTLApplication getContext()
	{
		return mInstance;
	}


	public RTLApplication()
	{
		mInstance = this;
	}


	@Override
	public void onCreate()
	{
		super.onCreate();
	}
}
