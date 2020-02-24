#include <stdio.h>

int LEN;
int arr[41];

int fibo(int n) {

    if (n <= 0) {
        arr[0] = 0;
        return 0;

    } else if (n == 1) {
        arr[1] = 1;
        return 1;
    }

    if (arr[n] != 0) {
        return arr[n];
    } else {
        return arr[n] = fibo(n-1) + fibo(n-2);
    }
        
}

int main() {

    scanf("%d", &LEN);

    for (int i = 0; i < LEN; i++) {
        int tmp;
        scanf("%d", &tmp);
        if (tmp == 0) {
            printf("%d %d\n", 1, 0);
        } else if (tmp == 1) {
            printf("%d %d\n", 0, 1);
        } else {
            fibo(tmp);
            printf("%d %d\n", arr[tmp-1], arr[tmp]);
        }
    }

    return 0;

}