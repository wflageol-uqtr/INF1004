// Égalités en C.

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

int point_equals(Point* p1, Point* p2) {
    return p1->x == p2->x && p1->y == p2->y;
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
    Point* p2 = point_create(2, 4);
    
    printf("%i\n", p == p2);
    printf("%i\n", point_equals(p, p2));
    
    free(p);
    free(p2);
    
    return 0;
}