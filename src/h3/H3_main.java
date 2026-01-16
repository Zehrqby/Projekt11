package h3;

import java.util.Arrays;

public class H3_main {
	
	public static void main (String [] args) {
		int [] arr = {5,2,9,1,6,3,8};
		
		int [] sorted = mergeSort(arr);
		
		 System.out.println("Original: " + Arrays.toString(arr));
	        System.out.println("Sortiert: " + Arrays.toString(sorted));
	 
	}

	public static int [ ] mergeSort (int[] arr) {

	if (arr.length <= 1) {
		return arr;
	}
	
	int mid =arr.length / 2;
	
	int [] left =Arrays.copyOfRange(arr, 0 , mid);
	int[] right = Arrays.copyOfRange(arr, mid, arr.length);
	
	left = mergeSort(left);
	right = mergeSort(right);
	
	return merge(left, right);
	
}
	
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int i = 0; //R
        int j = 0; //L
        int k = 0; //Position im ergebnis
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}