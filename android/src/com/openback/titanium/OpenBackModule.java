/**
 * OpenBack Titanium Module for Android
 *
 * Copyright (c) 2018 OpenBack, Ltd.. All rights reserved.
 */
package com.openback.titanium;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;

import android.content.Context;

import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;

import java.util.HashMap;

import javax.xml.stream.events.StartDocument;

import com.openback.OpenBack;
import com.openback.UserInfoExtra;

@Kroll.module(name="OpenBack", id="com.openback")
public class OpenBackModule extends KrollModule
{
	// Standard Debugging variables
	private static final String LCAT = "OpenBackModule";
	private static final boolean DBG = TiConfig.LOGD;

	@Kroll.constant public static final int CUSTOM_TRIGGER_1 = OpenBack.CUSTOM_TRIGGER_1;
	@Kroll.constant public static final int CUSTOM_TRIGGER_2 = OpenBack.CUSTOM_TRIGGER_2;
	@Kroll.constant public static final int CUSTOM_TRIGGER_3 = OpenBack.CUSTOM_TRIGGER_3;
	@Kroll.constant public static final int CUSTOM_TRIGGER_4 = OpenBack.CUSTOM_TRIGGER_4;
	@Kroll.constant public static final int CUSTOM_TRIGGER_5 = OpenBack.CUSTOM_TRIGGER_5;
	@Kroll.constant public static final int CUSTOM_TRIGGER_6 = OpenBack.CUSTOM_TRIGGER_6;
	@Kroll.constant public static final int CUSTOM_TRIGGER_7 = OpenBack.CUSTOM_TRIGGER_7;
	@Kroll.constant public static final int CUSTOM_TRIGGER_8 = OpenBack.CUSTOM_TRIGGER_8;
	@Kroll.constant public static final int CUSTOM_TRIGGER_9 = OpenBack.CUSTOM_TRIGGER_9;
	@Kroll.constant public static final int CUSTOM_TRIGGER_10 = OpenBack.CUSTOM_TRIGGER_10;

	public OpenBackModule()
	{
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		Log.d(LCAT, "inside onAppCreate");
		// put module init code that needs to run when the application is created
		OpenBack.Config config = new OpenBack.Config(app);
		try {
			OpenBack.start(config);
		} catch (Exception e) {
			Log.e(LCAT, e.getMessage());
		}
	}

	// Methods
	@Kroll.method
	public void start(HashMap map)
	{
		TiApplication context = TiApplication.getInstance();
		OpenBack.Config config = userInfoToConfig(context, map);
		if (map.containsKey("appCode")) {
			config.setOpenBackAppCode(getString(map, "appCode"));
		}
		if (map.containsKey("gcmSenderId")) {
			config.setGcmSenderId(getString(map, "gcmSenderId"));
		}
		try {
			OpenBack.start(config);
		} catch (Exception e) {
			Log.e(LCAT, e.getMessage());
		}
	}

	@Kroll.method
	public void stop()
	{
		TiApplication context = TiApplication.getInstance();
		OpenBack.stop(context);
	}

	@Kroll.method
	public void coppaCompliant(boolean compliant)
	{
		TiApplication context = TiApplication.getInstance();
		OpenBack.coppaCompliant(context, compliant);
	}

	@Kroll.method
	public void gdprForgetUser(boolean forgetUser)
	{
		TiApplication context = TiApplication.getInstance();
		OpenBack.gdprForgetUser(context, forgetUser);
	}

	@Kroll.method
	public void logGoal(String goal, int step, double value)
	{
		TiApplication context = TiApplication.getInstance();
		OpenBack.logGoal(context, goal, step, value);
	}

	@Kroll.method
	public void setCustomTrigger(int triggerIndex, float value)
	{
		TiApplication context = TiApplication.getInstance();
		OpenBack.setCustomTrigger(context, triggerIndex, value);
	}

	@Kroll.method
	public void setCustomTrigger(int triggerIndex, int value)
	{
		TiApplication context = TiApplication.getInstance();
		OpenBack.setCustomTrigger(context, triggerIndex, value);
	}

