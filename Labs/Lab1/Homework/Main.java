package Lab1.Homework;

public class Main {

    //In rezolvarea acestei probleme folosesc metoda permutarilor sirului 1,2,3,...,n
    public static void main(String[] args){

        //aici avem partea de validare (veificam ca avem un singur argument "n", verificam ca "n" este natural)

        long start = System.nanoTime(); // pentru calcularea timpului de executie in caz ca avem un "n" mare

        if(args.length < 1) {
            throw new IllegalArgumentException("Prea PUTINE argumente!");
        }
        if(args.length > 1) {
            throw new IllegalArgumentException("Prea MULTE argumente!");
        }

        String argument = args[0];
        int n = 0;

        try{
            n = Integer.parseInt(argument);
        }
        catch (NumberFormatException exception){
            exception.printStackTrace();
        }

        if(n < 1)
            throw new IllegalArgumentException("VALOAREA DATA NU ESTE NUMAR NATURAL!");
        else
        {
            // Aici construim matricea.
            int[][] matrice = new int[n][n];

            for(int i = 0 ; i < n ; i++) // Aici punem 1 pe diagonala principala.
                matrice[i][i] = 1;

            int k = 0;
            int count = 0;

            // Aici facem pentru elementele deasupra diagonalei principale.
            for (int i = 0 ; i < n-1 ; i++ ){
                count = 2;
                for(int j = k+1 ; j < n ; j++){
                    matrice[i][j] = count;
                    count++;
                }
                k++;
            }

            // Aici facem pentru elementele de sub diagonala principala.
            k = 1;

            for (int i = 1 ; i < n ; i++ ){
                count = n-i+1;
                for(int j = 0 ; j < k ; j++){
                    matrice[i][j] = count;
                    count++;
                }
                k++;
            }


            if(n > 30000){ // Aici avem un "n" mare.

                long stop = System.nanoTime(); // ne oprim
                long totalTime = stop - start;
                System.out.println("\nTimpul total necesar : " + totalTime + " nanosecunde.\n");
            }
            else{ // Aici avem un "n" mic.

                StringBuilder builder = new StringBuilder();

                String linie = "";
                String coloana = "";

                // facem concatenari pe linii
                for(int i = 0 ; i < n ; i++){
                    builder.setLength(0); // resetam builder-ul

                    for(int j = 0 ; j < n ; j++){
                        builder.append(matrice[i][j]).append(" ");
                    }
                    linie = builder.toString();
                    System.out.println("Linia " + (i+1) + " : " + linie);
                }

                System.out.print("\n\n");



                // facem concatenari pe coloane
                for(int j = 0 ; j < n ; j++){
                    builder.setLength(0); // resetam builder-ul

                    for(int i = 0 ; i < n ; i++){
                        builder.append(matrice[i][j]).append(" ");
                    }
                    coloana = builder.toString();
                    System.out.println("Coloana " + (j+1) + " : " + coloana);
                }

            }

        }



    }

}
