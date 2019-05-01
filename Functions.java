	
	import java.util.*;
	
	public class Functions{
	
	public Functions(){}
	
	
	public static int[] alingnedA;
    public static int[] alingnedB;
	
	public static void alingPackAB(int[] valueA, int[] valueB) {
		

        int bigest = Math.max(valueA.length, valueB.length);

        int[] packA = new int[bigest];
        int[] packB = new int[bigest];

        System.out.println();

        int j = 0;
        if (valueA.length == valueB.length) {
            for (int i = 0; i <= packA.length - 1; i++) {

                packA[i] = valueA[i];


            }
            for (int i = 0; i <= valueA.length - 1; i++) {


                packB[i] = valueB[i];


            }

        } else if (valueA.length > valueB.length) {
            for (int i = 0; i < bigest; i++) {
                try {
                    packA[i] = valueA[i];
                } catch (Exception e) {
                }
            }
            for (int i = valueA.length - valueB.length; i < bigest; i++) {

                try {
                    packB[i] = valueB[j];
                    j++;
                } catch (Exception e) {
                }

                //System.out.print(i);
            }
        } else {
            for (int i = valueB.length - valueA.length; i < bigest; i++) {
                try {
                    packA[i] = valueA[j];
                    j++;
                } catch (Exception e) {
                }
            }
            for (int i = 0; i < bigest; i++) {

                try {
                    packB[i] = valueB[i];
                } catch (Exception e) {
                }
            }
        }
      
        alingnedA = packA.clone();
        alingnedB = packB.clone();

    }
	
	
	public static void alingPackABC(int[] valueA, int[] valueB) {

        int bigest = Math.max(valueA.length, valueB.length);

        int[] packA = new int[bigest];

        int[] packB = new int[bigest];

        for(int i= 0 ; i<packB.length; i++){
            packB[i] = 1;
        }


        int j = 0;
        if (valueA.length == valueB.length) {
            for (int i = 0; i <= packA.length - 1; i++) {

                packA[i] = valueA[i];

            }
            for (int i = 0; i <= valueA.length - 1; i++) {

                packB[i] = valueB[i];

            }

        } else if (valueA.length > valueB.length) {
            for (int i = 0; i < bigest; i++) {
                try {
                    packA[i] = valueA[i];
                } catch (Exception e) {
                }
            }
            for (int i = valueA.length - valueB.length; i < bigest; i++) {

                try {
                    packB[i] = valueB[j];
                    j++;
                } catch (Exception e) {
                }

            }
        } else {
            for (int i = valueB.length - valueA.length; i < bigest; i++) {
                try {
                    packA[i] = valueA[j];
                    j++;
                } catch (Exception e) {
                }
            }
            for (int i = 0; i < bigest; i++) {

                try {
                    packB[i] = valueB[i];
                } catch (Exception e) {
                }
            }
        }
		
        alingnedA = packA.clone();
        alingnedB = packB.clone();
    }
	
	
	public static void convertToArrayInt(String a, String b) {
        int[] packA = new int[a.length()];
        int[] packB = new int[b.length()];

        for (int i = 0; i < packA.length; i++) {
            packA[i] = Character.getNumericValue(a.charAt(i));
        }
       
        for (int i = 0; i < packB.length; i++) {
            packB[i] = Character.getNumericValue(b.charAt(i));
        }


        alingnedA = packA.clone();
        alingnedB = packB.clone();
    }
	
	
	public static int[] groupSS(int s, int[] a) {

        int[] novo = new int[1 + a.length];

        novo[0] = s;

        for (int i = 1; i < novo.length; i++) {
            novo[i] = a[i - 1];
        }

        return novo;

    }


    public static boolean verifyZero(int[] b) {
        int j = 0;
        for(int i=0;i<b.length;i++){
            if(b[i] != 0 )
                j++;
        }
        if(j==0)
            return true;
        else
            return false;

    }
	
}