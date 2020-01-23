var galel = {};

galel.NativeApplication =  class {
	
	static getApplicationInstance() {
		return galel.NativeApplicationProxy.getApplicationInstance();
	}
}



galel.NativeWindow = class {
	

	constructor(htmlFile) {
		this.nativeWindowProxy = galel.NativeWindowProxy.newObject(htmlFile);
	}

	setTitle(title) {
		this.nativeWindowProxy.setTitle(title);
	}

	show() {
		this.nativeWindowProxy.show();
	}
	
	toString() {
		return "[object galel.NativeWindow]";
	}

}

galel.File = class {
	
	constructor(path) {
		if(path == undefined || path == null)
			path = ".";
		this.fileProxy = galel.FileProxy.newObject();
		this.fileProxy.setPath(path);
	}
	
	getAbsolutePath() {
		return this.fileProxy.getAbsolutePath();
	}
	
	browseForDirectory(title) {
		return this.fileProxy.browseForDirectory(title);
	}
	
	length() {
		return this.fileProxy.length();
	}
	
	getParent() {
		return this.fileProxy.getParent();
	}
	
	getParentFile() {
		return new galel.File(this.fileProxy.getParent());
	}
	
	list() {
		return this.fileProxy.list();
	}
	
	static createTempFile() {
		return galel.FileProxy.createTempFile();
	}
	
	toString() {
		return "[object galel.File]";
	}
}
