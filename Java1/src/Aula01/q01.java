package Aula01;
public class q01 {
    public static void main(String[] args) {
        double valorHora = 15.00;
        int horasTrabalhadas = 40;

        double salario = valorHora * horasTrabalhadas;

        System.out.println("=== CÁLCULO DO SALÁRIO ===");
        System.out.println("Valor por hora: R$ " + valorHora);
        System.out.println("Horas trabalhadas: " + horasTrabalhadas);
        System.out.println("------------------------");
        System.out.printf("SALÁRIO: R$ %.2f%n", salario);
        System.out.println("=========================");
    }
}