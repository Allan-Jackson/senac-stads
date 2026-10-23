package test.suites;

import test.Mergesort;

import java.util.Arrays;


public class TesteMerge {

    @Teste
    public static boolean testaMergeArraysUnitarios() {
        //dados necessários
        //arrays previamente ordenados
        int[] a = {2};
        int[] b = {-1};
        int[] merged = new int[a.length + b.length];

        //dado esperado
        int[] expected = {-1, 2};

        //unidade a ser testada
        Mergesort.merge(a, b, merged);

        return Arrays.equals(expected, merged);
    }

    @Teste
    public static boolean testaMergeArraysMaiores() {
        //dados necessários
        //arrays previamente ordenados
        int[] a = {2, 4, 8, 9, 11};
        int[] b = {-1, 1, 2, 3};
        int[] merged = new int[a.length + b.length];

        //dado esperado
        int[] expected = {-1, 1, 2, 2, 3, 4, 8, 9, 11};

        //unidade a ser testada
        Mergesort.merge(a, b, merged);

        return Arrays.equals(expected, merged);
    }

    @Teste
    public static boolean testaMergeComUmArrayVazio() {
        //dados necessários
        //arrays previamente ordenados
        int[] a = {};
        int[] b = {-1, 1, 2, 3};
        int[] merged = new int[a.length + b.length];

        //dado esperado
        int[] expected = {-1, 1, 2, 3};

        //unidade a ser testada
        Mergesort.merge(a, b, merged);

        return Arrays.equals(expected, merged);
    }

    @Teste
    public static boolean testaMergeComDoisArrayVazios() {
        //dados necessários
        //arrays previamente ordenados
        int[] a = {};
        int[] b = {};
        int[] merged = new int[a.length + b.length];

        //dado esperado
        int[] expected = {};

        //unidade a ser testada
        Mergesort.merge(a, b, merged);

        return Arrays.equals(expected, merged);
    }

    @Teste
    public static boolean testaMergesortArrayVazio() {
        //dados necessários
        int[] arr = {};

        //dado esperado
        int[] expected = {};

        //unidade a ser testada
        Mergesort.mergesort(arr);

        return Arrays.equals(expected, arr);
    }

    @Teste
    public static boolean testaMergesortArrayUnitario() {
        //dados necessários
        int[] arr = {2};

        //dado esperado
        int[] expected = {2};

        //unidade a ser testada
        Mergesort.mergesort(arr);

        return Arrays.equals(expected, arr);
    }

    @Teste
    public static boolean testaMergesortArrayOrdenadoCrescente() {
        //dados necessários
        int[] arr = {-3, -1, 0, 2, 3, 8, 12, 100, 101};

        //dado esperado
        int[] expected = {-3, -1, 0, 2, 3, 8, 12, 100, 101};

        //unidade a ser testada
        Mergesort.mergesort(arr);

        return Arrays.equals(expected, arr);
    }

    @Teste
    public static boolean testaMergesortArrayDesordenado() {
        //dados necessários
        int[] arr = {101, -2, 0, -1, 34, 3, 8, 11, 2, 2, 1094, -3, -39};

        //dado esperado
        int[] expected = {-39, -3, -2, -1, 0, 2, 2, 3, 8, 11, 34, 101, 1094};

        //unidade a ser testada
        Mergesort.mergesort(arr);

        return Arrays.equals(expected, arr);
    }

    @Teste
    public static boolean testaMergesortArrayDesordenadoDecrescente() {
        //dados necessários
        int[] arr = {203, 183, 40, 20, 12, 8, 2, 0, -2, -234};

        //dado esperado
        int[] expected = {-234, -2, 0, 2, 8, 12, 20, 40, 183, 203};

        //unidade a ser testada
        Mergesort.mergesort(arr);

        return Arrays.equals(expected, arr);
    }
}
