/*
 *
 * WiFi Info plugin for Android
 *
 * @Author Linkpass Srl
 *
 * @licenze GPL v3
 *
 *
 */

package org.apache.cordova.wifiinfo;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import org.apache.cordova.CordovaWebView;
import org.json.JSONObject;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import org.apache.cordova.CordovaInterface;

public class WiFiInfo extends CordovaPlugin {

	public static String WIFI_NAME = "";


	/**
	 * Constructor.
	 */
	public WiFiInfo() {

	}


	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {

		if (action.equals("getSSID")) {
			
			WifiManager  wm=(WifiManager)this.cordova.getActivity().getSystemService(Context.WIFI_SERVICE);
			WifiInfo wi = wm.getConnectionInfo();
			JSONObject jo = new JSONObject();
			jo.put("SSID", wi.getSSID());
			jo.put("BSSID",wi.getBSSID());
			
			PluginResult pluginResult = new PluginResult(
					PluginResult.Status.OK,jo);

			pluginResult.setKeepCallback(false);			
			callbackContext.success(jo);

			return true;

		} else {
			return false;
		}

	}


}
