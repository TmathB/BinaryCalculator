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

        if(kindOfbin.equals("1")) {
           SelectPrint selP = new SelectPrint();
           SelectPrint.select(valueA,valueB,signalA,signalB,operation,bitSize);

        }else if(kindOfbin.equals("2")){
            System.out.println("Fazendo conta float");
        }else{
            System.out.print("Passe uma operação valida");
        }

        System.out.println("\n");
		
		System.out.println("<------------------------------------------------------------------------------------------------------------------------------------------>");

    }
}



