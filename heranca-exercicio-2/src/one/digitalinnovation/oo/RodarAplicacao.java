package one.digitalinnovation.oo;

public class RodarAplicacao {
    public static void main(String[] args) {
        // só instanciei, aqui não houve upcast, nem downcast
        Funcionario funcionario = new Funcionario();

        // aqui nos 3 objetos abaixo, teremos upcast, ou seja, gerente, vendedor e faxineiro como funcionarios (classe mãe)
        // TRABALHAR COM UPCAST FACILITA MUITO O CONCEITO DO POLIMORFISMO
        Funcionario faxineiro = new Faxineiro();
        Funcionario vendedor = new Vendedor();
        Funcionario gerente = new Gerente();

        // abaixo é a demonstraçaõ de downcast, ou seja, classe mae para classe filha
        // DEVE SER EVITADO, VAI DAR ERRO
        Faxineiro faxineiro2 = (Faxineiro) new Funcionario();
    }
}
