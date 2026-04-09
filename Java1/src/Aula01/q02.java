package Aula01;
import  java.util.Scanner;

public class q02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double numero2 = scanner.nextDouble();

        System.out.println("\n=== RESULTADO DA COMPARAÇÃO ===");
        System.out.println("Número 1: " + numero1);
        System.out.println("Número 2: " + numero2);
        System.out.println("-------------------------------");

        if (numero1 > numero2) {
            System.out.println(numero1 + " é MAIOR que " + numero2);
        } else if (numero1 < numero2) {
            System.out.println(numero1 + " é MENOR que " + numero2);
        } else {
            System.out.println(numero1 + " é IGUAL a " + numero2);
        }

        System.out.println("================================");
        scanner.close();
    }
}