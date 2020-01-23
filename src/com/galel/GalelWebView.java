package com.galel;

import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.scene.layout.AnchorPane;
import javafx.concurrent.Worker.State;
import javafx.beans.value.*;
import netscape.javascript.JSObject;
import javax.script.*;

import java.util.ArrayList;
import java.io.File;
import java.net.*;

import com.galel.nativeapi.*;
import com.galel.ne.*;


public class GalelWebView extends AnchorPane {
	
	private WebView webView;
	private WebEngine webEngine;
	private String url;
	
	static ArrayList<NativeClass> nativeClasses = new ArrayList<NativeClass>();
	static ArrayList<GalelWebView> galelWebViews = new ArrayList<GalelWebView>();
	
	static NativeInterface nativeContext = new NativeContext();
	static NativeInterface fileProxy = new FileProxy(".");
	static NativeInterface nativeWindowProxy = new NativeWindowProxy("");
	static NativeApplicationProxy nativeApplicationProxy = new NativeApplicationProxy();
	


	public GalelWebView() {
		galelWebViews.add(this);
		this.webView = new WebView();
		this.webEngine = this.webView.getEngine();

		super.getChildren().add(this.webView);
		super.setTopAnchor(this.webView, 0.0);
		super.setBottomAnchor(this.webView, 0.0);
		super.setLeftAnchor(this.webView, 0.0);
		super.setRightAnchor(this.webView, 0.0);

		this.webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
            public void changed(ObservableValue ov, State oldState, State newState) {
                if (newState == State.SUCCEEDED) {
					System.out.println(nativeClasses);
					
                	JSObject window = (JSObject) webEngine.executeScript("galel");
                	//ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");
                	try {
						window.setMember("NativeContext", nativeContext);
						window.setMember("FileProxy", fileProxy);
						window.setMember("NativeWindowProxy", nativeWindowProxy);
						window.setMember("NativeApplicationProxy", nativeApplicationProxy);
						
						
						
                    	webEngine.executeScript("window.dispatchEvent(new Event('native_api_ready'));");
                	}catch(Exception e){
                		e.printStackTrace();
                	}
  
            	}
            	//System.out.println(webView + " new state: " + newState);
            }
        });

        com.sun.javafx.webkit.WebConsoleListener.setDefaultListener(new com.sun.javafx.webkit.WebConsoleListener(){
			@Override
			public void messageAdded(javafx.scene.web.WebView webView, String message, int lineNumber, String sourceId) {
				System.out.println("Console: [" + sourceId + ":" + lineNumber + "] " + message);
			}
		});


        
	}

	public void loadHTMLFile(String htmlFile) {
		this.url = getHTMLUrl(htmlFile);
		if(this.url != null && !this.url.isEmpty())
			this.webEngine.load(this.url);
	}

	public String getUrl() {
		return this.url;
	}

	public WebView getWebView() {
		return this.webView;
	}

	public WebEngine getWebEngine() {
		return this.webView.getEngine();
	}

	private String getHTMLUrl(String htmlFile) {
		File file = new File(htmlFile);
		file = file.getAbsoluteFile();
		String url = null;
		try{
			url = file.toURI().toURL().toString();
		}catch(MalformedURLException me) {

		}

		return url;
	}
	
	public static void addNativeClass(NativeClass nativeClass) {
		nativeClasses.add(nativeClass);
		
	}



}