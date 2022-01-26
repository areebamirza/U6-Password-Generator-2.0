import java.util.*;
import java.io.*;

class Main {
  
  public static void menu(char[] lower, char[] upper, char[] mixed, char[] mixedNum, char[] allChars) throws IOException {

    System.out.println("\nPlease select what type of password you would like to generate!\n\n1. Lowercase Letters\n2. Uppercase Letters\n3. Uppercase and Lowercase Letters\n4. Uppercase, Lowercase, and Numbers\n5. Uppercase, Lowercase, Numbers, and Symbols\n0. Exit\n\nEnter selection by typing numbers 1, 2, 3, 4, 5, or 0:\n");

    Scanner scan = new Scanner(System.in);
    int select = scan.nextInt();

    if(select == 0)
    {
      System.out.println("\nExiting...");
    }
    else if(select == 1)
    {
      File outputFile = new File("Lowerpw.txt");
      generatePW(lower, outputFile);
    }
    else if(select == 2)
    {
      File outputFile = new File("Upperpw.txt");
      generatePW(upper, outputFile);
    }
    else if(select == 3)
    {
      File outputFile = new File("Mixedpw.txt");
      generatePW(mixed, outputFile);
    }
    else if(select == 4)
    {
      File outputFile = new File("MixedNumpw.txt");
      generatePW(mixedNum, outputFile);
    }
    else if(select == 5)
    {
      File outputFile = new File("AllCharspw.txt");
      generatePW(allChars, outputFile);
    }

  }


  public static void generatePW(char[] arr1, File outputFile) throws IOException {

    char[] arr2 = new char[arr1.length];
    for(int a = 0; a < arr2.length; a++)
    {
      arr2[a] = arr1[a];
    }

    int counter = 1;
    PrintWriter output = new PrintWriter(outputFile);
    for(int b = 1000; b > 0; b--)
    {
      int print = (int) (b * Math.random());
      output.print(arr2[print]);
      if(counter % 8 == 0)
      {
        output.println();
      }
      counter++;

      char temp = arr2[print];
      for(int c = print; c < arr2.length - 1; c++)
      {
        arr2[c] = arr2[c + 1];
      }
      arr2[arr2.length - 1] = temp;
    }
    output.close();

  }

  
  public static void main(String[] args) throws IOException {
    
    // Generate input files
    
    File inputFile1 = new File("Lower.txt"); // file 1
    PrintWriter input1 = new PrintWriter(inputFile1);
    for(int i = 1; i <= 1000; i++)
    {
      int print = (int) (97 + (26 * Math.random()));
      input1.println(print);
    }
    input1.close();

    File inputFile2 = new File("Upper.txt"); // file 2
    PrintWriter input2 = new PrintWriter(inputFile2);
    for(int i = 1; i <= 1000; i++)
    {
      int print = (int) (65 + (26 * Math.random()));
      input2.println(print);
    }
    input2.close();

    File inputFile3 = new File("Mixed_letters.txt"); // file 3
    PrintWriter input3 = new PrintWriter(inputFile3);
    for(int i = 1; i <= 1000; i++)
    {
      int print = (int) (65 + (58 * Math.random()));
      if(print < 91 || print > 96)
      {
        input3.println(print);
      }
      else
      {
        i--;
      }
    }
    input3.close();

    File inputFile4 = new File("Mixed_letters_numbers.txt"); // file 4
    PrintWriter input4 = new PrintWriter(inputFile4);
    for(int i = 1; i <= 1000; i++)
    {
      int print = (int) (48 + (75 * Math.random()));
      if((print >= 48 && print <= 57) || (print >= 65 && print <= 90) || (print >= 97 && print <= 122))
      {
        input4.println(print);
      }
      else
      {
        i--;
      }
    }
    input4.close();

    File inputFile5 = new File("Mixed_chars.txt"); // file 5
    PrintWriter input5 = new PrintWriter(inputFile5);
    for(int i = 1; i <= 1000; i++)
    {
      int print = (int) (33 + (94 * Math.random()));
      input5.println(print);
    }
    input5.close();


    // Generate int arrays

    int[] lowerInts = new int[1000];
    int[] upperInts = new int[1000];
    int[] mixedLetInts = new int[1000];
    int[] mixedLetNumInts = new int[1000];
    int[] allCharsInts = new int[1000];


    // Store input files in int arrays

    Scanner scan1 = new Scanner(inputFile1); // file 1
    int index1 = 0;
    while(scan1.hasNextInt())
    {
      lowerInts[index1] = scan1.nextInt();
      index1++;
    }
    scan1.close();

    Scanner scan2 = new Scanner(inputFile2); // file 2
    int index2 = 0;
    while(scan2.hasNextInt())
    {
      upperInts[index2] = scan2.nextInt();
      index2++;
    }
    scan2.close();

    Scanner scan3 = new Scanner(inputFile3); // file 3
    int index3 = 0;
    while(scan3.hasNextInt())
    {
      mixedLetInts[index3] = scan3.nextInt();
      index3++;
    }
    scan3.close();

    Scanner scan4 = new Scanner(inputFile4); // file 4
    int index4 = 0;
    while(scan4.hasNextInt())
    {
      mixedLetNumInts[index4] = scan4.nextInt();
      index4++;
    }
    scan4.close();

    Scanner scan5 = new Scanner(inputFile5); // file 5
    int index5 = 0;
    while(scan5.hasNextInt())
    {
      allCharsInts[index5] = scan5.nextInt();
      index5++;
    }
    scan5.close();


    // Generate char arrays

    char[] lower = new char[1000];
    char[] upper = new char[1000];
    char[] mixed = new char[1000];
    char[] mixedNum = new char[1000];
    char[] allChars = new char[1000];

    
    // Populate char arrays

    for(int i = 0; i < lower.length; i++) // lower / lowerInts
    {
      int value = lowerInts[i];
      char crctr = (char)value;
      lower[i] = crctr;
    }

    for(int i = 0; i < upper.length; i++) // upper / upperInts
    {
      int value = upperInts[i];
      char crctr = (char)value;
      upper[i] = crctr;
    }

    for(int i = 0; i < mixed.length; i++) // mixed / mixedLetInts
    {
      int value = mixedLetInts[i];
      char crctr = (char)value;
      mixed[i] = crctr;
    }

    for(int i = 0; i < mixedNum.length; i++) // mixedNum / mixedLetNumInts
    {
      int value = mixedLetNumInts[i];
      char crctr = (char)value;
      mixedNum[i] = crctr;
    }

    for(int i = 0; i < allChars.length; i++) // allChars // allCharsInts
    {
      int value = allCharsInts[i];
      char crctr = (char)value;
      allChars[i] = crctr;
    }


    // Print menu and generate passwords

    System.out.println("Welcome to the password generator!");

    menu(lower, upper, mixed, mixedNum, allChars);

    System.out.println("\nDo you wish to continue? Enter y to generate new passwords or n to exit\n");

    Scanner cont = new Scanner(System.in);
    String enter = cont.nextLine();

    if(enter.equals("y"))
    {
      menu(lower, upper, mixed, mixedNum, allChars);
      System.out.println("\nGoodbye!");
    }
    else if(enter.equals("n"))
    {
      System.out.println("\nGoodbye!");
    }


    /*
    System.out.println(lower);
    System.out.println(upper);
    System.out.println(mixed);
    System.out.println(mixedNum);
    System.out.println(allChars);
    */

  }
}