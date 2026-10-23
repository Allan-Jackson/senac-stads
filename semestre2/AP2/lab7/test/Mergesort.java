package test;

import java.util.Arrays;

public class Mergesort {
    //modifica o array arr
    public static void merge(int[] left, int[] right, int[] arr) {
        int l = 0; //indice vetor esquerdo
        int r = 0; //indice vetor direito
        int i = 0; //indice vetor principal

        while(l < left.length || r < right.length) {
            if(l >= left.length) { //lado esquerdo já mesclado
                arr[i] = right[r++];
            }else if(r >= right.length) { //lado direito já mesclado
                arr[i] = left[l++];
            }else {
                if(left[l] <= right[r]) {
                    arr[i] = left[l++];
                }else {
                    arr[i] = right[r++];
                }
            }
            i++;
        }
    }

    public static void mergesort(int[] array) {
        if(array.length > 1) {
            //quebrar em dois
            int mid = array.length / 2;

            int[] leftArray = Arrays.copyOfRange(array, 0, mid);
            int[] rightArray = Arrays.copyOfRange(array, mid, array.length);

            //aplicar o mergesort em cada metade
            mergesort(leftArray);
            mergesort(rightArray);

            //juntas as metades
            merge(leftArray, rightArray, array);
        }
    }

}
