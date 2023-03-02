package Lab1.Bonus.Part1;

import java.util.Scanner;

public class Main {

    public static void afisareMatrice(int[][] matrice, int dimensiune){
        for(int i = 0 ; i < dimensiune ; i++) {
            for (int j = 0; j < dimensiune; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void setareMatriceZero(int[][] matrice, int dimensiune){
        for(int i = 0 ; i < dimensiune ; i++)
            for(int j = 0 ; j < dimensiune ; j++)
                matrice[i][j] = 0;
    }
    public static  int[][] multiplyMatrices(int[][] a, int[][] b,  int dimensiune){
        //matricile sunt patratice
        int[][] rezultat = new int[dimensiune][dimensiune];
        setareMatriceZero(rezultat,dimensiune);

        for (int i = 0; i < dimensiune; i++) { // cu i time evidenta liniilor
            for (int j = 0; j < dimensiune; j++) { // cu j tinem evidenta coloanelor
                for (int k = 0; k < dimensiune; k++) { // cu k tinem evidenta elementelor de pe acele linii si coloane
                    rezultat[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return rezultat;
    }


    public static void main(String[] args) {

        //Citim de la tastatura n
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n : ");
        int n = scanner.nextInt();

        //verificam ca n sa fie natural
        if(n <= 0)
            throw new NumberFormatException("Numarul NU trebuie sa fie NEGATIV sau ZERO!");

        //Creare matrice

        int[][] matrice = new int[n][n];

        //Setam toate elementele pe 0

        setareMatriceZero(matrice,n);

        //Pentru fiecare element i, el va fi legat de i-1 si i+1, iar daca i+1 depaseste n atunci ne vom intoarce cu i de la 0
        //iar daca i-1 < 0 atunci ne vom duce cu indexul la n
        //ex pentru n = 4
        /*
                0 1 2 3 4
               ------------
             0| 0 1 0 0 1
             1| 1 0 1 0 0
             2| 0 1 0 1 0
             3| 0 0 1 0 1
             4| 1 0 0 1 0
         */
        for(int i = 0 ; i < n ; i++){
            if((i+1) >= n){
                matrice[i][i-1] = 1;
                matrice[i][0] = 1;
            }
            else if((i-1) < 0){
                matrice[i][i+1] = 1;
                matrice[i][n-1] = 1;
            }
            else{
                matrice[i][i+1] = 1;
                matrice[i][i-1] = 1;
            }
        }

        //Afisare matrice
        System.out.println("Matricea de adiacenta calculata : ");
        afisareMatrice(matrice,n);


        int[][] aux = new int[n][n];


        for(int i = 2 ; i <=n ; i++){
            if(i == 2){
                aux = multiplyMatrices(matrice,matrice,n).clone();
                System.out.println("Matricea A^" + i + " : ");
                afisareMatrice(aux,n);
            }
            else {
                aux = multiplyMatrices(aux,matrice,n).clone();
                System.out.println("Matricea A^" + i + " : ");
                afisareMatrice(aux,n);

            }
        }
    }
}