package test.suites;

import test.Quicksort;

import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.util.Arrays;


public class TesteQuick {

    @Teste
    public boolean testaEscolhaDoPivoComDoisElementos() {
        //dados necessários
        int[] arr = {2, 0};


        //dado esperado
        int[] expected = {0, 2};
        int expectRes = 0;

        //unidade a ser testada
        try{
            //força temporariamente ignorar o modificador 'private' para realizar o teste
            Method metodoPrivado = Quicksort.class.getDeclaredMethod("choosePivot", int[].class, int.class, int.class);
            metodoPrivado.setAccessible(true);

            int result = (int) metodoPrivado.invoke(null, arr, 0, arr.length-1);

            return Arrays.equals(expected, arr) && result == expectRes;
        }catch (Exception e) {
            return false;
        }

    }

    @Teste
    public boolean testaEscolhaDoPivoComTresElementos() {
        //dados necessários
        //arrays previamente ordenados
        int[] arr = {2, 8, -1};


        //dado esperado
        int[] expected = {-1, 2, 8};
        int expectRes = 1;

        //unidade a ser testada
        try{
            //força temporariamente ignorar o modificador 'private' para realizar o teste
            Method metodoPrivado = Quicksort.class.getDeclaredMethod("choosePivot", int[].class, int.class, int.class);
            metodoPrivado.setAccessible(true);

            int result = (int) metodoPrivado.invoke(null, arr, 0, arr.length-1);

            return Arrays.equals(expected, arr) && result == expectRes;
        }catch (Exception e) {
            return false;
        }
    }

    @Teste
    public boolean testaEscolhaDoPivoComVariosElementos() {
        //dados necessários
        int[] arr = {-1, 2, 3, 8, 28, 0, 7};

        //dado esperado
        int[] expected = {-1, 2, 3, 7, 28, 0, 8};
        int expectRes = 3;

        //unidade a ser testada
        try{
            //força temporariamente ignorar o modificador 'private' para realizar o teste
            Method metodoPrivado = Quicksort.class.getDeclaredMethod("choosePivot", int[].class, int.class, int.class);
            metodoPrivado.setAccessible(true);

            int result = (int) metodoPrivado.invoke(null, arr, 0, arr.length-1);

            return Arrays.equals(expected, arr) && result == expectRes;
        }catch (Exception e) {
            return false;
        }
    }

//    @Teste
//    public static boolean testaQuickComDoisArrayVazios() {
//        //dados necessários
//        //arrays previamente ordenados
//        int[] a = {};
//        int[] b = {};
//        int[] merged = new int[a.length + b.length];
//
//        //dado esperado
//        int[] expected = {};
//
//        //unidade a ser testada
//        Quicksort.merge(a, b, merged);
//
//        return Arrays.equals(expected, merged);
//    }
//
//    @Teste
//    public static boolean testaQuicksortArrayVazio() {
//        //dados necessários
//        int[] arr = {};
//
//        //dado esperado
//        int[] expected = {};
//
//        //unidade a ser testada
//        Quicksort.quicksort(arr);
//
//        return Arrays.equals(expected, arr);
//    }
//
//    @Teste
//    public static boolean testaQuicksortArrayUnitario() {
//        //dados necessários
//        int[] arr = {2};
//
//        //dado esperado
//        int[] expected = {2};
//
//        //unidade a ser testada
//        Quicksort.quicksort(arr);
//
//        return Arrays.equals(expected, arr);
//    }
//
//    @Teste
//    public static boolean testaQuicksortArrayOrdenadoCrescente() {
//        //dados necessários
//        int[] arr = {-3, -1, 0, 2, 3, 8, 12, 100, 101};
//
//        //dado esperado
//        int[] expected = {-3, -1, 0, 2, 3, 8, 12, 100, 101};
//
//        //unidade a ser testada
//        Quicksort.quicksort(arr);
//
//        return Arrays.equals(expected, arr);
//    }
//
//    @Teste
//    public static boolean testaQuicksortArrayDesordenado() {
//        //dados necessários
//        int[] arr = {101, -2, 0, -1, 34, 3, 8, 11, 2, 2, 1094, -3, -39};
//
//        //dado esperado
//        int[] expected = {-39, -3, -2, -1, 0, 2, 2, 3, 8, 11, 34, 101, 1094};
//
//        //unidade a ser testada
//        Quicksort.quicksort(arr);
//
//        return Arrays.equals(expected, arr);
//    }
//
//    @Teste
//    public static boolean testaQuicksortArrayDesordenadoDecrescente() {
//        //dados necessários
//        int[] arr = {203, 183, 40, 20, 12, 8, 2, 0, -2, -234};
//
//        //dado esperado
//        int[] expected = {-234, -2, 0, 2, 8, 12, 20, 40, 183, 203};
//
//        //unidade a ser testada
//        Quicksort.quicksort(arr);
//
//        return Arrays.equals(expected, arr);
//    }
}
