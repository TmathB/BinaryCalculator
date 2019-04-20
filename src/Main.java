import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        //User imput
        Scanner sc1 = new Scanner(System.in);



        System.out.println("Digite o numero correspondente (1)Int (2)Float ");
        String kindOfbin = sc1.next();

        System.out.println("Digite a operacão '+' ,'-','x','/'");
        String operation = sc1.next();

        System.out.println("Digite o tamanho bits");
        String bitSize = sc1.next();

        System.out.println("Digite o bit de sinal do 1º numero");
        String signalA = sc1.next();

        System.out.println("Digite o valor em binario do 1º numero");
        String valueA = sc1.next();

        System.out.println("Digite o bit de sinal do 2º numero");
        String signalB = sc1.next();

        System.out.println("Digite valor em binario do 2º numero");
        String valueB = sc1.next();

        if(kindOfbin.equals("1")) {
            //System.out.println("Fazendo conta int");
            IntBinario bin = new IntBinario();
            IntBinario.select(valueA, valueB,  signalA, signalB,operation, bitSize);
        }else
        if(kindOfbin.equals("2")){
            System.out.println("Fazendo conta float");
        }else{
            System.out.print("Passe uma operação valida");
        }

        System.out.println();

    }
}

