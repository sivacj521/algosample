package com.alayam.algo;

import java.util.Arrays;

public class HeapSortSiva
{
    void buildMaxHeap(int[] array) {
        for(int i = array.length / 2 - 1; i>=0; i--) {
            heapify(array, i, array.length);
        }
    }

    void heapSort(int[] array) {
        // Build our max heap.
        buildMaxHeap(array);

        // Find last element.
        int lastElement = array.length - 1;

        // Continue heap sorting until we have
        // just one element left in the array.
        while(lastElement > 0) {
            swap(array, 0, lastElement);
            heapify(array, 0, lastElement);
            lastElement --;
        }
    }

    void  heapify(int[] arr, int i, int end) {
        int largest, l, r;

        while(i < end) {
            largest = i;

            l = 2*i + 1;
            r = l + 1;

            if (l < end && arr[l] > arr[largest]) {
                largest = l;
            }

            if (r < end && arr[r] > arr[largest]) {
                largest = r;
            }

            if (largest == i) {
                return;
            }

            swap(arr,i, largest);
            i = largest;
        }
    }

    private void swap(int[] arr, int i, int largest) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }


    // Driver program
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        HeapSortSiva ob = new HeapSortSiva();
        ob.heapSort(arr);
        System.out.println("Sorted array is "+ Arrays.toString(arr));
    }
}