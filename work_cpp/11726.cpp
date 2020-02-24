#include <stdio.h>

int arr[1010];

int box(int n) {

    if (n <= 0) {
        arr[0] = 1;
        return 1;

    } else if (n == 1) {
        arr[1] = 2;
        return 2;
    }

    if (arr[n] != 0) {
        return arr[n];
    } else {
        return arr[n] = (box(n-1) + box(n-2)) % 10007;
    }
        
}

int main() {

    int tmp;
    scanf("%d", &tmp);
    tmp--;
    box(tmp);
    printf("%d\n", arr[tmp]);

    return 0;

}