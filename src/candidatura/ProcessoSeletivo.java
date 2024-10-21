package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos = {"Fabricio","Carlos","Paulo","Kenzo","Yuri"};
        for(String candidato:candidatos){
            entrandoEmContato(candidato);
        }
    }
    public static void entrandoEmContato(String candidato){
            int tentativasRealizadas = 1;
            boolean continuarTentando = true;
            boolean atendeu = false;
            do{
                atendeu = atender();
                continuarTentando = !atendeu;
                if (continuarTentando)
                    tentativasRealizadas++;
                else
                    System.out.println("CONTATO REALIZADO COM SUCESSO");
            }while (continuarTentando && tentativasRealizadas < 3);

            if(atendeu)
                System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
            else
                System.out.println("NAO CONSEGUIMOS CONTATO COM " + candidato +" , NUMERO MAXIMO DE TENTATIVAS " + tentativasRealizadas + " REALIZADA");
    }
    public static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    public static void imprimirSelecionados(){
        String [] candidatos = {"Fabricio","Carlos","Paulo","Kenzo","Yuri"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento do array");
        for(int indice=0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de numero " + (indice+1) + " é o " + candidatos[indice]);
        }
    }
    public static void selecaoDeCandidatos(){
        String [] candidatos = {"Fabricio","Carlos","Paulo","Kenzo","Yuri","Monique","John","Textor","Pou","Tiquinho",};

        int candidatosSelecionados = 0;
        int cadidatoAtual = 0;
        double salarioBase = 2000.0;

        while(candidatosSelecionados < 5 && cadidatoAtual< candidatos.length){
            String candidato = candidatos[cadidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou esse valor salarial" +" R$ " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            cadidatoAtual++;
        }
    }
    public static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    public static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
            if(salarioBase > salarioPretendido){
                System.out.println("Ligar para candidato");
            }else if (salarioBase == salarioPretendido){
                System.out.println("Ligar para o candidato com contra proposta");
            }else{
                System.out.println("Aguardar resposta de outros candidatos");
            }
        }
}
