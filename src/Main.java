import com.google.gson.Gson;
import model.Moneda;
import service.ConsultaAPI;
import service.ConversorMoneda;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner entrada = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();

        while (conversor.continuarBucle()) {
            conversor.mostrarMenu(); // Mostrar menú por consola

            // Selección del menú de conversión
            System.out.println("Seleccione una de las opciones: ");
            int opcion = entrada.nextInt();
            conversor.seleccion(opcion);

            if (opcion < 7 && opcion > 0) {
                try {
                    String moneda_base = conversor.getMoneda_base();
                    String moneda_objetivo = conversor.getMoneda_objetivo();

                    // Consulta a la API
                    var url = new ConsultaAPI();
                    var json = url.obtenerDatos("https://v6.exchangerate-api.com/v6/e5dddf247dfd68278391952d/pair/" + moneda_base + "/" + moneda_objetivo);

                    Gson gson = new Gson();
                    var conversion = gson.fromJson(json, Moneda.class);

                    // Valor a convertir
                    System.out.println("Ingresa el valor que deseas convertir: ");
                    var valor_inicial = entrada.nextDouble();
                    var objetivo = conversion.conversion_rate();
                    double moneda_convertida = conversor.conversion(valor_inicial, objetivo);

                /* NOTA:
                - moneda_base = abreviación de la moneda base
                - moneda_objetivo = abreviación de la moneda objetivo
                - valor_inicial = cantidad a convertir
                - moneda_convertida = cantidad convertida, resultado final
                */

                    System.out.println("El valor de " + valor_inicial + " [" + moneda_base + "] "
                            + "corresponde al valor final de ===> " + moneda_convertida + " [" + moneda_objetivo + "]\n\n");
                }catch (Exception e){
                    System.out.println("Ha ocurrido un error");
                }
            }

        }
    }
}
