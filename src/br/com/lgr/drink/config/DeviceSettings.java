package br.com.lgr.drink.config;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;

import android.hardware.SensorManager;

/**
 * Utility class with some common methods around the Device settings.
 * @author Leonardo Ribeiro
 *
 */
public class DeviceSettings {
	
	private static SensorManager sensormanager;
	
	public static void setSensorManager(SensorManager sensorManagerRef) {
		sensormanager = sensorManagerRef;
	}
	
	public static CGPoint screenResolution(CGPoint gcPoint) {
		return gcPoint;
	}

	public static float screenWidth() {
		return winSize().width; 
	}

	public static float screenHeight() {
		return winSize().height; 
	}
	
	public static CGSize winSize() {
		return CCDirector.sharedDirector().winSize();
	}
	
	public static SensorManager getSensormanager() {
		return sensormanager;
	}


}
