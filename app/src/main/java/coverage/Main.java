package coverage;

import java.util.Scanner;
import java.io.InputStream;

public class Main {
 
    // I extracted logic to `run` to make testing with ByteArrayInputStream easier
    public static void run(InputStream input) {
        System.out.println("Informe uma opção:");
        Scanner scanner = new Scanner(input);
        
        if (scanner.hasNextInt()) {
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    CenarioUm cenarioUm = new CenarioUm();
                    cenarioUm.realizarAlgo();
                case 2:
                    CenarioDois cenarioDois = new CenarioDois();
                    cenarioDois.realizarAlgo();
                case 3:
                    CenarioTres cenarioTres = new CenarioTres();
                    cenarioTres.realizarAlgo();
                default:
                    System.out.println("Opcao invalida");
            }
        }
        scanner.close();
    }
}
