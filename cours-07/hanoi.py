def hanoi(n, start, via, target):
    if n <= 1:
        print(f"Déplacer de {start} vers {target}.")
    else:
        hanoi(n - 1, start, target, via)
        hanoi(1, start, via, target)
        hanoi(n - 1, via, start, target)

hanoi(5, 'A', 'B', 'C')