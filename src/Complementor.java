public class Complementor {

 public Complementor() {}
 
 
 public static int [] doComplement(int[] packA) {
	 
	int [] Um = new int [packA.length];
	
	Um [packA.length-1] = 1;
   
   
	Sender soma = new Sender();
	
	for(int i = 0 ; i < packA.length ; i++){
		 
		 if(packA[i] == 0){
			packA[i] = 1;
		 }
	     else if(packA[i] == 1){
			packA[i] = 0;
		 }
	}
	
	int complemented []  =(Sender(packA,Um,'+')).clone();
	///*
	for(int i = 0 ; i<packA.length-1;i++) {
			System.out.print(packA[i]);
	}
	//*/ 			 
	return complemented;
	 
 }
 
}