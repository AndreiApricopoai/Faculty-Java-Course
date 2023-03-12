package Lab1.Compulsory;

import java.lang.System;
import java.lang.Math;

class Main
{
	public static void main(String[] args)
	{
        
        System.out.println("Hello, World");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000); // Aici generam un numar random.

        n = ((n * 3) + 0b10101 +  0xFF) * 6; // Calculul cerut.


        int sum = 0;

        // Aici generam prima suma a cifrelor.
         while(n != 0){
            sum = sum + n%10;
            n = n / 10;
         }
        
        // Aici generam cifra de control.
        while(sum > 9){

            n = sum;
            sum = 0;

            while(n != 0){
                sum = sum + n%10;
                n = n / 10;
             }
        }



        int result = sum;
        System.out.println(result + "\n");
        System.out.println("Willy-nilly, this semester I will learn " + languages[result] + ".\n");



	}
}