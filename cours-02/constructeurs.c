// Constructeurs de structures en C.

#include <stdlib.h>
#include <stdio.h>

typedef struct {
    int x;
    int y;
} Point;

Point* point_create(int x, int y) {
    Point* p = malloc(sizeof(Point));
    p->x = x;
    p->y = y;
    
    return p;
}

void point_move(Point* p, int dx, int dy) {
    p->x += dx;
    p->y += dy;
}

void point_print(Point* p) {
    printf("(%i, %i)\n", p->x, p->y);
}

int main()
{
    Point* p = point_create(2, 4);
    point_print(p);
    point_move(p, 2, 2);
    point_print(p);
    
    free(p);
    
    return 0;
}