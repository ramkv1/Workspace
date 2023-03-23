package com.rk.main;

 import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void main(String args[] ) throws Exception {

 Scanner s = new Scanner(System.in);

        String name = s.nextLine();

        List<Character> vowel = new ArrayList<Character>();

        vowel.add('A');

        vowel.add('E');

        vowel.add('I');

        vowel.add('O');

        vowel.add('U');

        vowel.add('Y');

        if (((Character.getNumericValue(name.charAt(0)) + Character.getNumericValue(name.charAt(1))) % 2 == 0) &&
        ((Character.getNumericValue(name.charAt(3)) + Character.getNumericValue(name.charAt(4))) % 2 == 0) &&
        ((Character.getNumericValue(name.charAt(4)) + Character.getNumericValue(name.charAt(5))) % 2 == 0)&&
         ((Character.getNumericValue(name.charAt(7)) + Character.getNumericValue(name.charAt(8))) % 2 == 0)&&
          !vowel.contains(name.charAt(2)))

        {

            System.out.println("valid");

        }

        else

        {

            System.out.println("invalid");

        }

    }
}
