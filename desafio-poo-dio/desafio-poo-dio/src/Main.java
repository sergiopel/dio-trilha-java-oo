import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição Curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JS");
        curso2.setDescricao("Descrição Curso JS");
        curso2.setCargaHoraria(4);

        // Tudo o que eu tenho em Conteudo eu tenho em Curso, mas
        // nem tudo o que eu tenho em Curso eu tenho em Conteudo.
        // Estou aplicando o polimorfismo:
        //Conteudo conteudo = new Curso();
        //Conteudo conteudo = new Mentoria();

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição mentoria de Java");
        mentoria.setData(LocalDate.now());

/*
        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);
*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Banco Pan Java Developer");
        bootcamp.setDescricao("Bootcamp Java pelo Banco Pan e Dio");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        System.out.println(bootcamp.getConteudos());
        System.out.println("----------------");
        System.out.println(bootcamp);

        Dev devSergio = new Dev();
        devSergio.setNome("Sergio");
        devSergio.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos Sergio: " + devSergio.getConteudosInscritos());
        System.out.println("*** Progrediu");
        devSergio.progredir();
        devSergio.progredir();
        System.out.println("Conteúdos inscritos Sergio: " + devSergio.getConteudosInscritos());
        System.out.println("Conteúdos concluídos Sergio: " + devSergio.getConteudosConcluidos());
        System.out.println("XP: " + devSergio.calcularTotalXp());
        System.out.println("----------------------");

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos João: " + devJoao.getConteudosInscritos());
        System.out.println("*** Progrediu");
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("Conteúdos inscritos João: " + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos concluídos João: " + devJoao.getConteudosConcluidos());
        System.out.println("XP: " + devJoao.calcularTotalXp());

    }
}
