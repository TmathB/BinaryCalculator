public class Sum {
	
	
	public Sum(){
	}
	public static int[] doSum(int [] packA,int [] packB ) {
		
		///*

		int [] computed = new int [packA.length+1];
		int [] carryOut =
				new int [packA.length+1];
		int a ;
		int b ; 
	
		
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
}

