package com.galel.nativeapi;

import com.galel.ne.NativeInterface;

public class FileProxy implements NativeInterface {
	
	private java.io.File file;
	
	public FileProxy() {
		this.file = new java.io.File(".");
	}
	
	
	public FileProxy(String path) {
		this.file = new java.io.File(path);
	}
	
	public FileProxy(java.io.File file) {
		this.file = file;
	}
	
	public NativeInterface newObject() {
		return new FileProxy(".");
	}
	/*
	public FileProxy newObject(String path) {
		return new FileProxy(path);
	}*/
	
	public void setPath(String path) {
		this.file = new java.io.File(path);
	}
	
	public FileProxy browseForDirectory(String title) {
		javafx.stage.DirectoryChooser dc = new javafx.stage.DirectoryChooser();
		dc.setTitle(title);
		java.io.File folder = dc.showDialog(null);
		return new FileProxy(folder);
	}
	
	public FileProxy createTempFile() throws java.io.IOException {
		return new FileProxy(java.io.File.createTempFile("galel", "tempfile"));
	}
	
	public boolean isFile() {
		return this.file.isFile();
	}
	
	public String getPath() {
		return this.file.getPath();
	}
	
	public long length() {
		return this.file.length();
	}
	
	public String getParent() {
		return this.file.getParent();
	}
	
	public FileProxy getParentFile() {
		return new FileProxy(this.file.getParentFile());
	}
	
	public String[] list() {
		String[] files = this.file.list();
		System.out.println(files);
		return files;
	}
	
	
	
	public boolean isDirectory() {
		return this.file.isDirectory();
	}
	
	
	
	public String getAbsolutePath() {
		return this.file.getAbsolutePath();
	}
	
}