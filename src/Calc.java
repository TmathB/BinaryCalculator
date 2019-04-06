import java.util.Scanner;
import java.util.Arrays; 

public class Calc {
	
	 static int [] sum(int [] packA,int [] packB ){
		
		///*

		int [] computed = new int [packA.length+1];
		int [] carryOut = new int [packA.length+1];
		int a ;
		int b ; 
		
		//*/
		/*

		int [] computed = new int [packA.length+1];
		int [] carryOut = new int [packA.length+1];
		int a ;
		int b ; 
		*/
		
		for(int i = packA.length-1 ;i>=0;i--) {
			
			
			a = packA[i];
			b = packB[i];

	
			if(carryOut[i+1] == 0 && a == 0 && b ==0 ) {
				computed[i+1] = 0;
				carryOut[i] = 0;// Carry Out
			}
			else if(carryOut[i+1] == 0 && a == 0 && b ==1 ) {
				computed[i+1] = 1;
				carryOut[i] = 0;// Carry Out
			}
			else if(carryOut[i+1] == 0 && a == 1 && b ==0 ) {
				computed[i+1] = 1;
				carryOut[i] = 0;// Carry Out
			}
			else if(carryOut[i+1] == 0 && a ==1 && b ==1 ) {
				computed[i+1] = 0;
				carryOut[i] = 1;// Carry Out
			}
			else if(carryOut[i+1] == 1 && a == 0 && b ==0 ) {
				computed[i+1] = 1;
				carryOut[i] = 0;// Carry Out
			}
			else if(carryOut[i+1] == 1 && a == 0 && b ==1 ) {
				computed[i+1] = 0;
				carryOut[i] = 1;// Carry Out
			}
			else if(carryOut[i+1] == 1 && a == 1 && b ==0 ) {
				computed[i+1] = 0;
				carryOut[i] = 1;// Carry Out
			}
			else if(carryOut[i+1] == 1 && a == 1 && b ==1 ) {
				computed[i+1] = 1;
				carryOut[i] = 1;// Carry Out
			}
		}
		if(carryOut[0]==1)
			computed[0] = 1;
		
		System.out.println();
		for (int i = 0 ; i < carryOut.length ; i++)
			System.out.print("   "+carryOut[i]);/**/
		System.out.println();
		for (int i = 0 ; i < computed.length ; i++)
			System.out.print("   "+computed[i]);/**/

		return computed;
	}
	public static void main(String[]args){
		
		//Entrada do usuario
		Scanner sc1 = new Scanner(System.in); 
    	
		//System.out.println("Digite o sinal do numero A");
		//String signalA = sc1.next()
    	System.out.println("Digite um valor");
    	String valueA = sc1.next();
    	
    	//System.out.println("Digite o sinal do numero B");
    	//String signalB = sc1.next();
    	System.out.println("Digite um valor");
    	String valueB = sc1.next();
    	
    	int bigest = Math.max(valueA.length(),valueB.length());
    	
    	int [] packA = new int[bigest];
    	int [] packB = new int[bigest];
 	
    	System.out.println();
    	
    	//Conversão e alinhamento dos imputs de entrada
    	
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
    	
    	//Passagem para respectiva função
    	
    	//pack [0] = Integer.parseInt(valueA) ;
    	//pack [1] = Integer.parseInt(valueB) ;
    	//pack [2] = Integer.parseInt(signalA);
    	//pack [3] = Integer.parseInt(signalB);


		/**/
    	
    	/**/
    	System.out.println();
    	System.out.print("    ");
    	for(int i = 0 ;i <bigest ;i++) {	
    		System.out.print("   "+packA[i]);
    	}
    	System.out.println();
    	System.out.print("    ");
    	for(int i = 0 ;i <bigest ;i++) {
    		System.out.print("   "+packB[i]);
    	};
    	System.out.println();
    	System.out.println ("....................................");
    	
    	int[] result = sum(packA,packB);
    	
    	

    	System.out.println();
		/*
    	for (int i = 0 ; i < result.length ; i++)
			System.out.print("   "+result[i]);
			
		*/
    	
    	
		//System.out.println(valueA+" + "+valueB+" = "+result[0]+" | Carry out  = "+result[1]);
    	
    	
    	
    	

    	
 
	}
	

}

