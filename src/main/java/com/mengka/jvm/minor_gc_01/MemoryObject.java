package com.mengka.jvm.minor_gc_01;

public class MemoryObject {

	private byte[] bytes = null;
	
	public MemoryObject(int size){
		bytes = new byte[size];
	}
}
