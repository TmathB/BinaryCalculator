import java.util.*;

/**CLASSE PARA SELECAO DE OPERACOES E SAIDA DE RESULTADOS**/

public class SelectPrint{
		
		public static int bitSignalA; // Bit de sinal do primeiro numero
		public static int bitSignalB; // Bit de sinal do segundo numero
		public static int signalResult; // Bit de sinal do resultado
		public static String OperationI; // Verifica qual operacao
		public static int[] result; // Vetor que retonar o resultado da conta
		
	
	
		Operations operations = new Operations(); // Cria o objeto da classe de operacoes
		Functions functions = new Functions(); // Cira o objeto da classe de funcoes auxiliares
		
		
/**=====================================================================================================================================================**/		


	//Metodo que verifica qual operacao desejada, os numeros passados, o bit de sinal e retorna o resultado da conta
	public static int[] select(String a, String b, String SignalA, String SignalB, String Operation, String bitSize) {


        bitSignalA = Character.getNumericValue(SignalA.charAt(0));
        bitSignalB = Character.getNumericValue(SignalB.charAt(0));
       

        int strBitSize = Integer.parseInt(bitSize);
        Functions.convertToArrayInt(a, b);
        Functions.alingPackAB(Functions.alingnedA, Functions.alingnedB);

        int [] not = {0};


        if (Operation.equals("+")) {
			
            OperationI = Operation;
			
            if (SignalA.equals("0") && SignalB.equals("0")) {

                result = (Operations.soma(Functions.alingnedA, Functions.alingnedB)).clone();
				
                signalResult = 0;

            } else if (SignalA.equals("0") && SignalB.equals("1")) {

                result = (Operations.subtracao(Functions.alingnedA, Functions.alingnedB)).clone();
				
				
				if(Functions.verifyZero(Functions.alingnedB))
					signalResult = 0;	
				else
					signalResult = result[0];


            } else if (SignalA.equals("1") && SignalB.equals("0")) {

                result = (Operations.subtracao(Functions.alingnedB, Functions.alingnedA)).clone();
				
				if(Functions.verifyZero(Functions.alingnedA))
					signalResult = 0;	
				else
					signalResult = result[0];



            } else if (SignalA.equals("1") && SignalB.equals("1")) {

                result = (Operations.soma(Functions.alingnedA, Functions.alingnedB)).clone();
				
				result  = (Operations.complemento(result)).clone();
				
                signalResult = 1;

            } 
			
        } else if (Operation.equals("-")) {
			
            OperationI = Operation;

            if (SignalA.equals("0") && SignalB.equals("0")) {

                result = (Operations.subtracao(Functions.alingnedA, Functions.alingnedB)).clone();
				
				if(Functions.verifyZero(Functions.alingnedB))
					signalResult = 0;	
				else
					signalResult = result[0];


            } else if (SignalA.equals("0") && SignalB.equals("1")) {

                result = (Operations.soma(Functions.alingnedA, Functions.alingnedB)).clone();
				
				 signalResult = 0;


            } else if (SignalA.equals("1") && SignalB.equals("0")) {

                result = (Operations.soma(Functions.alingnedA, Functions.alingnedB)).clone();

                result  = (Operations.complemento(result)).clone();
				
                signalResult = 1;



            } else if (SignalA.equals("1") && SignalB.equals("1")){

                result = (Operations.subtracao(Functions.alingnedB, Functions.alingnedA)).clone();
				
				if(Functions.verifyZero(Functions.alingnedA))
					signalResult = 0;	
				else
					signalResult = result[0];


            }
			
        } else if (Operation.equals("/")) {
			
              if (Functions.verifyZero(Functions.alingnedB)) {

                result = not.clone();

            } else if(SignalA.equals("0") && SignalB.equals("0")) {
				
                result = (Operations.divisao(Functions.alingnedA, Functions.alingnedB, strBitSize)).clone();
				
				signalResult = 0;
				
            } else if(SignalA.equals("1") && SignalB.equals("0")){
				
				result = (Operations.divisao(Functions.alingnedA, Functions.alingnedB, strBitSize)).clone();
				
				result  = (Operations.complemento(result)).clone();
				
			
					signalResult = 1;
				
			} else if(SignalA.equals("0") && SignalB.equals("1")){
				
				result = (Operations.divisao(Functions.alingnedA, Functions.alingnedB, strBitSize)).clone();
				
				result = (Operations.complemento(result)).clone();
				
				
					signalResult = 1;
				
			} else if(SignalA.equals("1") && SignalB.equals("1")){
				
				result = (Operations.divisao(Functions.alingnedA, Functions.alingnedB, strBitSize)).clone();
				
				signalResult = 0;
				
				
			}
				
            } else if(Operation.equals("x")){
			
            OperationI = Operation;
			
            if(SignalA.equals("0") && SignalB.equals("0")){

                Functions.alingnedA = (Functions.groupSS(0,Functions.alingnedA)).clone();
				
                Functions.alingnedB = (Functions.groupSS(0,Functions.alingnedB)).clone();
				
                result = (Operations.multiplicacao(Functions.alingnedA,Functions.alingnedB)).clone();

                signalResult = 0;

            }else if(SignalA.equals("1") && SignalB.equals("0")){
				
				if( Functions.verifyZero(Functions.alingnedA)){
					
					result = not;
					signalResult = 0;
					
				} else {
				
				Functions.alingnedA = (Functions.groupSS(0,Functions.alingnedA)).clone();
				Functions.alingnedA = (Operations.complemento(Functions.alingnedA)).clone();

				Functions.alingPackABC(Functions.alingnedB,Functions.alingnedA);

				result = (Operations.multiplicacao(Functions.alingnedA,Functions.alingnedB)).clone();
				

               if(Functions.verifyZero(Functions.alingnedA)){
						signalResult = 0;
					}	else{
				
						signalResult = 1;
						}
						
			
				}

            }else if(SignalA.equals("0") && SignalB.equals("1")){
				
				if( Functions.verifyZero(Functions.alingnedB)){
					
					result = not;
					signalResult = 0;
					
				} else {
                Functions.alingnedB = (Functions.groupSS(0,Functions.alingnedB)).clone();
                Functions.alingnedB = (Operations.complemento(Functions.alingnedB)).clone();

                Functions.alingPackABC(Functions.alingnedA,Functions.alingnedB);

                result = (Operations.multiplicacao(Functions.alingnedA,Functions.alingnedB)).clone();
					
					
					if(Functions.verifyZero(Functions.alingnedA)){
						signalResult = 0;
					}	else{
				
						signalResult = 1;
						}
				}
				
				
                

            }else if(SignalA.equals("1") && SignalB.equals("1")){
				
				if(Functions.verifyZero(Functions.alingnedA) || Functions.verifyZero(Functions.alingnedB)){
					
					result = not;
				}	else {

                Functions.alingnedA = (Functions.groupSS(0,Functions.alingnedA)).clone();
                Functions.alingnedA = (Operations.complemento(Functions.alingnedA)).clone();
				
                Functions.alingnedB = (Functions.groupSS(0,Functions.alingnedB)).clone();
                Functions.alingnedB = (Operations.complemento(Functions.alingnedB)).clone();
				
                result = (Operations.multiplicacao(Functions.alingnedA,Functions.alingnedB)).clone();

                signalResult = 0;
					}
            }
        }


        if(Operation.equals("x") && result.length > strBitSize*2 ){
                System.out.println("Overflow");

        } else if(!Operation.equals("x") && result.length > strBitSize){

            System.out.println("Overflow");

        } else if(Functions.verifyZero(Functions.alingnedB) && Operation.equals("/")){
			
            System.out.println("Divisao por zero");
			
            return not;
			
        } else{
			
            if(Operation.equals("+")||Operation.equals("-") || Operation.equals("x") )
                printVal(a,b);

            if(Operation.equals("/"))
                printDiv(a,b);
        }

        return result;
    }


/**=====================================================================================================================================================**/	


