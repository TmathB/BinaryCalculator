public class Complement {

 public Complement() {}
 
 
 public static int [] doComplement(int[] packA) {
	 
	int [] Um = new int [packA.length];
	
	Um [packA.length-1] = 1;
   
   
	Sum soma = new Sum();
	
	for(int i = 0 ; i < packA.length ; i++){
		 
		 if(packA[i] == 0){
			packA[i] = 1;
		 }
	     else if(packA[i] == 1){
			packA[i] = 0;
		 }
	}
	 
	soma.doSum(packA,Um);
				 
	return packA;
	 
 }
 
}