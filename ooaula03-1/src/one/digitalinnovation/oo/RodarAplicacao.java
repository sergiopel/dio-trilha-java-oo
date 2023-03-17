package one.digitalinnovation.oo;

public class RodarAplicacao {
    public static void main(String[] args) {
        double totalValorTanque;
        Carro carro1 = new Carro("Bege", "Corolla", 60);

        System.out.println("Cor.................: " + carro1.getCor());
        System.out.println("Modelo..............: " + carro1.getModelo());
        System.out.println("Capacidade do tanque: " + carro1.capacidadeDoTanque);
        totalValorTanque = carro1.totalValorTanque(5.21);
        System.out.println("Valor total do tanque do carro1: " + totalValorTanque);

        Carro carro2 = new Carro();
        carro2.setCor("Vermelho");
        carro2.setModelo("Up");
        carro2.setCapacidadeDoTanque(50);
        System.out.println("Cor.................: " + carro2.getCor());
        System.out.println("Modelo..............: " + carro2.getModelo());
        System.out.println("Capacidade do tanque: " + carro2.capacidadeDoTanque);
        System.out.println("Valor total do tanque do carro2: " + carro2.totalValorTanque(5.21));



    }
}