	//Metodo que imprime o resultado da soma, subtracao e multiplicacao
    public static void printVal(String a,String b) {

        char equality = '_';

        System.out.print(" ");
        for (int i = 0 ; i < a.length(); i++)
            System.out.print(a.charAt(i));
		
        System.out.print(" " + OperationI);
		
        System.out.print(" ");
		
        for (int i = 0 ; i < b.length(); i++)
            System.out.print(b.charAt(i));
		
        System.out.println();
		
        for (int i = 0 ; i < 8*a.length(); i++)
            System.out.print(equality);
		
        System.out.println("\n");
		
        System.out.print("Bit de sinal: "+signalResult + " ");
		
        System.out.print("Resultado: ");
		
        for (int i = 0 ; i < result.length; i++)
            System.out.print(result[i]);


    }
	
	
/**=====================================================================================================================================================**/	


	//Metodo que imprime o resultado da divisao
    public static void printDiv(String a,String b){

        OperationI = "/";
        char equality = '_';

        System.out.print(" ");
		
        for (int i = 0 ; i < a.length(); i++)
            System.out.print(a.charAt(i));
		
        System.out.print(" "+OperationI);
		
        System.out.print(" ");
        for (int i = 0 ; i < b.length(); i++)
            System.out.print(b.charAt(i));
		
        System.out.println();
        for (int i = 0 ; i < 8*a.length(); i++)
            System.out.print(equality);
		
        System.out.println("\n");
		
		System.out.print("Bit de sinal: "+signalResult + " ");
		
        System.out.print("Quociente: ");
		
        for(int i = 0;i<result.length;i++)
            System.out.print(result[i]);

        System.out.println();
		
        System.out.print("Resto: ");
        for(int i = 0 ;i < Operations.resto.length; i++){
            System.out.print(Operations.resto[i]);
        }
        System.out.println();


    }
}