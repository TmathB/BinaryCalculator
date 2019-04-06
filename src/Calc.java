import java.util.Scanner;
import java.util.Arrays; 

public class Calc {
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
    		for(int
    				i = valueB.length()-valueA.length() ;i<bigest;i++) {
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
    	
    	Sum soma = new Sum();
    	Sum.doSum(packA,packB);

    	System.out.println();
		
 
	}
	

}

