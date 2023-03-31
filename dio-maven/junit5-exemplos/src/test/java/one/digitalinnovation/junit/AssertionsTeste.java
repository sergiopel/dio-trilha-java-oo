package one.digitalinnovation.junit;

import org.junit.jupiter.api.Assertions;
// se eu fizesse o import static do Assertions acima, eu não
//precisaria ficar digitando o Assertions nos testes abaixo
// ex:  import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class AssertionsTeste {
    @Test
    void validarLancamentos(){
        int[] primeiroLancamento = {10, 20, 30, 40, 50};
        //int[] segundoLancamento = {10, 5, 2, 3, 10};
        int[] segundoLancamento = {10, 20, 30, 40, 50};

        Assertions.assertArrayEquals(primeiroLancamento, segundoLancamento);
        //Assertions.assertNotEquals(primeiroLancamento, segundoLancamento);
    }


    @Test
    void validarSeObjetoEstaNulo() {
        Pessoa pessoa = null;
        Assertions.assertNull(pessoa);

        pessoa = new Pessoa("Sergio", LocalDateTime.now());
        Assertions.assertNotNull(pessoa);
    }

    @Test
    void validarNumerosDeTiposDiferentes() {
        double valor = 5.0;
        double outroValor = 5.0;

        Assertions.assertEquals(valor, outroValor);

    }


}
