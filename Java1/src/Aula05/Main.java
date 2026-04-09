package Aula05;
public class Main {
    public static void main(String[] args) {

        ClinicoGeral clinico = new ClinicoGeral(true, true);
        clinico.tratarPaciente();
        clinico.receitar();

        System.out.println("------------------");

        Cirurgiao cirurgiao = new Cirurgiao(true);
        cirurgiao.tratarPaciente();
        cirurgiao.fazerIncisao();
    }
}