package one.digitalinnovation.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class PessoaTeste {
    @Test //--> Anotação é primordial para testar
    void deveCalcularIdadeCorretamente(){
        // Criar um cenário
        Pessoa jessica = new Pessoa("Jéssica", LocalDateTime.of(2000, 1, 1, 15, 0, 0));
        // Executa as validações
        Assertions.assertEquals(23, jessica.getIdade());
    }

    @Test
    void deveTestarSeEhMaiorDeIdade(){
        Pessoa jessica = new Pessoa("Jéssica", LocalDateTime.of(2000, 1, 1, 15, 0, 0));
        Assertions.assertTrue(jessica.ehMaiorDeIdade());

        Pessoa joao = new Pessoa("João", LocalDateTime.now());
        Assertions.assertFalse(joao.ehMaiorDeIdade());
    }
}
