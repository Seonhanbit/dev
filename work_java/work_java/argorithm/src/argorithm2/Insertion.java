package argorithm2;

import java.util.Arrays;

public class Insertion {
	public void sort(int[] A){
	       int size = A.length;
	       int temp = 0;
	       int j = 0;
	       for(int i = 1; i < size; i++){
	           temp = A[i];
	           for(j=i-1; j>=0 && temp<A[j]; j--){
	               A[j+1] = A[j];
	           }
	           A[j+1] = temp;
	           System.out.println(Arrays.toString(A));
	       }
	   }
	   public static void main(String[] args) {
	       // TODO Auto-generated method stub
	       Insertion insertion = new Insertion();
	       int A[] = {66, 10, 1, 34, 5};
	       insertion.sort(A);
	       for(int i = 0; i < A.length; i++){
	           System.out.println("A["+i+"] : " + A[i]);
	       }
	   }
}
