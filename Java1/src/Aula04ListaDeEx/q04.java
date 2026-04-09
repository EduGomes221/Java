package Aula04ListaDeEx;
import java.util.Scanner;

public class q04 {
    static class Filme {
        private String nome, genero;
        private int ano, duracao, qtdAvaliacoes;
        private double somaNotas;

        public Filme(String nome, String genero, int ano, int duracao) {
            this.nome = nome;
            this.genero = genero;
            this.ano = ano;
            this.duracao = duracao;
        }

        public void exibirDetalhes() {
            System.out.printf("%s (%d) - %s - %dmin", nome, ano, genero, duracao);
            if (qtdAvaliacoes > 0) {
                System.out.printf(" [Média: %.1f (%d)]%n", somaNotas/qtdAvaliacoes, qtdAvaliacoes);
            } else {
                System.out.println(" [Sem avaliações]");
            }
        }

        public void avaliar(int nota) {
            if (nota >= 0 && nota <= 10) {
                somaNotas += nota;
                qtdAvaliacoes++;
                System.out.println("✅ Avaliado!");
            } else {
                System.out.println("❌ Nota 0-10!");
            }
        }

        public double calcularMediaAvaliacoes() {
            return qtdAvaliacoes > 0 ? somaNotas / qtdAvaliacoes : 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Filme[] catalogo = new Filme[10];
        int total = 0;
        int opcao;

        do {
            System.out.println("\n1-Cadastrar 2-Catálogo 3-Avaliar 0-Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();
                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();
                    System.out.print("Duração (min): ");
                    int duracao = scanner.nextInt();
                    catalogo[total++] = new Filme(nome, genero, ano, duracao);
                }
                case 2 -> {
                    if (total == 0) System.out.println("Vazio!");
                    else {
                        System.out.println("\nCATÁLOGO:");
                        for (int i = 0; i < total; i++) {
                            System.out.print((i+1) + ". ");
                            catalogo[i].exibirDetalhes();
                        }
                    }
                }
                case 3 -> {
                    if (total > 0) {
                        System.out.print("Filme (1-" + total + "): ");
                        int idx = scanner.nextInt() - 1;
                        if (idx >= 0 && idx < total) {
                            System.out.print("Nota (0-10): ");
                            catalogo[idx].avaliar(scanner.nextInt());
                        }
                    }
                }
            }
        } while (opcao != 0);

        scanner.close();
    }
}