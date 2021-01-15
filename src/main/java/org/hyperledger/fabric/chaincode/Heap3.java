package org.hyperledger.fabric.chaincode;

import java.util.Random;

public class Heap3 {

//    static void makeHeap(int[] arr){
//
//        int n=arr[0];
//        int temp;
//        System.out.println("n = " + n);
//        for (int i =n/2+1; i<=n; i++){
//            int k = i;
//            while(k>1) {
//                if (arr[k] > arr[k / 2]) {
//                    temp = arr[k];
//                    arr[k] = arr[k / 2];
//                    arr[k / 2] = temp;
//                    k=i;
//                    continue;
//                }
//                k = k / 2;
//            }
//        }
//    }
    
//    static int deleteHeap(int[] arr){
//
//        int temp = arr[1];
//        int n = arr[0];
//        int x = arr[n];
//        int j = 1;
//        int child_l = 2*j;
//        int child_r = 2*j+1;
//        while(j < n){
//            if(arr[j] < arr[child_l]) j=child_l;
//            if(arr[j] < arr[child_r]) j=child_r;
//        }
//
//        return temp;
//    }
//    static void swap(int[] arr, int i, int j){
//        int temp = arr[i];
//        arr[i]=arr[j];
//        arr[j]=temp;
//    }

    static int deletemax(int[] arr){
        int max=arr[1];
        int count=arr[0];
        int key = arr[count];
        arr[0]--;
        if(arr[0]==0) return arr[2];
        int d=1;
        int flag=0;
        while(flag==0) {
            if (arr[d * 2] < arr[d * 2 + 1]) {
                if(key>arr[d*2+1]){
                    arr[d]=key;
                }
                else
                {
                    int temp=arr[d*2+1];
                    arr[d*2+1]=key;
                    arr[d]=temp;
                }
                d = d * 2 + 1;
            }
            else {
                if(key>arr[d*2]){
                    arr[d]=key;
                }
                else{
                    int temp=arr[d*2];
                    arr[d*2]=key;
                    arr[d]=temp;
                }
                d = d * 2;
            }
            if(d*2>arr[0]||d*2+1>arr[0]) flag=1;
        }
        return max;
    }

    static int[] sortHeap(int[] arr) {

        int[] result = new int[arr.length];
        int[] temp = new int[arr.length];
        temp = arr;
        result[0] = arr[0];
        int n = arr[0];
        for (int i = n; i >= 1; i--) {
            result[i] = deletemax(temp);
        }
        return result;
    }

//        int n = arr[0];
//        for(int i = 1; i < n; i++){
//            swap(arr,1, arr[0]);
//            arr[0]--;
//
//            int j=1;
//            while(true)
//            {
//                if(j*2==arr[0]){
//                    if(arr[j]<arr[j*2]) {
//                        swap(arr, j, j * 2);
//                        break;
//                    }
//                    break;
//                }
//
//                if(j*2>arr[0]){
//                    break;
//                }
//
//                if(arr[j*2]>=arr[j*2+1]&&arr[j*2]>=arr[j]){
//                    swap(arr,j,j*2);
//                    j=j*2;
//                }
//                else if(arr[j*2+1]>=arr[j*2]&&arr[j*2+1]>=arr[j]){
//                    swap(arr,j,j*2+1);
//                    j=j*2+1;
//                }
//                else{
//                    break;
//                }
//            }
//        }
    static void printArray(int[] arr){

        int n = arr[0];
        for (int i =1; i <= n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    static void init(int []arr){
        Random random = new Random();
        int s = 15;
        for(int i=1; i<= s; i++){

            arr[i]=random.nextInt(100)+1;
            int k = i;
            //System.out.println("k = " + k);
            while(k>1) {
                if (arr[k] > arr[k / 2]) {
                    int temp = arr[k];
                    arr[k] = arr[k / 2];
                    arr[k / 2] = temp;
                }
                k = k / 2;
            }
        }
        arr[0]= s;
    }
    public static void main(String args[]){
        int []arr= new int[16];
        int []temp;
        //int[] arr={12,12,3,5,8,12,9,4,6,7,11,10,12};
        init(arr);
        printArray(arr);
        //makeHeap(arr);
        //printArray(arr);
        temp = sortHeap(arr);
        printArray(temp);
        //temp = sortHeap(arr);
        //printArray(temp);

    }
}
