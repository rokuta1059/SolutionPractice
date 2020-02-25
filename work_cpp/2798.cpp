#include <iostream>

#define max(X, Y) (X > Y ? X : Y)

int max;
int sum;
int N;
int card[100];
int used[100];

void cardsum(int count, int now) {
    
    if (count == 0) {
        sum = max(sum, now);
        return;
    } else {
        for (int i = 0; i < N; i++) {
            if(used[i] == 0) {
                int tmp = now;
                tmp = now + card[i];
                if (tmp > max)
                    continue;
                else {
                    used[i] = 1;
                    cardsum(count - 1, tmp);
                    used[i] = 0;
                }
            }
        }
    }
}


int main() {

    scanf("%d%d", &N, &max);

    for (int i = 0; i < N; i++) {
        scanf("%d", &card[i]);
        used[i] = 0;
    }

    cardsum(3, 0);
    printf("%d", sum);

    return 0;
}