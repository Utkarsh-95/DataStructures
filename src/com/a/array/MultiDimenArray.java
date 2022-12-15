/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a.array;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class MultiDimenArray {

    public static void main(String[] args) {

		int arrs[][][] = {
            {
                {1, 2},
                {3, 4}
            },
            {
                {1, 2},
                {3, 4}
            },
            {
                {1, 2},
                {3, 4}
            }
        };
        int arr[][][] = new int[3][3][3];
        int depth, row, col, num = 1;

        for (depth = 0; depth < 3; depth++) {
            for (row = 0; row < 2; row++) {
                for (col = 0; col < 2; col++) {
                    arr[depth][row][col] = num;
                    num++;

                    if (arr[depth][row][col] == 3) {
                        arr[depth][row][col] = 100;
                    }

                    System.out.println("arr[" + depth + "][" + row + "][" + col + "] = " + arr[depth][row][col]);
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
}
