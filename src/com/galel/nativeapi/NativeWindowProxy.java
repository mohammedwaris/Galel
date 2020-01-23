package com.galel.nativeapi;


import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.File;
import java.net.MalformedURLException;


import com.galel.*;

import com.galel.ne.NativeInterface;

public class NativeWindowProxy implements NativeInterface {
	
	private javafx.stage.Stage stage;
	private com.galel.GalelWebView galelWebView;
	private javafx.scene.Scene scene;
	
	private String name;
	
	public NativeWindowProxy(String htmlFile) {
		this(new Stage(), htmlFile);
	}
	
	public NativeWindowProxy(javafx.stage.Stage stage, String htmlFile) {
		this.stage = stage;
		this.galelWebView = new com.galel.GalelWebView();
		this.galelWebView.loadHTMLFile(htmlFile);
		this.scene = new javafx.scene.Scene(this.galelWebView, 600, 400);
		this.stage.setScene(this.scene);
	}
	
	public NativeInterface newObject() {
		return new NativeWindowProxy("");
	}
	
	public NativeInterface newObject(String htmlFile) {
		return new NativeWindowProxy(htmlFile);
	}
	
	public void setTitle(String title) {
		this.stage.setTitle(title);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void show() {
		this.stage.show();
	}

}