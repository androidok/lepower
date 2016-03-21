package com.lepower.activity;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.client.ClientProtocolException;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.lepower.model.LocationInfo;
import com.lepower.utils.HttpUtils;
import com.lepower.utils.LocationUtil;

public class LocationService extends Service{
	
	private static String URL = "";
	
	private static long mIntervalTime = 1800000l;//半小时
	
	private LocationInfo info;
	
	private TimerTask task;
	
	private Timer timer;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		timer = new Timer();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				startTimerTask();
			}
		}).start();
		return super.onStartCommand(intent, flags, startId);
	}

	/**
	 * 开启一个定时器,半小时更新一次经纬度并传递给后台
	 */
	private void startTimerTask() {
		// TODO Auto-generated method stub
		task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				info = LocationUtil.getLocation(getService()); //更新经纬度	
				URL = URL + "?";//拼接访问地址
				HttpUtils.getResult(URL);
			}
		};	
		timer.schedule(task, 0, mIntervalTime);
	}
	
	private LocationService getService(){
		return LocationService.this;
	}

}
