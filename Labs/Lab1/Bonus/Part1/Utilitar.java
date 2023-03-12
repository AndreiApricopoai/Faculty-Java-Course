package Lab1.Bonus.Part1;

/**
 * This class contains methods that work with matrices.
 * @author Apricopoai Andrei
 * @version 1.0
 */
public final class Utilitar {

    /**
     * Afisare matrice.
     *
     * @param matrice    the actual matrix to be printed to the screen.
     * @param dimensiune the dimension of the matrix.
     */
    public static void afisareMatrice(int[][] matrice, int dimensiune){
        for(int i = 0 ; i < dimensiune ; i++) {
            for (int j = 0; j < dimensiune; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Sets the matrix to 0 on all cells.
     *
     * @param matrice    the matrix to be set to 0.
     * @param dimensiune the dimension of the matrix.
     */
    public static void setareMatriceZero(int[][] matrice, int dimensiune){
        for(int i = 0 ; i < dimensiune ; i++)
            for(int j = 0 ; j < dimensiune ; j++)
                matrice[i][j] = 0;
    }

    /**
     * Multiplies the two matrices and returns the resulted multiplied matrix.
     *
     * @param a          the first matrix
     * @param b          the second matrix
     * @param dimensiune the dimension of the two matrices (they have the same dimension)
     * @return the resulted multiplied matrix.
     */
    public static int[][] multiplyMatrices(int[][] a, int[][] b,  int dimensiune){
        //matricile sunt patratice
        int[][] rezultat = new int[dimensiune][dimensiune];
        setareMatriceZero(rezultat,dimensiune);

        for (int i = 0; i < dimensiune; i++) { // cu i timem evidenta liniilor
            for (int j = 0; j < dimensiune; j++) { // cu j tinem evidenta coloanelor
                for (int k = 0; k < dimensiune; k++) { // cu k tinem evidenta elementelor de pe acele linii si coloane
                    rezultat[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return rezultat;
    }
}
