package test;

public class Quicksort {

    public static void quicksort(int[] array, int inicio, int fim) {
        //executa apenas se tiver 2 ou mais elementos
        if(inicio < fim) {
            //separa o array em menores que o pivô e maiores que o pivô e retorna a posição final do pivô na partição
            int iPivot = partition(array, inicio, fim);

            //chama recursivamente para cada metade
            quicksort(array, inicio, iPivot - 1);
            quicksort(array, iPivot + 1, fim);
        }
    }

    private static int partition(int[] array, int inicio, int fim) {
        int length = (fim - inicio) + 1;

        int iPivot = choosePivot(array, inicio, fim);

        //índice que guarda os números menores/iguais que o pivô
        int i = -1;

        for(int j = 0; j < length; j++) {
            //realiza troca se for menor/igual que o pivô
            if(array[j] < array[iPivot]) {
                ++i;
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
            }
        }

        //troca a posição do pivot
        ++i;
        int swap = array[i];
        array[i] = array[iPivot];
        array[iPivot] = swap;

        return i;
    }

    //escolhe a mediana de 3 entre o primeiro elemento, o último elemento e o elemento central como pivô
    private static int choosePivot(int[] array, int inicio, int fim) {
        int mid = (fim - inicio) / 2;

        if(array[inicio] > array[mid]) {
            int swap = array[inicio];
            array[inicio] = array[mid];
            array[mid] = swap;
        }
        if(array[inicio] > array[fim]) {
            int swap = array[inicio];
            array[inicio] = array[fim];
            array[fim] = swap;
        }
        if(array[mid] > array[fim]) {
            int swap = array[mid];
            array[mid] = array[fim];
            array[fim] = swap;
        }

        return mid;
    }
}
