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

/**O usuario deve compilar essa classe para entrada e saida das operacoes**/


/**=====================================================================================================================================================**/	
																		  
public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc1 = new Scanner(System.in);

		System.out.println("<---------------------------------------------------------------MENU----------------------------------------------------------------------->");
		
		System.out.println();
		
		

        System.out.println("// Digite o numero correspondente (1)Int (2)Float.");
        String kindOfbin = sc1.next();

        System.out.println("// Digite a operacao '+', '-', 'x' ou '/'. ");
        String operation = sc1.next();

        System.out.println("// Digite o tamanho bits (Sem contar o bit de sinal).");
        String bitSize = sc1.next();

        System.out.println("// Digite o bit de sinal do 1 numero.");
        String signalA = sc1.next();

        System.out.println("// Digite o valor em binario do 1 numero.");
        String valueA = sc1.next();

        System.out.println("// Digite o bit de sinal do 2 numero.");
        String signalB = sc1.next();

        System.out.println("// Digite valor em binario do 2 numero.");
        String valueB = sc1.next();

        if(kindOfbin.equals("1")) {
            //System.out.println("Fazendo conta int");
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

