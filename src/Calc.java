import java.util.Scanner;

public class Calc {
	
	static int [] sum(int [] pack){

		int a = pack [0];
		int b = pack [1];

		int [] sum = new int [2];
		

		if(a == 1 && b == 1 ) {
			sum[0] = 0;
			sum[1] = 1;// Carry Out
		}
		else if( a == 1 && b == 0) {
			sum[0]=  1;
			sum[0]=  0; // Carry Out
		}	
		else if( a == 0  && b == 1) {
			sum[0] = 1;
			sum[1] = 0;// Carry Out
		}
		else if( a == 0 && b == 0 ) {
			sum[0] = 0;
			sum[1] = 0;// Carry Out
		}

		return sum;
	}
	public static void main(String[]args){
		Scanner sc1 = new Scanner(System.in); 
    	
		//System.out.println("Digite o sinal do numero A");
		//String signalA = sc1.next()
    	System.out.println("Digite um valor");
    	String valueA = sc1.next();
    	
    	//System.out.println("Digite oo sinal do numero B");
    	//String signalB = sc1.next();
    	System.out.println("Digite um valor");
    	String valueB = sc1.next();
    	
    	int bigest = Math.max(valueA.length(),valueB.length());
    	
    	int [] packA = new int[bigest];
    	int [] packB = new int[bigest];
    	
    
    	
    	//System.out.println(bigest);
    	
    	//for(int i = 0 ;i < bigest;i++) {
    	//	System.out.print(packB[i]+"  ");
    		
    	//}
    	   	
    	for(int i = valueA.length() ;i >0 ;i--) {
    		packA[i] = Character.getNumericValue(valueA.charAt(i));
    		System.out.print(packA[i]+"  ");
    	}
    	System.out.println();
    	/*for(int i = valueA.length()-valueB.length() ;i >0 ;i--) {	
    		packB[i] = Character.getNumericValue(valueB.charAt(i));
    		System.out.print(packB[i]+"  ");
    	}
    	System.out.println();*/
    	
    	

    	//pack [0] = Integer.parseInt(valueA) ;
    	//pack [1] = Integer.parseInt(valueB) ;
    	//pack [2] = Integer.parseInt(signalA);
    	//pack [3] = Integer.parseInt(signalB);


		//int [] result = sum(pack);


		//System.out.println(valueA+" + "+valueB+" = "+result[0]+" | Carry out  = "+result[1]);

	}
	

}
