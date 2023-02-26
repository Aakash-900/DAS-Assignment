package Q3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q3b{
    public static   void check( int[] array){
        int l= array.length;
        int mid=l/2;
        int[] subarray=new int[mid];
        int[] subarray1=new int[mid];
        for (int i=0; i<mid;i++){
            subarray[i]=array[i];
            subarray1[i]=array[mid+i];
        }
        ArrayList<Integer> difference=new ArrayList<>();
        int[] temp = subarray.clone();
        int[] temp1 = subarray1.clone();
        difference.add(multiply(temp,temp1,mid));
        for (int j=0;j<mid;j++) {
            for (int z = 0; z < mid; z++) {
                temp[j] = subarray1[z];
                temp1[z] = subarray[j];
                difference.add(multiply(temp,temp1,mid));
                System.out.println(Arrays.toString(temp));
                System.out.println(Arrays.toString(temp1));
                temp = subarray.clone();
                temp1 = subarray1.clone();
            }
        }
        System.out.println("Final output:"+Collections.min(difference));
    }
    public static int multiply(int[] temp,int[] temp1,int mid){
        int keep=1;
        int keep1=1;
        for (int x=0;x<mid;x++) {
            keep = keep * temp[x];
            keep1 = keep1 * temp1[x];
        }
        return Math.abs(keep-keep1);
    }

    public static void main(String[] args) {
        int[] array={1,2,3,5};
        check(array);
    }

}