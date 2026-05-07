// Structures en C.

#include <stdio.h>

typedef struct {
    int x;
    int y;
} Point;

void point_initialize(Point* p, int x, int y) {
    p->x = x;
    p->y = y;
}

void point_move(Point* p, int dx, int dy) {
    p->x += dx;
    p->y += dy;
}

void point_print(Point p) {
    printf("(%i, %i)\n", p.x, p.y);
}

int main()
{
    Point p;
    point_initialize(&p, 2, 4);
    point_print(p);
    point_move(&p, 2, 2);
    point_print(p);
    
    return 0;
}