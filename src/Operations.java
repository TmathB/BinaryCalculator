
import java.util.*;

public class Operations{
	
		public Operations(){}
	
		Functions functions = new Functions();
	
		public static int[] resto;
		public static int[] not = {0};
	
	
	 public static int[] complemento(int[] b) {
	
			
			int[] Um = new int[b.length];
			int[] complementado = b.clone();

			Um[b.length - 1] = 1;


        
			for(int i = 0; i < b.length; i++) {

				if (b[i] == 0) {
					complementado[i] = 1;
				} else if (b[i] == 1) {
					complementado[i] = 0;
				  }
			}
        
			 int complemented[] = (soma(complementado, Um)).clone();
		
			return complemented;


    }
	
	
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


    public static int[] subtracao(int[] a, int[] b) {

        int bitSinal = 0;


        if(Functions.verifyZero(a)){
			
            return complemento(b);
			
        }else if(Functions.verifyZero(b)){
            return a;
			
        }else{



            b = (Functions.groupSS(bitSinal ,b)).clone();

            int[] complement = (complemento(b)).clone();



            Functions.alingPackABC(a,complement);

            int [] finalResult = new int[Functions.alingnedA.length];

            int[] result = soma(Functions.alingnedA, complement);

            int j = 1;



            if (result.length > Functions.alingnedA.length) {
                for (int i = 0; i < finalResult.length; i++) {
                    finalResult[i] = result[j];
                    j++;
                }

                return finalResult;
            } else {
                for (int i = 0; i < finalResult.length; i++) {
                    finalResult[i] = result[i];
                    j++;
                }
            }

            return result;


        }
    }


    public static int[] divisao(int[] a, int[] b, int tamBits) {


        LinkedList<Integer> aTemp = new LinkedList<Integer>();
        LinkedList<Integer> restoI = new LinkedList<Integer>();


        for (int i = 0; i <= a.length - 1; i++) {
            aTemp.add(a[i]);
        }

        int[] quocient = new int[tamBits];
        int[] um = new int[tamBits];
        um[tamBits - 1] = 1;

        int[] complemented = (complemento(b)).clone();


        while (aTemp.size() != a.length - 1) {


            int[] aI = new int[aTemp.size()];

            for (int i = 0; i <= aI.length - 1; i++) {
                aI[i] = aTemp.get(i);

            }

            int[] resultado = (soma(aI, complemented)).clone();

            int tamProv = resultado.length;

            aTemp.clear();


            for (int i = 0; i <= resultado.length - 2; i++) {
                aTemp.add(resultado[i + 1]);
            }


            if (aTemp.size() == a.length - 1) {

                break;
            }


            restoI.clear();
            for (int i = 0; i < resultado.length - 1; i++)
                restoI.add(resultado[i + 1]);

            int[] restoT = new int[restoI.size()];


            for (int i = 0; i < restoI.size(); i++) {
                restoT[i] = restoI.get(i);


            }

            resto = restoT.clone();


            quocient = (soma(quocient, um)).clone();

        }


        return quocient;
    }


    public static int[] multiplicacao(int [] a, int [] b) {

        int [] resultI;
        if (Functions.verifyZero(a) || Functions.verifyZero(b)) {
            return not;

        }else {

            int[] complementoA = (complemento(a)).clone();

            int x = complementoA.length;
            int y = b.length;

            int[] A = new int[x + y + 1];
            int[] S = new int[x + y + 1];
            int[] P = new int[x + y + 1];

            int[] Temp = new int[P.length];

            int k = 0;

            //Preenchimento da matriz (0 -> valorA)
            for (int i = 0; i < x; i++) {
                A[i] = a[i];
                S[i] = complementoA[i];
                P[i] = 0;

            }


            //Preenchimento da matriz(valorA -> final da Matriz)
            for (int i = x; i < P.length - 1; i++) {
                A[i] = 0;
                S[i] = 0;
                if (k < b.length) P[i] = b[k];

                k++;
            }

            A[A.length - 1] = 0;
            S[S.length - 1] = 0;
            P[P.length - 1] = 0;


            int l = 1;

            for (int conta = 0; conta < b.length; conta++) {
                if (P[P.length - 2] == 0 && P[P.length - 1] == 1) {

                    Temp = ((soma(P, A))).clone();

                    if (Temp.length > A.length) {

                        for (int i = 0; i < P.length; i++) {
                            P[i] = Temp[l];
                            l++;
                        }
                        for (int j = P.length - 1; j > 0; j--) {
                            P[j] = P[j - 1];
                        }

                    } else {

                        P = (soma(P, A)).clone();

                        for (int j = P.length - 1; j > 0; j--) {
                            P[j] = P[j - 1];
                        }
                    }


                } else if (P[P.length - 2] == 1 && P[P.length - 1] == 0) {

                    Temp = ((soma(P, S))).clone();

                    if (Temp.length > A.length) {

                        for (int i = 0; i < P.length; i++) {
                            P[i] = Temp[l];
                            l++;
                        }
                        for (int j = P.length - 1; j > 0; j--) {
                            P[j] = P[j - 1];
                        }

                    } else {

                        P = (soma(P, S)).clone();

                        for (int j = P.length - 1; j > 0; j--) {
                            P[j] = P[j - 1];
                        }
                    }


                } else if (P[P.length - 1] == 0 && P[P.length - 2] == 0 || P[P.length - 1] == 1 && P[P.length - 2] == 1) {
                    for (int j = P.length - 1; j > 0; j--) {
                        P[j] = P[j - 1];
                    }
                }

            }

            resultI = new int[P.length - 1];


            int j = P.length - 2 ;

            for (int i = resultI.length-1; i >= 0; i--) {
                resultI[i] = P[j];
                j--;
            }
        }

        return resultI;
		
    }

}