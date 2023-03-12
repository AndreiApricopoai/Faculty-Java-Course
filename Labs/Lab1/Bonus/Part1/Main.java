package Lab1.Bonus.Part1;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        //Citim de la tastatura n
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n : ");
        int n = scanner.nextInt();

        //Verificam ca n sa fie natural
        if(n <= 0)
            throw new NumberFormatException("Numarul NU trebuie sa fie NEGATIV sau ZERO!");

        //Creare matrice

        int[][] matrice = new int[n][n];

        //Setam toate elementele pe 0

        Utilitar.setareMatriceZero(matrice,n);

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

        //Afisare matrice.
        System.out.println("Matricea de adiacenta calculata : ");
        Utilitar.afisareMatrice(matrice,n);


        int[][] aux = new int[n][n]; // Aici retinem rezultatul ridicarii la putere a matricii.


        for(int i = 2 ; i <=n ; i++){
            if(i == 2){
                aux = Utilitar.multiplyMatrices(matrice,matrice,n).clone();
                System.out.println("Matricea A^" + i + " : ");
                Utilitar.afisareMatrice(aux,n);
            }
            else {
                aux = Utilitar.multiplyMatrices(aux,matrice,n).clone();
                System.out.println("Matricea A^" + i + " : ");
                Utilitar.afisareMatrice(aux,n);

            }
        }
    }
}