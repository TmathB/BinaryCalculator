public static int[] multiplicacao(int [] a, int [] b){
		
		int [][] conta = new int [3][a.length + b.length + 1];
		
		int [] complementoA = (complemento(a)).clone();
		
		int [] result = new int [conta[0].length];
		
		int k = 0;
		
		//Preenchimento da matriz (0 -> valorA)
		for(int i = 0; i < conta.length; i++){
			for(int j = 0; j < a.length; j++){
				if(i == 0){
					conta[i][j] = a[j];
				}
				else if(i == 1){
					conta[i][j] = complementoA[j];
				}
				else if(i == 2){
					conta[i][j] = 0;
				}
			}
		}
		
		//Preenchimento da matriz(valorA -> final da Matriz)
		for(int i = 0; i < conta.length; i++){
			for(int j = (a.length); j < conta[0].length; j++){
			
				if(i == 0){
					conta[i][j] = 0;
					conta[i][conta[0].length-1] = 0;
					
				}else if(i == 1){
					conta[i][j] = 0;
					conta[i][conta[0].length-1] = 0;
					
				}else if(i == 2){
					if(k < b.length)
					conta[i][j] = b[k];
					conta[i][conta[0].length-1] = 0;
					k++;
					
				}
				
			}
			
		}	
		
		//for(int r = 0; r < b.length; r++){
			/*if(conta[2][conta[0].length-1]== 0 && conta[2][conta[0].length-2] == 1){
					for(int j = 0; j < conta[0].length-1; j++){
						conta[2][j] = conta[0][j] + conta[2][j];
						
						conta[2][j] = conta[2][j+1];
						
						if(conta[2][0] == 1){
							conta[2][0] = 1;
						}
						else{
							conta[2][0] = 0;
						}
					}
				
				
			}else if(conta[2][conta[0].length-1]== 1 && conta[2][conta[0].length-2] == 0){
					for(int j = 0; j<conta[0].length-1; j++){
						conta[2][j] = conta[1][j] + conta[2][j];
						
						conta[2][j] = conta[2][j+1];
						
						if(conta[2][0] == 1){
							conta[2][0] = 1;
						}
						else{
							conta[2][0] = 0;
						}
					}
				
			}else*/ if(conta[2][conta[0].length-1]== 0 && conta[2][conta[0].length-2] == 0 || conta[2][conta[0].length-1]==1 && conta[2][conta[0].length-2] == 1){
				for(int j = conta[0].length-1; j > 0; j--){
				conta[2][j] = conta[2][j-1];
				
					if(conta[2][0] == 1){
							conta[2][0] = 1;
					}
					else if(conta[2][0] == 0){
						conta[2][0] = 0;
						}
				}
			}
			
		//}
	    	
		for(int i = 0; i < conta.length; i++){
			for(int j = 0; j < conta[0].length; j++){
				if(i == 0){
					System.out.print(conta[i][j] + " ");
					
				}else if(i == 1){
					System.out.print(conta[i][j] + " ");
					
				}else if(i == 2){
					System.out.print(conta[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		for(int i = 0; i < conta[0].length-1; i++){
			result[i] = conta[2][i];	
		}
		
		return a;
		
	}