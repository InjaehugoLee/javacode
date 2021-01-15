package org.hyperledger.fabric.chaincode;

import java.util.Scanner;

public class Heap {
    private static int[] data;
    private static int number = 10;

    public static void heap(int[] data, int number){
        // The number of loops is determined by comparing parent and child
        for(int i=1; i<number; i++){
            int child = i;
            while(child>0){
                int parent = child/2;
                if(data[child] > data[parent]){
                    int temp=data[parent];
                    data[parent]=data[child];
                    data[child]=temp;
                }
                child=parent;
            }
        }
    }

    public static void heap2(int[] data, int number){
        for(int i=number-1; i>0; i--){
            int temp=data[0];
            data[0]=data[i];
            data[i]=temp;

            heap(data, i);
        }
    }

    public static int[] create_num(int number){
        System.out.print("Put 10 numbers! ");
        for(int i=0; i<number; i++){
            Scanner sc= new Scanner(System.in);
            data[i]=sc.nextInt();
            //data[i]=(int)(Math.random()*100);
        }
        System.out.println();
        return data;
    }

    public static void print(int number, int[] data){
        for(int i=0; i<number; i++){
            System.out.print(data[i]+ " ");
        }
    }

    public static void main(String[] args){
        data = new int[number];
        create_num((number));
        System.out.print("Before sorting : ");
        print(number, data);
        heap(data, number);
        heap2(data, number);
        System.out.print("\n After sorting: ");
        print(number, data);

    }

}


