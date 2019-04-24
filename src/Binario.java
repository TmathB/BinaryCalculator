import java.util.*;


public class Binario {

    public static int[] alingnedA;
    public static int[] alingnedB;
    public static int bitSignalA;
    public static int bitSignalB;
    public static int signalResult;
    public static String OperationI;
    public static int[] result;
    public static int[] resto;
    public static int[] not = {0};

    public Binario() {
    };
    public static void alingPackABC(int[] valueA, int[] valueB) {

        int bigest = Math.max(valueA.length, valueB.length);

        int[] packA = new int[bigest];

        int[] packB = new int[bigest];

        for(int i= 0 ; i<packB.length; i++){
            packB[i] = 1;
        }


        int j = 0;
        if (valueA.length == valueB.length) {
            for (int i = 0; i <= packA.length - 1; i++) {

                packA[i] = valueA[i];

            }
            for (int i = 0; i <= valueA.length - 1; i++) {

                packB[i] = valueB[i];

            }

        } else if (valueA.length > valueB.length) {
            for (int i = 0; i < bigest; i++) {
                try {
                    packA[i] = valueA[i];
                } catch (Exception e) {
                }
            }
            for (int i = valueA.length - valueB.length; i < bigest; i++) {

                try {
                    packB[i] = valueB[j];
                    j++;
                } catch (Exception e) {
                }

            }
        } else {
            for (int i = valueB.length - valueA.length; i < bigest; i++) {
                try {
                    packA[i] = valueA[j];
                    j++;
                } catch (Exception e) {
                }
            }
            for (int i = 0; i < bigest; i++) {

                try {
                    packB[i] = valueB[i];
                } catch (Exception e) {
                }
            }
        }


        alingnedA = packA.clone();
        alingnedB = packB.clone();

    }


    public static void alingPackAB(int[] valueA, int[] valueB) {

        int bigest = Math.max(valueA.length, valueB.length);

        int[] packA = new int[bigest];
        int[] packB = new int[bigest];

        System.out.println();

        int j = 0;
        if (valueA.length == valueB.length) {
            for (int i = 0; i <= packA.length - 1; i++) {

                packA[i] = valueA[i];


            }
            for (int i = 0; i <= valueA.length - 1; i++) {


                packB[i] = valueB[i];


            }

        } else if (valueA.length > valueB.length) {
            for (int i = 0; i < bigest; i++) {
                try {
                    packA[i] = valueA[i];
                } catch (Exception e) {
                }
            }
            for (int i = valueA.length - valueB.length; i < bigest; i++) {

                try {
                    packB[i] = valueB[j];
                    j++;
                } catch (Exception e) {
                }

                //System.out.print(i);
            }
        } else {
            for (int i = valueB.length - valueA.length; i < bigest; i++) {
                try {
                    packA[i] = valueA[j];
                    j++;
                } catch (Exception e) {
                }
            }
            for (int i = 0; i < bigest; i++) {

                try {
                    packB[i] = valueB[i];
                } catch (Exception e) {
                }
            }
        }
        /*
        for(int k = 0; k<bigest ; k++){
            System.out.print(packA[k]);
        }
        System.out.println();
        for(int k = 0; k<bigest ; k++){
            System.out.print(packB[k]);
        }
        */
        alingnedA = packA.clone();
        alingnedB = packB.clone();

    }

    public static void convertToArrayInt(String a, String b) {
        int[] packA = new int[a.length()];
        int[] packB = new int[b.length()];

        for (int i = 0; i < packA.length; i++) {
            packA[i] = Character.getNumericValue(a.charAt(i));
            //System.out.print(packA[i]);
        }
        System.out.println();
        for (int i = 0; i < packB.length; i++) {
            packB[i] = Character.getNumericValue(b.charAt(i));
            //System.out.print(packB[i]);
        }


        alingnedA = packA.clone();
        alingnedB = packB.clone();
    }

