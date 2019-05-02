import java.util.Scanner;

/**CLASSE MAIN PARA COMPILACAO E EXECUCAO DO EXERCICIO PROGRAMA**/

//************************************************************************//
//	Exercício-Programa I - ACH2034 - Organização de Computadores Digitais //						 
//																		  //						 
//	Gustavo Jyun Hayashida n° USP 10816902								  //
//	Matheus Barbosa n° USP 10687792										  //
//																		  //
//	Prof. João Luiz Bernardes Junior									  //
//************************************************************************//	

/**O usuario deve compilar essa classe para execucao do programa**/


/**=====================================================================================================================================================**/	
																		  
public class Main {

	public static boolean isBinary(String a){
        	int j = 0;
	        for(int i=0;i<a.length();i++){
	            if(a.charAt(i)!= '0' && a.charAt(i)!= '1'){
	                j++;
	                System.out.println(j);
	            }
	        }
	        if(j==0)
	            return true;
	        else
	            return false;
	}
		
    
    public static void main(String[] args) {
        
        Scanner sc1 = new Scanner(System.in);

		System.out.println("<---------------------------------------------------------------MENU----------------------------------------------------------------------->");
		
		System.out.println();

		

        System.out.println("// Digite o tipo de  numero binario correspondente (1)Int (2)Float.");
        String kindOfbin = sc1.next();
		
		if(!kindOfbin.equals("1") && !kindOfbin.equals("2")){
			System.out.println();
			System.out.println("// Apenas sao aceitos os numeros 1 ou 2 para realizacao da conta!");
			System.out.println();
			System.out.println("// Encerrando programa...");
			System.out.println();
			System.out.println("<------------------------------------------------------------------------------------------------------------------------------------------>");
			
			System.exit(0);
			
		}

        System.out.println("// Digite a operacao '+', '-', 'x' ou '/'. ");
        String operation = sc1.next();
		
		
		if(!operation.equals("+") && !operation.equals("-") && !operation.equals("x") && !operation.equals("/")){
			System.out.println();
			System.out.println("// Sao aceitas apenas as 4 operacoes acima!");
			System.out.println();
			System.out.println("// Encerrando programa...");
			System.out.println();
			System.out.println("<------------------------------------------------------------------------------------------------------------------------------------------>");

			System.exit(0);
			
		}

		if(kindOfbin.equals("1")) {
		
	        System.out.println("// Digite o tamanho bits (Sem contar o bit de sinal).");
	        String bitSize = sc1.next();
			
	        System.out.println("// Digite o bit de sinal do 1 numero.");
	        String signalA = sc1.next();
			
			if(!signalA.equals("0") && !signalA.equals("1")){
				System.out.println();
				System.out.println("// Escreva um bit de sinal valido!");
				System.out.println();
				System.out.println("// Encerrando programa...");
				System.out.println();
				System.out.println("<------------------------------------------------------------------------------------------------------------------------------------------>");

				System.exit(0);
				
			}


	        System.out.println("// Digite o valor em binario do 1 numero.");
	        String valueA = sc1.next();
			
			if(!valueA.matches("[0-1]+")){
				System.out.println();
				System.out.println("// Escreva um numero binario valido!");
				System.out.println();
				System.out.println("// Encerrando programa...");
				System.out.println();
				System.out.println("<------------------------------------------------------------------------------------------------------------------------------------------>");

				System.exit(0);
				
			}

	        System.out.println("// Digite o bit de sinal do 2 numero.");
	        String signalB = sc1.next();
			
			if(!signalB.equals("0") && !signalB.equals("1")){
				System.out.println();
				System.out.println("// Escreva um bit de sinal valido!");
				System.out.println();
				System.out.println("// Encerrando programa...");
				System.out.println();
				System.out.println("<------------------------------------------------------------------------------------------------------------------------------------------>");

				System.exit(0);
				
			}

	        System.out.println("// Digite valor em binario do 2 numero.");
	        String valueB = sc1.next();
			
				if(!valueB.matches("[0-1]+")){
				System.out.println();
				System.out.println("// Escreva um numero binario!");
				System.out.println();
				System.out.println("// Encerrando programa...");
				System.out.println();
				System.out.println("<------------------------------------------------------------------------------------------------------------------------------------------>");

				System.exit(0);
				
			}

        
           SelectPrint selP = new SelectPrint();
           SelectPrint.select(valueA,valueB,signalA,signalB,operation,bitSize);

        }else if(kindOfbin.equals("2")){
            
            System.out.println("Fazendo conta float");

            System.out.println("Digite os bits de acordo com a finalidade e o tamanho solicitado");
            System.out.println("Bit de sinal A  -- 1 bit");
            String sinA = sc1.next();

            System.out.println("Expoente A --  Ate 8 bits");
            String expA = sc1.next();

            System.out.println("Mantissa A --  Ate 23 bits");
            String manA = sc1.next();

            System.out.println("Digite os bits de acordo com a finalidade e o tamanho solicitado");

            System.out.println("Bit de sinal B  -- 1 bit");
            String sinB = sc1.next();

            System.out.println("Expoente B --  Ate 8 bits");
            String expB = sc1.next();

            System.out.println("Mantissa B --  Ate 23 bits");
            String manB= sc1.next();

            /*

            String sinA = "0";
            String expA = "01111110";
            String manA = "00110011001100110011010";

            String sinB = "0";
            String expB = "01111011";
            String manB = "10011001100110011001101";


          */


            if(sinA.length()!=1 || expA.length()>8 || manA.length()>23 || !isBinary(sinA) || !isBinary(expA) ||!isBinary(manA) ){
                System.out.print("coloque os valores de acordo com o tamanho certo para o Valor A");
            }
            if (sinB.length()!=1 || expB.length()>8 || manB.length()>23 || !isBinary(sinB) || !isBinary(expB) ||!isBinary(manB) ){
                System.out.println("coloque os valores de acordo com o tamanho certo para o Valor B");
            }
            else{
                System.out.print(sinA+" | "+expA+" | "+manA);
                System.out.print(" "+operation+" ");
                System.out.println(sinB+" | "+expB+" | "+manB);
                System.out.println();
            }



            Float floats = new Float();
            floats.select(sinA,expA,manA,sinB,expB,manB,operation);


        }else{
            System.out.print("Passe uma operação valida");
        }

        System.out.println("\n");
		
		System.out.println("<------------------------------------------------------------------------------------------------------------------------------------------>");

    }
}



