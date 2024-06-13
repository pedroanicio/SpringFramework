package Facade;
//prover uma interface que reduza a complexidade nas integrações
//com  subsistemas
public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.migrarCliente("Pedro", "3100000");
    }
}
