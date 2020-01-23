package com.silverbrain.ne;

import netscape.javascript.JSObject;

import com.galel.ne.*;

public class Bluetooth extends NativeClass {

	public Bluetooth() {
		java.util.Timer jTimer = new java.util.Timer();
			jTimer.scheduleAtFixedRate(new java.util.TimerTask(){
				public void run() {
					
					System.out.println("timer completed");
					dispatchEvent(new Event("abc"));
					
				}
			}, 0, 3000);
	}
	
	
	
	
	public void print(String msg) {
		
		System.out.println("Hello from Bluetooth: " + msg);
	}
	
}