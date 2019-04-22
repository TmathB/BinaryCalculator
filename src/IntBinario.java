import java.util.*;


public class IntBinario {

    public static int[] alingnedA;
    public static int[] alingnedB;
    public static int bitSignalA;
    public static int bitSignalB;
    public static int signalResult;
    public static String OperationI;
    public static int[] result;
    public static int[] resto;
    public static int[] not = {0};

    public IntBinario() {
    }

    ;

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

    public static int[] subtracao(int[] a, int[] b, int bitSignalBI) {

        b = (groupSS(bitSignalBI, b)).clone();

        alingPackAB(a, b);

        int[] finalResult = new int[a.length];

        int[] complement = (complemento(b)).clone();

        int[] result = soma(a, complement);

        int j = 0;

        if (result.length > a.length) {
            signalResult = result[1];
            for (int i = 1; i < result.length; i++) {
                finalResult[j] = result[i];
                j++;
            }
            ;
        } else {
            signalResult = result[0];
            for (int i = 2; i < result.length; i++) {
                finalResult[j] = result[i];
                j++;
            }
        }

        return finalResult;
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

            for (int i = 0; i < restoI.size(); i++) {
                restoT[i] = restoI.get(i);


            }

            resto = restoT.clone();


            quocient = (soma(quocient, um)).clone();

        }
        ;

        return quocient;
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
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] != 0)
                j++;
        }
        if (j != 0)
            return true;
        else
            return false;

    }


    public static int[] select(String a, String b, String SignalA, String SignalB, String Operation, String bitSize) {


        bitSignalA = Character.getNumericValue(SignalA.charAt(0));
        bitSignalB = Character.getNumericValue(SignalB.charAt(0));
        signalResult = 1;

        int strBitSize = Integer.parseInt(bitSize) + 1;
        double newBitSize = Math.pow(2, strBitSize);


        convertToArrayInt(a, b);
        alingPackAB(alingnedA, alingnedB);


        if (Operation.equals("+")) {
            OperationI = Operation;
            if (SignalA.equals("0") && SignalB.equals("0")) {

                result = (soma(alingnedA, alingnedB)).clone();
                signalResult = 0;

            } else if (SignalA.equals("0") && SignalB.equals("1")) {

                result = (subtracao(alingnedA, alingnedB, bitSignalB)).clone();


            } else if (SignalA.equals("1") && SignalB.equals("0")) {

                result = (subtracao(alingnedB, alingnedA, bitSignalA)).clone();


            } else if (SignalA.equals("1") && SignalB.equals("1")) {

                result = (soma(alingnedA, alingnedB)).clone();
                signalResult = 1;

            } else {

                System.out.println("passe o bit de sinal valido");
            }

        } else if (Operation.equals("-")) {
            OperationI = Operation;

            if (SignalA.equals("0") && SignalB.equals("0")) {

                result = (subtracao(alingnedA, alingnedB, bitSignalB)).clone();


            } else if (SignalA.equals("0") && SignalB.equals("1")) {

                result = (soma(alingnedA, alingnedB)).clone();


            } else if (SignalA.equals("1") && SignalB.equals("0")) {

                result = (soma(alingnedA, alingnedB)).clone();


            } else if (SignalA.equals("1") && SignalB.equals("1")) {

                result = (subtracao(alingnedB, alingnedA, bitSignalB)).clone();
                signalResult = 1;


            } else {

                System.out.println("passe o bit de sinal valido");
            }
        } else if (Operation.equals("/")) {
            if (!verifyZero(alingnedB)) {

                result = not.clone();

            } else {
                result = (divisao(alingnedA, alingnedB, strBitSize)).clone();
            }
        }


        //result = (subtracao(alingnedA,alingnedB)).clone();



        if(result.length >newBitSize){

        System.out.println("Overflow");

        }else if(!verifyZero(alingnedB)){
            System.out.println("Divisao por zero");
        }else{
            if(Operation.equals("+")||Operation.equals("-"))
                printVal(a,b);
            if(Operation.equals("/"))
                printDiv(a,b);
        }


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
        for (int i = 0 ; i < result.length ; i++)
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
        System.out.println();
        System.out.print("quocient = ");
        for(int i = 0;i<result.length;i++)
            System.out.print(result[i]);

        System.out.println();
        System.out.print("resto = ");
        for(int i = 0 ;i<resto.length;i++){
            System.out.print(resto[i]);
        }


    }

     //*/
}

