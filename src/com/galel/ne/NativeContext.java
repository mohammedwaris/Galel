package com.galel.ne;

public class NativeContext extends EventDispatcher implements NativeInterface {

	public NativeInterface createObject(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		Class clazz = Class.forName(className);
		NativeInterface nativeClass = (NativeInterface) clazz.newInstance();
		return nativeClass;
	}
}