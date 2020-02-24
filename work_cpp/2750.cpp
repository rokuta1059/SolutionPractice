#include <iostream>
#include <algorithm>
using namespace std;

int arr[1000];
int len;

int main(void) {

    scanf("%d", &len);

    // 초기화
    for (int i = 0; i < len; i++) {
        arr[i] = 0;
    }

    for (int i = 0; i < len; i++) {
        scanf("%d", &arr[i]);
    }

    for (int i = 0; i < len; i++) {
        for (int j = i + 1; j < len; j++) {
            if (arr[i] > arr[j])
                swap(arr[i], arr[j]);
        }
    }

    for (int i = 0; i < len; i++) {
        printf("%d\n", arr[i]);
    }
}