package pub.kanzhibo.app.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtils {

	public static String SP_NAME = "config";
	private static SharedPreferences sp;

	/**
	 * SharedPreferences 保存boolean
	 * 
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void saveBoolean(Context context, String key, boolean value) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		sp.edit().putBoolean(key, value).commit();
	}

	public static boolean getBoolean(Context context,String key,boolean defValue){
		if(sp == null) {
			sp = context.getSharedPreferences(SP_NAME, 0);
		
		}
		return sp.getBoolean(key, defValue);
	}
	
	
	
	
	/**
	 * SharedPreferences 保存字符串
	 * @param context
	 * @param key
	 * @param value
	 */
	public static void saveString(Context context, String key, String value) {
		if (sp == null)
			sp = context.getSharedPreferences(SP_NAME, 0);
		sp.edit().putString(key, value).commit();
	}

	public static String getString(Context context,String key,String defValue){
		if(sp == null) {
			sp = context.getSharedPreferences(SP_NAME, 0);
		
		}
		return sp.getString(key, defValue);
	}
	
	
}