    public static int[] soma(int[] a, int[] b) {

        LinkedList<Integer> resultado = new LinkedList<Integer>();

        int carryOut = 0;

        for (int i = a.length - 1; i >= 0; i--) {
            int bit1 = a[i];
            int bit2 = b[i];
            int sum = bit1 + bit2 + carryOut;
            resultado.add(sum % 2);
            carryOut = sum / 2;

        }
        //System.out.print(carryOut);
        if (carryOut == 1)
            resultado.add(1);

        int[] result = new int[resultado.size()];

        int u = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = resultado.get(u);
            u++;
        }

        return result;

    }

    public static int[] subtracao(int[] a, int[] b) {

        int bitSinal= 0;


        if(verifyZero(a)){
            return complemento(b);
        }else if(verifyZero(b)){
            return a;
        }else{



            b = (groupSS(bitSinal ,b)).clone();

            System.out.println();

            int[] complement = (complemento(b)).clone();



            alingPackABC(a,complement);

            int [] finalResult = new int[alingnedA.length];

            int[] result = soma(alingnedA, complement);

            int j = 1;



            if (result.length > alingnedA.length) {
                for (int i = 0; i < finalResult.length; i++) {
                    finalResult[i] = result[j];
                    j++;
                }

                return finalResult;
            } else {
                for (int i = 0; i < finalResult.length; i++) {
                    finalResult[i] = result[i];
                    j++;
                }
            }

            return result;


        }
    }

    public static int[] divisao(int[] a, int[] b, int tamBits) {


        LinkedList<Integer> aTemp = new LinkedList<Integer>();
        LinkedList<Integer> restoI = new LinkedList<Integer>();


        for (int i = 0; i <= a.length - 1; i++) {
            aTemp.add(a[i]);
        }

        int[] quocient = new int[tamBits];
        int[] um = new int[tamBits];
        um[tamBits - 1] = 1;

        int[] complemented = (complemento(b)).clone();


        while (aTemp.size() != a.length - 1) {


            int[] aI = new int[aTemp.size()];

            for (int i = 0; i <= aI.length - 1; i++) {
                aI[i] = aTemp.get(i);

            }

            int[] resultado = (soma(aI, complemented)).clone();

            int tamProv = resultado.length;

            aTemp.clear();


            for (int i = 0; i <= resultado.length - 2; i++) {
                aTemp.add(resultado[i + 1]);
            }


            //resto = resultado[0];

            if (aTemp.size() == a.length - 1) {

                break;
            }


            restoI.clear();
            for (int i = 0; i < resultado.length - 1; i++)
                restoI.add(resultado[i + 1]);

            int[] restoT = new int[restoI.size()];

            System.out.println(restoI);

            for (int i = 0; i < restoI.size(); i++) {
                restoT[i] = restoI.get(i);


            }

            resto = restoT.clone();


            quocient = (soma(quocient, um)).clone();

        }


        return quocient;
    }

    public static int[] multiplicacao(int [] a, int [] b) {

        int [] resultI;
        if (verifyZero(a) || verifyZero(b)) {
            return not;

        }else {

            int[] complementoA = (complemento(a)).clone();

            int x = complementoA.length;
            int y = b.length;

            int[] A = new int[x + y + 1];
            int[] S = new int[x + y + 1];
            int[] P = new int[x + y + 1];

            int[] Temp = new int[P.length];

            int k = 0;

            //Preenchimento da matriz (0 -> valorA)
            for (int i = 0; i < x; i++) {
                A[i] = a[i];
                S[i] = complementoA[i];
                P[i] = 0;

            }


            //Preenchimento da matriz(valorA -> final da Matriz)
            for (int i = x; i < P.length - 1; i++) {
                A[i] = 0;
                S[i] = 0;
                if (k < b.length) P[i] = b[k];

                k++;
            }

            A[A.length - 1] = 0;
            S[S.length - 1] = 0;
            P[P.length - 1] = 0;


            int l = 1;

            for (int conta = 0; conta < b.length; conta++) {
                if (P[P.length - 2] == 0 && P[P.length - 1] == 1) {

                    Temp = ((soma(P, A))).clone();

                    if (Temp.length > A.length) {

                        for (int i = 0; i < P.length; i++) {
                            P[i] = Temp[l];
                            l++;
                        }
                        for (int j = P.length - 1; j > 0; j--) {
                            P[j] = P[j - 1];
                        }

                    } else {

                        P = (soma(P, A)).clone();

                        for (int j = P.length - 1; j > 0; j--) {
                            P[j] = P[j - 1];
                        }
                    }


                } else if (P[P.length - 2] == 1 && P[P.length - 1] == 0) {

                    Temp = ((soma(P, S))).clone();

                    if (Temp.length > A.length) {

                        for (int i = 0; i < P.length; i++) {
                            P[i] = Temp[l];
                            l++;
                        }
                        for (int j = P.length - 1; j > 0; j--) {
                            P[j] = P[j - 1];
                        }

                    } else {

                        P = (soma(P, S)).clone();

                        for (int j = P.length - 1; j > 0; j--) {
                            P[j] = P[j - 1];
                        }
                    }


                } else if (P[P.length - 1] == 0 && P[P.length - 2] == 0 || P[P.length - 1] == 1 && P[P.length - 2] == 1) {
                    for (int j = P.length - 1; j > 0; j--) {
                        P[j] = P[j - 1];
                    }
                }

            }

            resultI = new int[P.length - 1];


            int j = P.length - 2 ;

            for (int i = resultI.length-1; i > 0; i--) {
                resultI[i] = P[j];
                j--;
            }
        }

        return resultI;
    }

    public static int[] complemento(int[] b) {

        int[] Um = new int[b.length];
        int[] complementado = b.clone();

        Um[b.length - 1] = 1;


        ///*
        for (int i = 0; i < b.length; i++) {

            if (b[i] == 0) {
                complementado[i] = 1;
            } else if (b[i] == 1) {
                complementado[i] = 0;
            }
        }
        //
        int complemented[] = (soma(complementado, Um)).clone();

        return complemented;


    }

    public static int[] groupSS(int s, int[] a) {

        int[] novo = new int[1 + a.length];

        novo[0] = s;

        for (int i = 1; i < novo.length; i++) {
            novo[i] = a[i - 1];
        }

        return novo;

    }

    public static boolean verifyZero(int[] b) {
        int j = 0;
        for(int i=0;i<b.length;i++){
            if(b[i] != 0 )
                j++;
        }
        if(j==0)
            return true;
        else
            return false;

    }


    public static int[] select(String a, String b, String SignalA, String SignalB, String Operation, String bitSize) {


        bitSignalA = Character.getNumericValue(SignalA.charAt(0));
        bitSignalB = Character.getNumericValue(SignalB.charAt(0));
        signalResult = 1;

        int strBitSize = Integer.parseInt(bitSize);
        convertToArrayInt(a, b);
        alingPackAB(alingnedA, alingnedB);

        int [] not = {0,0,0};


        if (Operation.equals("+")) {
            OperationI = Operation;
            if (SignalA.equals("0") && SignalB.equals("0")) {

                result = (soma(alingnedA, alingnedB)).clone();
                signalResult = 0;

            } else if (SignalA.equals("0") && SignalB.equals("1")) {

                result = (subtracao(alingnedA, alingnedB)).clone();


            } else if (SignalA.equals("1") && SignalB.equals("0")) {

                result = (subtracao(alingnedB, alingnedA)).clone();


            } else if (SignalA.equals("1") && SignalB.equals("1")) {

                result = (soma(alingnedA, alingnedB)).clone();
                signalResult = 1;

            } else {

                System.out.println("passe o bit de sinal valido");
            }

        } else if (Operation.equals("-")) {
            OperationI = Operation;

            if (SignalA.equals("0") && SignalB.equals("0")) {

                result = (subtracao(alingnedA, alingnedB)).clone();
                signalResult = result [0];


            } else if (SignalA.equals("0") && SignalB.equals("1")) {

                result = (soma(alingnedA, alingnedB)).clone();


            } else if (SignalA.equals("1") && SignalB.equals("0")) {

                result = (soma(alingnedA, alingnedB)).clone();

                complemento(result);
                signalResult = 1;



            } else if (SignalA.equals("1") && SignalB.equals("1")){

                result = (subtracao(alingnedB, alingnedA)).clone();


            } else {

                System.out.println("passe o bit de sinal valido");
            }
        } else if (Operation.equals("/")) {
            if (verifyZero(alingnedB)) {

                result = not.clone();

            } else {
                System.out.println("fdojhfdoishofidshno");
                result = (divisao(alingnedA, alingnedB, strBitSize)).clone();
            }
        }else if(Operation.equals("x")){
            OperationI = Operation;
            if(SignalA.equals("0") && SignalB.equals("0")){

                alingnedA = (groupSS(0,alingnedA)).clone();
                alingnedB = (groupSS(0,alingnedB)).clone();
                result = (multiplicacao(alingnedA,alingnedB)).clone();

                signalResult = 0;

            }else if(SignalA.equals("1") && SignalB.equals("0")){



               alingnedA = (groupSS(0,alingnedA)).clone();
               alingnedA = (complemento(alingnedA)).clone();

                alingPackABC(alingnedB,alingnedA);

               result = (multiplicacao(alingnedA,alingnedB)).clone();

                signalResult = 1;

            }else if(SignalA.equals("0") && SignalB.equals("1")){

                alingnedB = (groupSS(0,alingnedB)).clone();
                alingnedB = (complemento(alingnedB)).clone();

                alingPackABC(alingnedA,alingnedB);

                result = (multiplicacao(alingnedA,alingnedB)).clone();



                signalResult = 1;

            }else if(SignalA.equals("1") && SignalB.equals("1")){

                alingnedA = (groupSS(0,alingnedA)).clone();
                alingnedA = (complemento(alingnedA)).clone();
                alingnedB = (groupSS(0,alingnedB)).clone();
                alingnedB = (complemento(alingnedB)).clone();
                result = (multiplicacao(alingnedA,alingnedB)).clone();

                signalResult = 0;
            }
        }


        if(Operation.equals("x") && result.length > strBitSize*2 ){
                System.out.println("Overflow");

        }else if(result.length > strBitSize){

            System.out.println("Overflow");

        }else if(verifyZero(alingnedB) && Operation.equals("/")){
            System.out.println("Divisao por zero");
            return not;
        }else{
            if(Operation.equals("+")||Operation.equals("-") || Operation.equals("x") )
                printVal(a,b);

            if(Operation.equals("/"))
                printDiv(a,b);
        }


        //printDiv(a,b);
        /*
        System.out.println();
        System.out.print("quocient = ");
        for(int i = 0;i<result.length;i++)
            System.out.print(result[i]);

        System.out.println();
        System.out.print("resto = ");
        for(int i = 0 ;i<resto.length;i++){
            System.out.print(resto[i]);
        }
        System.out.println();

        */

        return result;

    }


    public static void printVal(String a,String b) {

        char equality = '_';

        System.out.print(" ");
        for (int i = 0 ; i < a.length() ; i++)
            System.out.print(a.charAt(i));
        System.out.print(" "+OperationI);
        System.out.print(" ");
        for (int i = 0 ; i < b.length() ; i++)
            System.out.print(b.charAt(i));
        System.out.println();
        for (int i = 0 ; i < 8*alingnedA.length ; i++)
            System.out.print(equality);
        System.out.println();
        System.out.print("bit de sinal : "+signalResult);
        System.out.print(" resultado :  ");
        for (int i = 1 ; i < result.length ; i++)
            System.out.print(result[i]);


    }
    public static void printDiv(String a,String b){

        OperationI = "/";
        char equality = '_';

        System.out.print(" ");
        for (int i = 0 ; i < a.length() ; i++)
            System.out.print(a.charAt(i));
        System.out.print(" "+OperationI);
        System.out.print(" ");
        for (int i = 0 ; i < b.length() ; i++)
            System.out.print(b.charAt(i));
        System.out.println();
        for (int i = 0 ; i < 8*alingnedA.length ; i++)
            System.out.print(equality);
        System.out.println();
        System.out.print("quocient = ");
        for(int i = 0;i<result.length;i++)
            System.out.print(result[i]);

        System.out.println();
        System.out.print("resto = ");
        for(int i = 0 ;i<resto.length;i++){
            System.out.print(resto[i]);
        }
        System.out.println();


    }

    //*/
}

