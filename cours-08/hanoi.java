int fibo(int n) {
    if(n < 0)
        throw new ArithmeticException();
    if(n == 0)
        return 0;
    if(n == 1)
        return 1;

    return fibo(n - 1) + fibo(n - 2);
}

class HanoiTower extends Stack<Integer> {
    private String name;
    public String getName() { return name; }

    public HanoiTower(String name) {
        this.name = name;
    }
}

void hanoiMove(HanoiTower t1, HanoiTower t2) {
    if(t2.isEmpty() || (!t1.isEmpty() && t1.peek() < t2.peek())) {
        System.out.printf("Déplacer de %s vers %s.%n", t1.getName(), t2.getName());
        t2.push(t1.pop());
    }
    else {
        System.out.printf("Déplacer de %s vers %s.%n", t2.getName(), t1.getName());
        t1.push(t2.pop());
    }
}

void hanoi(int n) {
    HanoiTower a = new HanoiTower("A");
    HanoiTower b = new HanoiTower("B");
    HanoiTower c = new HanoiTower("C");

    for(int i = n; i >= 1; i--)
        a.push(i);

    int moves = (int)Math.pow(2, n) - 1;

    HanoiTower aux = b;
    HanoiTower dest = c;
    if(n % 2 == 0) {
        aux = c;
        dest = b;
    }

    for(int i = 1; i <= moves; i++) {
        switch(i % 3) {
            case 1:
                hanoiMove(a, dest);
                break;
            case 2:
                hanoiMove(a, aux);
                break;
            case 0:
                hanoiMove(aux, dest);
                break;
        }
    }
}

void main() {
    hanoi(3);
}