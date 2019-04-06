public class Complement {

 public Complement() {}
 
 
 
 public static int [] um = {1};
 
 public static int [] doComplement(int[] packA) {
     
	Sum soma = new Sum();
	
	 for(int i = 0 ; i < packA.length ; i++){
		 if(packA[i] == 0){
			 packA[i] = 1;
		 }
	     else if(packA[i] == 1){
			 packA[i] = 0;
		 }
		 soma.doSum(packA,um);
				 
	 }
	 System.out.print(packA);
	 
	 return packA;
	 
 }


}