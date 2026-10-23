package test;

import test.suites.TesteMerge;
import test.suites.TesteQuick;

public class Main {

    public static void main(String[] args) {

        //vetor com as classes de testes que serão rodadas
        Class<?>[]  suitesDeTeste = {
            TesteMerge.class,
            TesteQuick.class
        };

        boolean todasAsSuitesPassaram = true;

        //ciclo que roda cada classe de teste
        for(Class<?> suite : suitesDeTeste) {
            boolean resultadoTestes = TestRunner.executar(suite);

            if(!resultadoTestes) {
                todasAsSuitesPassaram = false;
            }
        }

        //mensagem geral sobre a execução dos testes
        System.out.println("\n====================================");
        if (todasAsSuitesPassaram) {
            System.out.println("SUCESSO: Todos os testes do sistema passaram!");
            System.exit(0);
        } else {
            System.err.println("ERRO: Houve falhas na suíte de testes.");
            System.exit(1);
        }
    }
}
