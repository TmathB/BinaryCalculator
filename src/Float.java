import java.util.*;
import java.util.function.Function;

public class Float{

    //Definição de variaveis globais que fazem as contas com float adicao e subtração

    public static int signalA ;
    public static int [] expoentA = new int[8];
    public static int [] mantissaA = new int [23];
    public static String expoentAS;

    public static int signalB;
    public static int [] expoentB= new int[8];
    public static int [] mantissaB= new int [23];
    public static String expoentBS;


    public static int [] rightShift;
    public static int part;
    public static int difer;
    public static int newExp;
    public static int signalF;
    public static String operationSignal;

    public static String expoentFinal;
    public static int [] toSum = new int [23];
    public static int [] mantissaG;



    public static int signalR;
    public static int [] expoentR= new int[8];
    public static int [] mantissaR= new int [23];


    //Funcao de inverter numero para alguns casos de soma e subtracao


    public static void invert(){


        String expTemporaioString = expoentAS;
        int [] expTemporario = expoentA.clone();
        int [] mantissaTemporaria = mantissaA.clone();

        expoentAS = expoentBS;
        expoentA = expoentB.clone();
        mantissaA = mantissaB.clone();

        expoentBS = expTemporaioString;
        expoentB = expTemporario.clone();
        mantissaB = mantissaTemporaria.clone();



    }


    //Funcao que converte as strings passadas pelo usuario em arrayspara melhor trabalharmos


    public static void stringToArray(String sinA,String expA,String manA,String sinB,String expB,String manB){

        signalA = Character.getNumericValue(sinA.charAt(0));
        signalB = Character.getNumericValue(sinB.charAt(0));
        int j=0;
        for(int i = expoentA.length-expA.length(); i < expoentA.length ;i++){
            expoentA[i] = Character.getNumericValue(expA.charAt(j));
            j++;
        }
        j=0;
        for(int i = expoentB.length-expB.length(); i < expoentB.length ;i++){
            expoentB[i] = Character.getNumericValue(expB.charAt(j));
            j++;
        }
        j=0;
        for(int i = 0; i < manA.length() ;i++){
            mantissaA[i] = Character.getNumericValue(manA.charAt(i));
            j++;
        }
        j=0;
        for(int i = 0; i < manB.length() ;i++){
            mantissaB[i] = Character.getNumericValue(manB.charAt(i));
            j++;
        }

    }

    //Funcao que faz o complemento e faz a subtracao chamando a adicao
    public static void algorithmSub(int a){

        if(a == 1)
            invert();

        int [] temp = new int [23];

        int [] tempB = new int [23];

        int[] Um = new int[23];

        Um[mantissaR.length - 1] = 1;

        int j = 0 ;

        Operations o = new Operations();

        if (part == 0){

            while(j<difer){

                rightShiftF(0);

                j++;

            }

            int []comp = o.soma(toSum,Um).clone();

            temp = (o.soma(comp,rightShift)).clone();


            for(int i = 0; i< tempB.length-1; i++){
                tempB[i] = temp[i];

            }

            int [] compB = (o.soma(toSum,Um)).clone();

            temp = (o.soma(compB,rightShift)).clone();

            if(temp[23] == 1)
                mantissaG = (o.soma(mantissaR,Um)).clone();
            else
                mantissaG = (mantissaR).clone();





        }
        else{

            while(j<difer){



                rightShiftF(1);

                j++;

            }

            for(int i = 0; i< tempB.length-1; i++){
                System.out.print(toSum[i]);

            }



            int []comp = o.soma(toSum,Um).clone();

            temp = (o.soma(comp,rightShift)).clone();

            for(int i = 0; i< tempB.length-1; i++){
                tempB[i] = temp[i];

            }

            mantissaR = (o.soma(tempB,Um)).clone();

            if(temp[23] == 1)
                mantissaG = (o.soma(mantissaR,Um)).clone();
            else
                mantissaG = (mantissaR).clone();

        }

        newExp = difer+127;

        expoentFinal = Integer.toBinaryString(newExp);



    }

    //Funcao que faz a soma das mantissas de acordo com a situaçao

