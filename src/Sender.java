/*In this class the values given as parameter
 * are Alingned and the Imput class are 
 * designeded to their repective funtions 
 * for each operation
*/
public class Sender{
	
	public Sender() {};
	
	private int size;
	private String valueA;
	private String valueB;
	
	public Sender(String valueA,String valueB) {
		this.valueA = valueA;
		this.valueB = valueB;
		this.size = Math.max(valueA.length(),valueB.length());
	};
	
	public static int [] alingnedA ;
	public static int [] alingnedB ;
	public static int [] result;
	

	public int [] alingnedA() {
		return alingnedA;
	}
	public int [] alingnedB() {
		return alingnedB;
	}
	//Alaing items
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
    	
    	alingnedA = packA.clone();
    	alingnedB = packB.clone();
		
	}
	//Aling the values and choose the operation
	public static void select(String valueA,String valueB,String signal) {
		
		
		alingPackAB(valueA,valueB);
		Sumator sum  = new Sumator();
		String work = signal;
		if(work.equals("+")) {
			result = (Sumator.doSum(alingnedA, alingnedB)).clone();
			//printVal();
		}else if(work.equals("-")) { 
			result = (Subtraction.doSub(alingnedA, alingnedB)).clone();
			//printVal();
		}else {
			System.out.println("Passe um sinal valido");
		}
		
		
		
	}
	
	//Print the values returned
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
		for (int i = 0 ; i < result.length ; i++)
			System.out.print(result[i]);
		
		
	}

}
