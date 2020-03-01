#include <stdio.h>

int arr[10001];
int N;

int main() {
    scanf("%d", &N);
    for(int i = 0; i < N; i++) {
        int tmp;
        scanf("%d", &tmp);
        arr[tmp]++;
    }
    for(int i = 1; i <= 10001; ++i) {
        for(int j = 0; j < arr[i]; ++j) {
            printf("%d\n", i);
        }
    }
    return 0;
}