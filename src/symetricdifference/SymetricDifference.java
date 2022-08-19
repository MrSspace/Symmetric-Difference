package symetricdifference;

import java.util.ArrayList;
import java.util.Arrays;

/*
Encuentra la diferencia simétrica
El término matemático diferencia simétrica ( △o ⊕) de dos conjuntos es el conjunto de elementos 
que están en cualquiera de los dos conjuntos pero no en ambos. 
Por ejemplo, para conjuntos A = {1, 2, 3}y B = {2, 3, 4}, A △ B = {1, 4}.

La diferencia simétrica es una operación binaria, lo que significa que opera solo en dos elementos. 
Entonces, para evaluar una expresión que involucra diferencias simétricas entre tres elementos ( A △ B △ C), 
debe completar una operación a la vez. Así, para conjuntos Ay B superiores, y 
C = {2, 3}, A △ B △ C = (A △ B) △ C = {1, 4} △ {2, 3} = {1, 2, 3, 4}.
Este es el resultado de la función : Cree una función que tome dos o más matrices y devuelva una matriz
de su diferencia simétrica. La matriz devuelta debe contener solo valores únicos ( sin duplicados ).
 */

public class SymetricDifference {

    public static void main(String... args) {
        int conjunto1[] = {1, 2, 3};
        int conjunto2[] = {2, 3, 4};
        int conjunto3[] = {2, 3};
        int conjunto4[] = {2, 0, 7, 8};
        
        symetricDifferenceInt(conjunto1, conjunto2, conjunto3, conjunto4);
        symetricDifferenceInt(conjunto1, conjunto2, conjunto3);

    }

    public static void symetricDifferenceInt(int[]... sets) {
        int a[] = compareTwo(sets[0], sets[1]);
        int b[] = compareTwo(sets[1], sets[0]);
        int c[] = addArray(a, b);
        
        for (int i = 2; i < sets.length; i++) {
            a = compareTwo(c, sets[i]);
            b = compareTwo(sets[i], c);
            c = addArray(a, b);
        }
        Arrays.sort(c);
        System.out.println("The Symetric Difference is = " + Arrays.toString(c));
    }

    public static int[] compareTwo(int setA[], int setB[]) {
        ArrayList<Integer> setArrayList = new ArrayList<Integer>();
        for (int i = 0; i < setA.length; i++) {
            boolean found = false;
            for (int j = 0; j < setB.length; j++) {
                if (setA[i] == setB[j]) {
                    found = true;
                }
            }
            if (found == false) {
                setArrayList.add(setA[i]);
            }
        }
        int[] setArray = setArrayList.stream().mapToInt(i -> i).toArray();
        return setArray;
    }

    public static int[] addArray(int setA[], int setB[]) {
        int arrayLength = setA.length + setB.length;
        int setArray[] = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            if (i < setA.length) {
                setArray[i] = setA[i];
            } else if (i >= setA.length) {
                setArray[i] = setB[i - setA.length];
            }
        }
        return setArray;
    }

}
