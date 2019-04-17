import java.util.Scanner;
import java.util.Arrays; 

public class Imput {
	public static void main(String[]args){
		
		//User imput
		Scanner sc1 = new Scanner(System.in); 
		
		System.out.println("Digite a operacão '+' ,'-','x','/'");
		String signal = sc1.next();
    	
		//System.out.println("Digite o sinal do numero A");
		//String signalA = sc1.next()
    	System.out.println("Digite um valor");
    	String valueA = sc1.next();
    	
    	//System.out.println("Digite o sinal do numero B");
    	//String signalB = sc1.next();
    	System.out.println("Digite um valor");
    	String valueB = sc1.next();
    	
    	
    	Sender send = new Sender();
    	Sender.select(valueA,valueB,signal);
 
    	System.out.println();
		
 
	}
	

}
