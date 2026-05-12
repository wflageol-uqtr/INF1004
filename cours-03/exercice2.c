#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    srand(time(NULL));
    int n = (rand() % 100) + 1;
    
    int x;
    do {
        printf("Veuillez deviner le nombre : ");
        scanf("%i", &x);
        
        if(x < n) {
            printf("Plus grand.\n");
        }
        if(x > n) {
            printf("Plus petit.\n");
        }
    } while(x != n);
    
    printf("Vous avez deviné le nombre!");

    return 0;
}