	@Kroll.method
	public void setCustomTrigger(int triggerIndex, String value)
	{
		TiApplication context = TiApplication.getInstance();
		OpenBack.setCustomTrigger(context, triggerIndex, value);
	}

	@Kroll.method
	public void setUserInfo(HashMap userInfo)
	{
		TiApplication context = TiApplication.getInstance();
		try {
			OpenBack.update(userInfoToConfig(context, userInfo));
		} catch (Exception e) {
			Log.e(LCAT, e.getMessage());
		}
	}

	// Properties
	@Kroll.getProperty
	public String version()
	{
		return OpenBack.getSdkVersion();
	}

	private OpenBack.Config userInfoToConfig(Context context, HashMap userInfo)
	{
		OpenBack.Config config = new OpenBack.Config(context);
		UserInfoExtra userInfoExtra = new UserInfoExtra();
            
		if (userInfo.containsKey("addressLine1")) {
			userInfoExtra.AddressLine1 = getString(userInfo, "addressLine1");
		}
		if (userInfo.containsKey("addressLine2")) {
			userInfoExtra.AddressLine2 = getString(userInfo, "addressLine2");
		}
		if (userInfo.containsKey("advertisingId")) {
			userInfoExtra.AdvertisingId = getString(userInfo, "advertisingId");
		}
		if (userInfo.containsKey("age")) {
			userInfoExtra.Age = getString(userInfo, "age");
		}
		if (userInfo.containsKey("city")) {
			userInfoExtra.City = getString(userInfo, "city");
		}
		if (userInfo.containsKey("country")) {
			userInfoExtra.Country = getString(userInfo, "country");
		}
		if (userInfo.containsKey("countryCode")) {
			userInfoExtra.CountryCode  = getString(userInfo, "countryCode");
		}
		if (userInfo.containsKey("dateOfBirth")) {
			userInfoExtra.DateOfBirth = getString(userInfo, "dateOfBirth");
		}
		if (userInfo.containsKey("firstName")) {
			userInfoExtra.FirstName = getString(userInfo, "firstName");
		}
		if (userInfo.containsKey("gender")) {
			userInfoExtra.Gender = getString(userInfo, "gender");
		}
		if (userInfo.containsKey("postCode")) {
			userInfoExtra.PostCode = getString(userInfo, "postCode");
		}
		if (userInfo.containsKey("profession")) {
			userInfoExtra.Profession = getString(userInfo, "profession");
		}
		if (userInfo.containsKey("state")) {
			userInfoExtra.State = getString(userInfo, "state");
		}
		if (userInfo.containsKey("surname")) {
			userInfoExtra.Surname = getString(userInfo, "surname");
		}
		if (userInfo.containsKey("title")) {
			userInfoExtra.Title = getString(userInfo, "title");
		}
		if (userInfo.containsKey("identity1")) {
			userInfoExtra.Identity1 = getString(userInfo, "identity1");
		}
		if (userInfo.containsKey("identity2")) {
			userInfoExtra.Identity2 = getString(userInfo, "identity2");
		}
		if (userInfo.containsKey("identity3")) {
			userInfoExtra.Identity3 = getString(userInfo, "identity3");
		}
		if (userInfo.containsKey("identity4")) {
			userInfoExtra.Identity4 = getString(userInfo, "identity4");
		}
		if (userInfo.containsKey("identity5")) {
			userInfoExtra.Identity5 = getString(userInfo, "identity5");
		}

		config.setExtraUserInfo(userInfoExtra);

		if (userInfo.containsKey("emailAddress")) {
			config.setUserEmail(getString(userInfo, "emailAddress"));
		}
		if (userInfo.containsKey("phoneNumber")) {
			config.setUserMsisdn(getString(userInfo, "phoneNumber"));
		}

		return config;
	}

	private String getString(HashMap map, String key)
	{
		Object value = map.get(key);
		if (value instanceof String) {
			return (String)value;
		}
		return "";
	}
}

