package org.hyperledger.fabric.chaincode;

public class Bug {
    // Creating a game board
    static void Init(int A[][]){
        for(int i=0; i<A.length; i++)
            for(int j=0; j<A[i].length;j++)
                A[i][j]=0;
    }
    // Checking all positions are touched
    static boolean check(int A[][]){
        for(int i=0; i<A.length; i++) {
            for (int j = 0; j<A[0].length; j++) {
                if (A[i][j] == 0) return false;
            }
        }
        return true;
    }

    // Finding a route
    static void Find(int A[][]){

        int x=0;
        int y=0;
        A[x][y]=1;
        int count=0;
        while(true){
            x+=(int)(Math.random()*3)-1;
            y+=(int)(Math.random()*3)-1;

            if(x<0) x=0;
            else if (x>=A.length) x=A.length-1;
            if(y<0) y=0;
            else if (y>=A.length) y=A.length-1;
            A[x][y]+=1;
            count++;
            //if(x==A.length-1&&y==A.length-1) break;
            if(check(A)) break;
        }

    }
    static void print(int A[][]){
        int temp[][]=new int[A.length][];
        for(int i=0; i<A.length; i++)
            temp[i]=new int[A[i].length];

        for(int i=0; i<A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                temp[i][j] = A[i][j];
                System.out.printf("%4d",temp[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        int row = 8;
        int col = 8;
        int A[][]= new int[row][col];
        Init(A);
        Find(A);
        print(A);
    }
}
