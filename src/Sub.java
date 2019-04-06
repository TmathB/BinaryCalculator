public class Sub{
	
	public Sub(){}
	
	public static int[] doSub(int[] packA, int[] packB){
	
	
		Sum soma = new Sum();
		Complement comp = new Complement();
	
		if(packA[0] == 1 ){
			comp.doComplement(packA);
		}
		else if(packB[0] == 1){
			comp.doComplement(packB);	
		}
	
		int [] result = soma.doSum(packA,packB);
	
		return result;
	
	}
}