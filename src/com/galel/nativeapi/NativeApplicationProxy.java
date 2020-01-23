package com.galel.nativeapi;

import java.util.ArrayList;

public class NativeApplicationProxy {

	ArrayList<NativeWindowProxy> nativeWindowProxies = new ArrayList<NativeWindowProxy>();
	
	public NativeApplicationProxy() {
	}
	
	public NativeWindowProxy getActiveWindowProxy() {
		return null;
	}
	
	public NativeApplicationProxy getApplicationInstance() {
		return this;
	}
	
	public void exit() {
		javafx.application.Platform.exit();
	}
	
	public void addNativeWindowProxy(NativeWindowProxy nativeWindowProxy) {
		nativeWindowProxies.add(nativeWindowProxy);
	}

}