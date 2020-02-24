#include <stdio.h>

#define MAX 1000000
#define swap(x, y) {int t = x; x = y; y = t;}

int arr[MAX];
int input;

void quickSort(int *array, int first, int last) {
    
    int inFirst = first;
    int inLast = last;
    int pivot = array[(first + last) / 2];

    while (inFirst <= inLast) {
        while (pivot > array[inFirst]) inFirst++;
        while (pivot < array[inLast]) inLast--;

        if (inFirst <= inLast) {
            swap(array[inFirst], array[inLast]);
            inFirst++;
            inLast--;
        }
    }

    if (first < inLast) quickSort(arr, first, inLast);
    if (inFirst < last) quickSort(arr, inFirst, last);

}

int main() {

    scanf("%d", &input);

    for (int i = 0; i < input; i++) {
        scanf("%d", &arr[i]);
    }

    quickSort(arr, 0, input - 1);

    for (int i = 0; i < input; i++) {
        printf("%d\n", arr[i]);
    }

    return 0;
}