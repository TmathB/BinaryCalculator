	
	public class SelectPrint{
		
		
	public static int bitSignalA;
    public static int bitSignalB;
    public static int signalResult;
    public static String OperationI;
    public static int[] result;
	
	Functions funcion = new Functions();
	Operations operation = new Operations();
	
	
	public static int[] select(String a, String b, String SignalA, String SignalB, String Operation, String bitSize) {


        bitSignalA = Character.getNumericValue(SignalA.charAt(0));
        bitSignalB = Character.getNumericValue(SignalB.charAt(0));
      
	  

        int strBitSize = Integer.parseInt(bitSize);
        Functions.convertToArrayInt(a, b);
        Functions.alingPackAB(Functions.alingnedA, Functions.alingnedB);

        int [] not = {0,0,0};


        if (Operation.equals("+")) {
            OperationI = Operation;
            if (SignalA.equals("0") && SignalB.equals("0")) {

                result = (Operations.soma(Functions.alingnedA, Functions.alingnedB)).clone();
                signalResult = 0;

            } else if (SignalA.equals("0") && SignalB.equals("1")) {

                result = (Operations.subtracao(Functions.alingnedA, Functions.alingnedB)).clone();


            } else if (SignalA.equals("1") && SignalB.equals("0")) {

                result = (Operations.subtracao(Functions.alingnedB, Functions.alingnedA)).clone();


            } else if (SignalA.equals("1") && SignalB.equals("1")) {

                result = (Operations.soma(Functions.alingnedA, Functions.alingnedB)).clone();
				
				result = (Operations.complemento(result)).clone();
				
                signalResult = 1;

            } else {

                System.out.println("passe o bit de sinal valido");
            }

        } else if (Operation.equals("-")) {
            OperationI = Operation;

            if (SignalA.equals("0") && SignalB.equals("0")) {

                result = (Operations.subtracao(Functions.alingnedA, Functions.alingnedB)).clone();
                signalResult = result[0];


            } else if (SignalA.equals("0") && SignalB.equals("1")) {

                result = (Operations.soma(Functions.alingnedA, Functions.alingnedB)).clone();


            } else if (SignalA.equals("1") && SignalB.equals("0")) {

                result = (Operations.soma(Functions.alingnedA, Functions.alingnedB)).clone();
                result = (Operations.complemento(result)).clone();
				
                signalResult = 1;



            } else if (SignalA.equals("1") && SignalB.equals("1")){

                result = (Operations.subtracao(Functions.alingnedB, Functions.alingnedA)).clone();


            } else {

                System.out.println("passe o bit de sinal valido");
            }
        } else if (Operation.equals("/")) {
            if (Functions.verifyZero(Functions.alingnedB)) {

                result = not.clone();

            } else {
                System.out.println("fdojhfdoishofidshno");
                result = (Operations.divisao(Functions.alingnedA, Functions.alingnedB, strBitSize)).clone();
            }
        }else if(Operation.equals("x")){
            OperationI = Operation;
            if(SignalA.equals("0") && SignalB.equals("0")){

                Functions.alingnedA = (Functions.groupSS(0,Functions.alingnedA)).clone();
				
                Functions.alingnedB = (Functions.groupSS(0,Functions.alingnedB)).clone();
				
                result = (Operations.multiplicacao(Functions.alingnedA,Functions.alingnedB)).clone();

                signalResult = 0;

            }else if(SignalA.equals("1") && SignalB.equals("0")){



               Functions.alingnedA = (Functions.groupSS(0,Functions.alingnedA)).clone();
               Functions.alingnedA = (Operations.complemento(Functions.alingnedA)).clone();

               Functions.alingPackABC(Functions.alingnedB,Functions.alingnedA);

               result = (Operations.multiplicacao(Functions.alingnedB,Functions.alingnedA)).clone();

              signalResult = 1;

            }else if(SignalA.equals("0") && SignalB.equals("1")){

                Functions.alingnedB = (Functions.groupSS(0,Functions.alingnedB)).clone();
                Functions.alingnedB = (Operations.complemento(Functions.alingnedB)).clone();

                Functions.alingPackABC(Functions.alingnedA,Functions.alingnedB);

                result = (Operations.multiplicacao(Functions.alingnedA,Functions.alingnedB)).clone();

                signalResult = 1;

            }else if(SignalA.equals("1") && SignalB.equals("1")){

                Functions.alingnedA = (Functions.groupSS(0,Functions.alingnedA)).clone();
                Functions.alingnedA = (Operations.complemento(Functions.alingnedA)).clone();
				
                Functions.alingnedB = (Functions.groupSS(0,Functions.alingnedB)).clone();
                Functions.alingnedB = (Operations.complemento(Functions.alingnedB)).clone();
				
                result = (Operations.multiplicacao(Functions.alingnedA,Functions.alingnedB)).clone();

                signalResult = 0;
            }
        }


        if(Operation.equals("x") && result.length > strBitSize*2 ){
			
                System.out.println("Overflow");

        }else if(!Operation.equals("x") && result.length > strBitSize){

            System.out.println("Overflow");

        }else if(Functions.verifyZero(Functions.alingnedB) && Operation.equals("/")){
            System.out.println("Divisao por zero");
            return not;
			
        }else{
            if(Operation.equals("+")||Operation.equals("-") || Operation.equals("x") )
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
		
        for (int i = 0 ; i < 8*Functions.alingnedA.length ; i++)
            System.out.print(equality);
		
        System.out.println("\n");
		
        System.out.print("Bit de sinal: "+signalResult + " ");
		
        System.out.print("Resultado: ");
		
        for (int i = 0 ; i < result.length; i++)
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
        for (int i = 0 ; i < 8*Functions.alingnedA.length ; i++)
            System.out.print(equality);
		
        System.out.println("\n");
		
        System.out.print("Quociente: ");
		
        for(int i = 0;i<result.length;i++)
            System.out.print(result[i]);

        System.out.println();
		
        System.out.print("Resto: ");
        for(int i = 0 ;i<Operations.resto.length;i++){
            System.out.print(Operations.resto[i]);
        }
        System.out.println();


    }
}