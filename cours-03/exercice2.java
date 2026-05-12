void main() {
    Random rng = new Random();
    Scanner scan = new Scanner(System.in);

    int n = rng.nextInt(1, 100);
    int x;
    do {
        System.out.println("Veuillez deviner le nombre :");
        x = scan.nextInt();

        if(x < n) {
            System.out.println("Le nombre est plus grand.");
        }
        if(x > n) {
            System.out.println("Le nombre est plus petit.");
        }
    } while(x != n);

    System.out.println("Vous avez trouvé le nombre!");
}