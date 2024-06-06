package dio.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

// uma forma de implementar a Injeção de dependencia
// foco em acabar com o Calculadora calculadora = new Calculadora()
@Component
public class MyApp implements CommandLineRunner {
    int escolha;
    double n1, n2;
    Scanner s = new Scanner(System.in);

    @Autowired
    private Calculadora calculadora;
    @Override
    public void run(String... args) throws Exception {
        do {
            System.out.println("1. Somar");
            System.out.println("2. Subtrair");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("0. Sair");

            escolha = s.nextInt();

            switch (escolha){
                case 1:
                    lerNumeros();
                    System.out.println("Resultado: " + calculadora.somar(n1,n2));
                    break;
                case 2:
                    lerNumeros();
                    System.out.println("Resultado: " + calculadora.subtrair(n1,n2));
                    break;
                case 3:
                    lerNumeros();
                    System.out.println("Resultado: " + calculadora.multiplicar(n1,n2));
                    break;
                case 4:
                    lerNumeros();
                    System.out.println("Resultado: " + calculadora.dividir(n1,n2));
                    break;
            }

        }while (escolha !=0);
    }

    public void lerNumeros(){
        System.out.print("Valor 1: ");
        n1 = s.nextDouble();
        System.out.print("Valor 2: ");
        n2 = s.nextDouble();
    }

}
