public class BubbleSortAlgorithm {
    public static void sort(int[] list) {
        boolean swap = true;
        int aux;
        while(swap) {
            swap = false;
            for(int j=0; j<list.length-1; j++) {
                if(list[j] > list[j+1]) {
                    aux = list[j];
                    list[j] = list[j+1];
                    list[j+1] = aux;
                    swap = true;
                }
            }
        }
    }

    public static void showList(int[] list) {
        String out = "[ ";
        for(int i = 0; i < list.length-1; i++) {
            out += list[i] + ", ";
        }
        out += list[list.length-1] + " ]";

        System.out.println(out);
    }

    public static void main(String[] args) {
        int[] lista = {2, 3, -3, 44, 23, 7, 1, 0, -4};

        showList(lista);
        sort(lista);
        showList(lista);

    }
}
