public class Subtraction{
	
	public Subtraction(){}
	
	public static int[] doSub(int[] packA, int[] packB){
		
		

		Sumator soma = new Sumator();
		Complementor comp = new Complementor();
	
		int [] complement = (comp.doComplement(packB)).clone();	
				/*
		int [] result = Sumator.doSum(packA,packB);
		*/
		
		
		int[] result  = {1,2,3};
		return result;
	
	}
}