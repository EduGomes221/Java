package Aula05;
public class Cirurgiao extends Medico {

    public Cirurgiao(boolean trabalhaNoHospital) {
        super(trabalhaNoHospital);
    }

    @Override
    public void tratarPaciente() {
        System.out.println("Cirurgião tratando paciente...");
    }

    public void fazerIncisao() {
        System.out.println("Cirurgião fazendo incisão...");
    }
}