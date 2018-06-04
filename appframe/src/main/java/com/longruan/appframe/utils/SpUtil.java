package com.longruan.appframe.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class SpUtil {
	private SharedPreferences settings;

	public SpUtil(Context context) {
		settings = PreferenceManager.getDefaultSharedPreferences(context);
	}

	public String getSpString(String key, final String defaultValue) {
		return settings.getString(key, defaultValue);
	}

	public void setSpString(final String key, final String value) {
		settings.edit().putString(key, value).commit();
	}

	public boolean getSpBoolean(final String key, final boolean defaultValue) {
		return settings.getBoolean(key, defaultValue);
	}

	public boolean hasKey(final String key) {
		return settings.contains(key);
	}

	public void setSpBoolean(final String key, final boolean value) {
		settings.edit().putBoolean(key, value).commit();
	}

	public void setSpInt(final String key, final int value) {
		settings.edit().putInt(key, value).commit();
	}

	public int getSpInt(final String key, final int defaultValue) {
		return settings.getInt(key, defaultValue);
	}

	public void setSpFloat(final String key, final float value) {
		settings.edit().putFloat(key, value).commit();
	}

	public float getSpFloat(final String key, final float defaultValue) {
		return settings.getFloat(key, defaultValue);
	}

	public void setSpLong(final String key, final long value) {
		settings.edit().putLong(key, value).commit();
	}

	public long getSpfLong(final String key, final long defaultValue) {
		return settings.getLong(key, defaultValue);
	}

	public void remove(String key) {
		Editor editor = settings.edit();
		editor.remove(key);
		editor.commit();
	}
}
