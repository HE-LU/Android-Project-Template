package cz.helu.rtl.utility;

import android.view.View;

import java.util.Locale;


public class RTLHelper
{
	public static boolean isDefaultLocaleRTL()
	{
		return isLocaleRTL(Locale.getDefault());
	}


	public static boolean isLocaleRTL(Locale locale)
	{
		final int directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
		return directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT ||
				directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
	}


	public static void setRTL(View view)
	{
		view.setTextDirection(View.TEXT_DIRECTION_RTL);
		view.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
	}


	public static void setLTR(View view)
	{
		view.setTextDirection(View.TEXT_DIRECTION_LTR);
		view.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
	}


	public static void setDirectionToView(View view)
	{
		if(RTLHelper.isDefaultLocaleRTL())
			RTLHelper.setRTL(view);
		else
			RTLHelper.setLTR(view);
	}
}
