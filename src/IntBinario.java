import java.util.*;


public class IntBinario {

    public static int [] alingnedA ;
    public static int [] alingnedB ;
    public static int [] result;

    public IntBinario(){};

    public static void alingPackAB(String valueA,String valueB) {

        int bigest = Math.max(valueA.length(),valueB.length());

        int [] packA = new int[bigest];
        int [] packB = new int[bigest];

        System.out.println();

        int j = 0;
        if(valueA.length() == valueB.length()) {
            for(int i = 0 ;i<=packA.length-1;i++) {

                packA[i] = Character.getNumericValue(valueA.charAt(i));


            }
            for(int i = 0  ;i <=valueA.length()-1  ;i++) {


                packB[i] = Character.getNumericValue(valueB.charAt(i));


            }

        }
        else if(valueA.length()>valueB.length()) {
            for(int i = 0 ;i<bigest;i++) {
                try {
                    packA[i] = Character.getNumericValue(valueA.charAt(i));
                }catch(Exception e){}
            }
            for(int i = valueA.length()-valueB.length() ;i <bigest ;i++) {

                try {
                    packB[i] = Character.getNumericValue(valueB.charAt(j));
                    j++;
                }catch(Exception e){}

                //System.out.print(i);
            }
        }else {
            for(int i = valueB.length()-valueA.length() ;i<bigest;i++) {
                try {
                    packA[i] = Character.getNumericValue(valueA.charAt(j));
                    j++;
                }catch(Exception e){}
            }
            for(int i = 0 ;i <bigest ;i++) {

                try {
                    packB[i] = Character.getNumericValue(valueB.charAt(i));
                }catch(Exception e){}
            }
        }

        alingnedA = packA.clone();
        alingnedB = packB.clone();

    }
    public static int[] soma(int [] a,int [] b){

        LinkedList<Integer> resultado = new LinkedList<Integer>();

        int carryOut = 0 ;

        for (int i = a.length - 1; i >= 0; i--) {
            int bit1 = a[i];
            int bit2 = b[i];
            int sum = bit1 + bit2 + carryOut;
            resultado.add(sum % 2);
            carryOut = sum / 2;

        }
        //System.out.print(carryOut);
        if(carryOut==1)
            resultado.add(1);

        int [] result = new int [resultado.size()];

        int u = 0 ;
        for(int i=result.length-1;i>=0;i--) {
            result[i] = resultado.get(u);
            u++;
        }

        return result;

    }
	
	
    public static int[] subtracao(int [] a, int [] b){

        int [] complement = (complemento(b)).clone();

        int [] result = soma(a,complement);

        return result;
    }
	
	
	public static int[] multiplicacao(int [] a, int [] b){
		
		int [][] conta = new int [3][a.length + b.length + 1];
		
		int [] complementoA = (complemento(a)).clone();
		
		for(int i = 0; i < conta.length; i++){
			for(int j = 0; j< a.length; j++){
				if(i == 0){
					conta[i][j] = a[j];
				}
				else if(i == 1){
					conta[i][j] = complementoA[j];
				}
				else if(i == 2){
					conta[i][j] = 0;
				}
			}
		}
		
		for(int i = 0; i < conta.length; i++){
			for(int j = a.length; j < conta[0].length - 1; j++){
				if(i == 0){
					conta[i][j] = 0;
					conta[i][conta.length-1] = 0;
				}
				else if(i == 1){
					conta[i][j] = b[j];
					conta[i][conta.length-1] = 0;
					
				}
				else if(i == 2){
					conta[i][j] = 0;
					conta[i][conta.length-1] = 0;
				}
			}
		}	
		
		if(conta[3][conta.length-1]==0 && conta[3][conta.length-2] == 0 || conta[3][conta.length-1]==1 && conta[3][conta.length-2] == 1)
		
	}
	
    public static int[] complemento(int [] b){

        int [] Um = new int [b.length];
		
        int [] complementado = b.clone();

        Um [b.length-1] = 1;
		
        System.out.println();
        ///*
        for(int i = 0 ; i < b.length ; i++){

            if(b[i] == 0){
                complementado[i] = 1;
            }
            else if(b[i] == 1){
                complementado[i] = 0;
            }
        }
        //*/
        int complemented []  =(soma(complementado,Um)).clone();

        return complemented;


    }
    

    public static int [] select(String a,String b,String SignalA, String SignalB,String Operation , String bitSize){

        alingPackAB(a,b);

        if (Operation.equals("+")){

            if(SignalA.equals("0") && SignalB.equals("0")) {

                result = (soma(alingnedA, alingnedB)).clone();

            }else if(SignalA.equals("0") && SignalB.equals("1")) {

                result = (subtracao(alingnedA, alingnedB)).clone();

            }else if(SignalA.equals("1") && SignalB.equals("0")) {

                result = (subtracao(alingnedB, alingnedA)).clone();


            }else if(SignalA.equals("1") && SignalB.equals("1")) {

                result = (soma(alingnedA, alingnedB)).clone();

            }else{

                System.out.println("passe o bit de sinal valido");
            }

        }else if(Operation.equals("-")){
            if(SignalA.equals("0") && SignalB.equals("0")) {

                result = (subtracao(alingnedA, alingnedB)).clone();
			
            }else if(SignalA.equals("0") && SignalB.equals("1")) {
                
                result = (soma(alingnedA, alingnedB)).clone();

            }else if(SignalA.equals("1") && SignalB.equals("0")) {

                result = (soma(alingnedA, alingnedB)).clone();

            }else if(SignalA.equals("1") && SignalB.equals("1")) {

                result = (subtracao(alingnedB, alingnedA)).clone();

            }else{

               System.out.println("passe o bit de sinal valido");
            }
        }

        //result = (subtracao(alingnedA,alingnedB)).clone();
        System.out.println();

        int strBitSize = Integer.parseInt(bitSize);

        if(result.length > strBitSize){
            System.out.println("Overflow");
        }else{
            printVal();
        }

        return result;

    }
    public static void printVal() {
        char equality = '_';

        System.out.print(" ");
        for (int i = 0 ; i < alingnedA.length ; i++)
            System.out.print(alingnedA[i]);
        System.out.println();
        System.out.print(" ");
        for (int i = 0 ; i < alingnedA.length ; i++)
           System.out.print(alingnedB[i]);
        System.out.println();
        for (int i = 0 ; i < 4*alingnedA.length ; i++)
            System.out.print(equality);
        System.out.println();
        System.out.print(" resultado :  ");
        for (int i = 0 ; i < result.length ; i++)
            System.out.print(result[i]);


    }

}

