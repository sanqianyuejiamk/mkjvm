package com.mengka.jvm.mkstackoverflowerror_02;

/**
 *  ���������㷨
 * 
 * @author mengka.hyy
 *
 */
public class QuicksortUtil {

	/**
	 *  ��������
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
	 *  ��bb[low..high]�����ڵ�Ԫ�ؽ���һ�ο�������
	 * 
	 * @param bb
	 * @param low
	 * @param high
	 * @param w  bb[low]�ھ���һ�ο���������λ��
	 */
	public static int split(int[] bb,int low,int high,int w){
		int i=low;
		int x=bb[low];
		for(int j=low+1;j<=high;j++){
			if(bb[j]<=x){
				i=i+1;//����λ�������ƶ�һλ
				if(i!=j){
					int temp = bb[i];
					bb[i] = bb[j];
					bb[j] = temp;
				}
			}
		}
		//��bb[low]����������Ӧ��λ����
		int temp = bb[low];
		bb[low] = bb[i];
		bb[i] = temp;
		w=i;
		return w;
	}
}
