package test.suites;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Interface que cria a anotação @Teste para ser usada nos métodos de teste unitário. */

//garante que a anotação estará disponível em tempo de execução
@Retention(RetentionPolicy.RUNTIME)
//restringe essa anotação para ser usada apenas em métodos
@Target(ElementType.METHOD)
public @interface Teste{}
