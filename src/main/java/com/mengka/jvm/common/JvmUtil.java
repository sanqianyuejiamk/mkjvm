package com.mengka.jvm.common;

public class JvmUtil {

	/**
	 *  以M为单位返回大小
	 * 
	 * @param size
	 * @return
	 */
	public static String getMemorySize(long size){
		double m_size = size * 1.0 / 1024 / 1024;
		return m_size+"M";
	}
}
