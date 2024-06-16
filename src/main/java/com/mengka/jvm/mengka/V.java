package com.mengka.jvm.mengka;

/**
 *  撒伽的一个关于类加载的例子
 * 
 * @author mengka
 *
 */
public class V { 
	  private int value; 
	  private V next; 
	  private short sym; 
	  private byte flag; 
	  private Object dummy; 

	  public V(int value, V next) { 
	     this.value = value; 
	     this.next = next; 
	     this.sym = (short) (~value); 
	     this.flag = (byte) (~value >> 24); 
	     this.dummy = this; 
	  } 

	  public void foo(int i) { 
	     if (i > 0) { 
	       foo(i - 1); 
	     } 
	  } 

	  public static void main(String[] args) { 
	     V v2 = new V(0x01020304, null); 
	     V v1 = new V(0x0A0B0C0D, v2); 
	     v1.foo(4); 
	  } 
	} 
