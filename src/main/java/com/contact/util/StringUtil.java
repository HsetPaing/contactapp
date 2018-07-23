package com.contact.util;


/**
 * This class contains utility methods related to String operations.
 * @author HsetPaing
 *
 */
public class StringUtil {

	public static String toCommaSeparateString(Object[] items) {
		StringBuilder sb = new StringBuilder();
		for (Object item : items) {
			sb.append(item).append(",");
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

}
