import java.io.PrintStream;
import java.util.Scanner;

public class Calc
{
  public Calc() {}
  
  static int[] sum(int[] paramArrayOfInt) {
    int i = paramArrayOfInt[0];
    int j = paramArrayOfInt[1];
    
    int[] arrayOfInt = new int[2];
    

    if ((i == 1) && (j == 1)) {
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 1;
    }
    else if ((i == 1) && (j == 0)) {
      arrayOfInt[0] = 1;
      arrayOfInt[0] = 0;
    }
    else if ((i == 0) && (j == 1)) {
      arrayOfInt[0] = 1;
      arrayOfInt[1] = 0;
    }
    else if ((i == 0) && (j == 0)) {
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
    }
    
    return arrayOfInt;
  }
  
  public static void main(String[] paramArrayOfString) { java.util.Scanner localScanner = new java.util.Scanner(System.in);
    


    System.out.println("Digite um valor");
    String str1 = localScanner.next();
    


    System.out.println("Digite um valor");
    String str2 = localScanner.next();
    
    int i = Math.max(str1.length(), str2.length());
    
    int[] arrayOfInt1 = new int[i];
    int[] arrayOfInt2 = new int[i];
    










    System.out.println();
    int j = 0;
    if (str1.length() > str2.length()) {
      for (k = 0; k < i; k++) {
        try {
          arrayOfInt1[k] = Character.getNumericValue(str1.charAt(k));
        }
        catch (Exception localException1) {}
      }
      

      for (k = str1.length() - str2.length(); k < i; k++)
      {
        try {
          arrayOfInt2[k] = Character.getNumericValue(str2.charAt(j));
          j++;
        }
        catch (Exception localException2) {}
        System.out.print(k);
      }
    } else {
      for (k = str2.length() - str1.length(); k < i; k++) {
        try {
          arrayOfInt1[k] = Character.getNumericValue(str1.charAt(j));
          j++;
        }
        catch (Exception localException3) {}
      }
      

      for (k = 0; k < i; k++)
      {
        try {
          arrayOfInt2[k] = Character.getNumericValue(str2.charAt(j));
          j++;
        }
        catch (Exception localException4) {}
        System.out.print(k);
      }
    }
    

    System.out.println();
    for (int k = 0; k < i; k++) {
      System.out.print(arrayOfInt1[k] + "  ");
    }
    System.out.println();
    for (k = 0; k < i; k++) {
      System.out.print(arrayOfInt2[k] + "  ");
    }
    
    System.out.println();
    System.out.println("----------------------------------------");
  }
}