package com.sort.merge;

public class MergeSort
{
	public void merge(int arr[], int left, int right, int middle) {

		int n1 = middle - left + 1;
		int n2 = right - middle;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; i++)
			L[i] = arr[left + i];
		for (int j = 0; j < n2; j++)
			R[j] = arr[middle + 1 + j];

		int i = 0;
		int j = 0;
		int count = left;
		
		while (i < n1 && j < n2) {
			if (L[i] < R[j]) {
				arr[count] = L[i];
				i++;
			} else {
				arr[count] = R[j];
				j++;
			}
			count++;
		}

		while (i < n1) {
			arr[count] = L[i];
			count++;
			i++;
		}

		while (j < n2) {
			arr[count] = R[j];
			count++;
			j++;
		}

	}

	public void sort(int arr[], int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;

			sort(arr, left, middle);
			sort(arr, middle + 1, right);

			merge(arr, left, right, middle);
		}

	}

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7, 10 };
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(arr, 0, arr.length - 1);
		for (int element : arr) {
			System.out.println(element);
		}
	}

}
