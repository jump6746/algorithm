package algol0729;

import java.util.Arrays;

public class BinarySearch{
	
	static int[] arr = {4,2,6,8,5,1,3,7,9};
	
	private static int binarySearch(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;
		while(right >= left) {
			int middle = ((right - left) >>> 1) + left;
			int middleValue = arr[middle];
			if(middleValue > key) {
				right = middle - 1;
			}else if(middleValue < key) {
				left = middle + 1;
			}else {
				return middle;
			}
		}
		return -(right + 1);
	}
	
	public static void main(String[] args) {
		
		int key = 7;
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int index = binarySearch(arr, key); 
		System.out.println(index);
	}
}