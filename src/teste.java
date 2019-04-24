
import java.util.*;

public class teste{
	
	public static int[] soma(int[] a, int[] b) {

        LinkedList<Integer> resultado = new LinkedList<Integer>();

        int carryOut = 0;

        for (int i = a.length - 1; i >= 0; i--) {
            int bit1 = a[i];
            int bit2 = b[i];
            int sum = bit1 + bit2 + carryOut;
            resultado.add(sum % 2);
            carryOut = sum / 2;

        }
        //System.out.print(carryOut);
        if (carryOut == 1)
            resultado.add(1);

        int[] result = new int[resultado.size()];

        int u = 0;
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = resultado.get(u);
            u++;
        }

        return result;

    }
	
	
	
public static int[] complemento(int[] b) {

        int[] Um = new int[b.length];
        int[] complementado = b.clone();

        Um[b.length - 1] = 1;


        ///*
        for (int i = 0; i < b.length; i++) {

            if (b[i] == 0) {
                complementado[i] = 1;
            } else if (b[i] == 1) {
                complementado[i] = 0;
            }
        }
        //
        int [] complemented = (soma(complementado, Um)).clone();

		for(int i = 0; i < complemented.length;i++){
			System.out.print(complemented[i] + " ");
		}
		System.out.println();
		
		
        return complemented;


    }	


public static int[] multiplicacao(int [] a, int [] b){
	
	    int [] complementoA = (complemento(a)).clone();
		
		int x = complementoA.length;
		int y = b.length;
		
		int [] A = new int[x + y + 1 ];
		int [] S = new int[x + y + 1 ];
		int [] P = new int[x + y + 1 ];
		
		int [] Temp = new int[P.length];
		
		int l = 1;
		int k = 0;
		
		//Preenchimento da matriz (0 -> valorA)
		for(int i = 0; i < x; i++){
			A[i] = a[i];
			S[i] = complementoA[i];
			P[i] = 0;
		
		}
		
		//Preenchimento da matriz(valorA -> final da Matriz)
		for(int i = x; i < P.length-1; i++){
			A[i] = 0;
			S[i] = 0;
			if(k < b.length) P[i] = b[k];
				
			k++;
		}	
		
		A[A.length-1] = 0;
		S[S.length-1] = 0;
		P[P.length-1] = 0;
		
		
		for(int r = 0; r < b.length; r++){
			if(P[P.length-2] == 0 && P[P.length-1] == 1){
				
				Temp = ((soma(P,A))).clone();
				
				 if(Temp.length > A.length){
					 
					for(int i = 0; i < P.length; i++){
						P[i] = Temp[l];
						l++;
					}
					for(int j = P.length-1; j > 0; j--){
						P[j] = P[j-1];
					}
					 
				 }else{
		
				   P = (soma(P,A)).clone();
				   
					for(int j = P.length-1; j > 0; j--){
						P[j] = P[j-1];
					}
				 }
				
				
			}else if(P[P.length-2] == 1 && P[P.length-1] == 0){
				
				  Temp = ((soma(P,S))).clone();
				
				 if(Temp.length > A.length){
					 
					for(int i = 0; i < P.length; i++){
						P[i] = Temp[l];
						l++;
					}
					for(int j = P.length-1; j > 0; j--){
						P[j] = P[j-1];
					}
					 
				 }else{
		
				   P = (soma(P,S)).clone();
				   
					for(int j = P.length-1; j > 0; j--){
						P[j] = P[j-1];
					}
				 }
				
				
			}else if(P[P.length-1]== 0 && P[P.length-2] == 0 || P[P.length-1]==1 && P[P.length-2] == 1){
				for(int j = P.length-1; j > 0; j--){
					P[j] = P[j-1];
				}
			}
			
		}
		
			for(int i = 0; i < A.length; i++){
					System.out.print(A[i] + " ");
			}
			System.out.println();
			for(int i = 0; i < S.length; i++){
					System.out.print(S[i] + " ");
			}
			System.out.println();
			for(int i = 0; i < P.length; i++){
					System.out.print(P[i] + " ");
			}
			System.out.println();	
	
	    int [] result = new int [P.length-1];
		
		
		int j = 1;
		
		for(int i = 0; i < result.length; i++){
			result[i] = P[j];
			j++;
		}
		
		
		for(int i = 0; i < result.length-1; i++){
					System.out.print(result[i] + " ");
			}
	
		return result;
		
	}
	
public static void main(String[] args){
	
	int [] a = {0,0,1,0};
	int [] b = {0,1,0,0};
	
	multiplicacao(a,b);
}
}