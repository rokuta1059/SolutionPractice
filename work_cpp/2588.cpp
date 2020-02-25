#include <stdio.h>

int main() {

    int first;
    int last[3];

    scanf("%d", &first);

    for (int i = 0; i < 3; i++) {
        scanf("%1d", &last[i]);
    }

    printf("%d\n", first * last[2]);
    printf("%d\n", first * last[1]);
    printf("%d\n", first * last[0]);

    int lastin = (last[0] * 100) + (last[1] * 10) + last[2];

    printf("%d\n", first * lastin);

    return 0;

}