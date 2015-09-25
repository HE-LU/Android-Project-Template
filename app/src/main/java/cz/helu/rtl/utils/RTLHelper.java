package cz.helu.rtl.utils;

import java.util.Locale;


public class RTLHelper
{
	public static boolean isRTL() {
		return isRTL(Locale.getDefault());
	}

	public static boolean isRTL(Locale locale) {
		final int directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
		return directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT ||
				directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC;
	}
}
