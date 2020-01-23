package com.galel;

import javafx.application.Application;
import javafx.stage.Stage;

import com.galel.nativeapi.*;

public class GalelMain extends Application {
	
	private NativeWindowProxy nativeWindowProxy;

	public void start(Stage primaryStage) {
		this.nativeWindowProxy = new NativeWindowProxy(primaryStage, "index.html");
		this.nativeWindowProxy.show();
	}

	

}