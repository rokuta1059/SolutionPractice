#include <stdio.h>

#define MAX(X, Y) (X > Y ? X : Y)
#define MIN(X, Y) (X < Y ? X : Y)

int input;
int min = 1000000000;
int max = -1000000000;
int arr[11];

void calc(int plus, int minus, int multi, int divi, int count, int value) {

    if (count == input) {
        max = MAX(max, value);
        min = MIN(min, value);
    }

    if (plus > 0)
        calc(plus - 1, minus, multi, divi, count + 1, value + arr[count]);
    if (minus > 0)
        calc(plus, minus - 1, multi, divi, count + 1, value - arr[count]);
    if (multi > 0)
        calc(plus, minus, multi - 1, divi, count + 1, value * arr[count]);
    if (divi > 0)
        calc(plus, minus, multi, divi - 1, count + 1, value / arr[count]);

}

int main() {

    int plus, minus, multi, divi;

    scanf("%d", &input);

    for (int i = 0; i < input; i++) {
        scanf("%d", &arr[i]);
    }

    scanf("%d %d %d %d", &plus, &minus, &multi, &divi);

    calc(plus, minus, multi, divi, 1, arr[0]);

    printf("%d\n", max);
    printf("%d\n", min);

    return 0;
}