    public static void algorithmSum(int a){

        if(a == 1)
            invert();

        int [] temp = new int [23];

        int [] tempB = new int [23];

        int[] Um = new int[23];

        Um[mantissaR.length - 1] = 1;

        int j = 0 ;

        Operations o = new Operations();

        if (part == 0){


            //faz right shift ate atingir o espoente maior

            while(j<difer){

                rightShiftF(0);

                j++;

            }

            //Soma o valor deslocado com o valor anterior para obter o resultado parcial

            temp = (o.soma(toSum,rightShift)).clone();


            for(int i = 0; i< tempB.length-1; i++){
                tempB[i] = temp[i];

            }

            //Adiciona um ao final se necessario para arredondar o numero

            mantissaR = (o.soma(tempB,Um)).clone();

            if(temp[23] == 1)
                mantissaG = (o.soma(mantissaR,Um)).clone();
            else
                mantissaG = (mantissaR).clone();





        }
        else{

            while(j<difer){



                rightShiftF(1);

                j++;

            }

            temp = (o.soma(toSum,rightShift)).clone();


            for(int i = 0; i< tempB.length-1; i++){
                tempB[i] = temp[i];

            }

            mantissaR = (o.soma(tempB,Um)).clone();

            if(temp[23] == 1)
                mantissaG = (o.soma(mantissaR,Um)).clone();
            else
                mantissaG = (mantissaR).clone();

        }

        //Seta o valor final do expoente seguindo a regra do "expoente" + 127

        newExp = difer+127;

        expoentFinal = Integer.toBinaryString(newExp);


    }

    //FUncao aloca um novo array e faz o right shift para trabalharmos nas operacoes

    public static void rightShiftF(int option){

        rightShift = new int [23+difer];

        toSum = new int [23+difer];

        if(option == 0){
            int j = 0 ;
            for(int i = difer; i < rightShift.length ;i++){

                if(i == difer)
                    rightShift[difer-1]= 1;

                rightShift[i] = mantissaA[j];
                j++;
            }

            for(int i = 0 ; i < mantissaA.length;i++){
                toSum[i] =  mantissaB[i];
            }

        }else
        if(option == 1){

            int j = 0 ;
            for(int i = difer; i < rightShift.length ;i++){

                if(i == difer)
                    rightShift[difer-1]= 1;

                rightShift[i] = mantissaB[j];
                j++;
            }

            for(int i = 0 ; i < mantissaB.length;i++){
                toSum[i] =  mantissaA[i];
            }
            //mantissaB = rightShift.clone();
        }
    }

    //FUncao que seleciona a operacao a ser realizada baseando se na regra de sinais e nas operacoes passadas

    public static void operationSetter(){

        if(operationSignal.equals("+")) {

            if (signalA == 1 && signalB == 1) {
                signalF = 0;
                algorithmSum(0);
            } else if (signalA == 0 && signalB == 0) {
                signalF = 0;
                algorithmSum(0);
            } else if (signalA == 1 && signalB == 0) {
                algorithmSub(1);
            } else if (signalA == 0 && signalB == 1) {
                algorithmSub(0);
            }
        } if(operationSignal.equals("-")){
            if (signalA == 1 && signalB == 1) {
                signalF = 1;
                algorithmSum(0);
            } else if (signalA == 0 && signalB == 0) {
                signalF = 0;
                algorithmSub(0);
            } else if (signalA == 1 && signalB == 0) {
                algorithmSum(1);
            } else if (signalA == 0 && signalB == 1) {
                algorithmSum(0);
            }
        }

    }

    //Funcao que seleciona o menor expoente para fazermos o right shift corretamente
    public static void minorExp(String expA,String expB){

        expoentAS = expA;
        expoentBS = expB;

        int decimalA=Integer.parseInt(expA,2);

        int decimalB=Integer.parseInt(expB,2);

        int minorExpoent = Math.min(decimalA,decimalB);

        int maxExpoent = Math.max(decimalA,decimalB);

        difer = maxExpoent - minorExpoent ;

        //System.out.println(decimalA);
        //System.out.println(decimalB);

        if (minorExpoent == decimalA)
            part = 0;
        else
            part = 1;

    }

    //funcao que centraliza as outras

    public static void select(String sinA,String expA,String manA,String sinB,String expB,String manB,String operation){

        stringToArray(sinA,expA,manA,sinB,expB,manB);

        operationSignal = operation ;


        minorExp(expA,expB);

        operationSetter();

        //algorithmSum();

        System.out.println();


        printFlo();

    }
    //Printa os resultados para o float

    public static void printFlo(){

        //Mostra numeros que estao sendo passados para os arranjos princiapais


        System.out.print(signalF);


        System.out.print("  ");


        System.out.print(expoentFinal);


        System.out.print("  ");

        for(int i = 0; i < mantissaG.length;i++){
            System.out.print(mantissaG[i]);
        }

        System.out.println();


    }

}