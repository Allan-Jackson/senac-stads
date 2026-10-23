package test;

import test.suites.Teste;

import java.lang.reflect.Method;

/**
 * Essa classe é responsável por rodar todos os testes unitários de uma classe (uma suíte de testes).
 * Ela roda todos os métodos anotados por @Teste na classe de teste e permite a execução de todos os
 * teste, mesmo que haja falhas no caminho.
 */
public class TestRunner {

    //recebe a classe de teste
    public static boolean executar(Class<?> suiteDeTeste) {
        System.out.println("\n=== Executando testes de: " + suiteDeTeste.getSimpleName() + " ===");
        int passados = 0;
        int falhados = 0;
        int total = 0;

        try{
            //Cria uma instância da classe de teste
            Object instancia = suiteDeTeste.getDeclaredConstructor().newInstance();

            //percorre cada metodo da classe de teste
            for(Method metodo : instancia.getClass().getDeclaredMethods()) {
                //verifica se o método é um teste (anotado com @Teste)
                if(metodo.isAnnotationPresent(Teste.class)){
                    total++; //contador de testes

                    try {
                        //invoca o teste e guarda o resultado
                        boolean resultado = (boolean) metodo.invoke(instancia);

                        if (resultado) {
                            //printa msg dizendo que aquele teste especifico (nome do método) passou
                            System.out.printf("  [✓] %s: PASSOU\n", metodo.getName());
                            passados++;
                        } else {
                            //print msg dizendo que aquele teste falhou
                            System.err.printf("  [X] %s: FALHOU!\n", metodo.getName());
                            falhados++;
                        }
                    }catch (Exception e) {
                        // Captura alguma exceção (ex: NullPointer) que possa ocorrer em algum dos testes, permitindo que os outros continuem
                        System.err.printf("  [X] %s: LANÇOU EXCEÇÃO! (%s)\n", metodo.getName(), e.getCause());
                        falhados++;
                    }
                }
            }

        } catch (Exception e) {
            System.err.println("Erro ao instanciar a classe de teste: " + e.getMessage());
            return false;
        }

        System.out.printf("Resultado para %s: %d/%d passados.\n", suiteDeTeste.getSimpleName(), passados, total);
        return falhados == 0;
    }
}
