package com.mengka.jvm.mkstackoverflowerror_02;

/**
 *  快速排序算法
 * 
 * @author mengka.hyy
 *
 */
public class QuicksortUtil {

	/**
	 *  快速排序
	 * 
	 * @param bb
	 * @param low
	 * @param high
	 */
	public static void quicksort(int[] bb,int low,int high){
		int w=0;
		if(low<high){
			w = split(bb, low, high, w);
			quicksort(bb, low, w-1);
			quicksort(bb, w+1, high);
		}
	}
	
	/**
	 *  对bb[low..high]区间内的元素进行一次快速排序
	 * 
	 * @param bb
	 * @param low
	 * @param high
	 * @param w  bb[low]在经过一次快速排序后的位置
	 */
	public static int split(int[] bb,int low,int high,int w){
		int i=low;
		int x=bb[low];
		for(int j=low+1;j<=high;j++){
			if(bb[j]<=x){
				i=i+1;//最后的位置向右移动一位
				if(i!=j){
					int temp = bb[i];
					bb[i] = bb[j];
					bb[j] = temp;
				}
			}
		}
		//将bb[low]交换到它对应的位置上
		int temp = bb[low];
		bb[low] = bb[i];
		bb[i] = temp;
		w=i;
		return w;
	}
}
