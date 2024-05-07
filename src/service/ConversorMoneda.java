package service;

import java.util.ArrayList;

public class ConversorMoneda {
    private String moneda_base;
    private String moneda_objetivo;

    // Control del bucle (main)
    private static boolean continuar = true;



    // Getters y Setters
    public String getMoneda_objetivo() {
        return moneda_objetivo;
    }

    public void setMoneda_objetivo(String moneda_objetivo) {
        this.moneda_objetivo = moneda_objetivo;
    }

    public String getMoneda_base() {
        return moneda_base;
    }

    public void setMoneda_base(String moneda_base) {
        this.moneda_base = moneda_base;
    }

    public double conversion(Double base, Double objetivo){
        return base * objetivo;
    }

    public static boolean continuarBucle() {
        return continuar;
    }

    public static boolean terminarBucle() {
        continuar = false;
        return continuar;
    }

    public void seleccion(int opcion){
        switch (opcion){
            case 1:
                // Dolar a Peso argentino
                setMoneda_base("USD");
                setMoneda_objetivo("ARS");
                break;

            case 2:
                // Peso argentino a Dólar
                setMoneda_base("ARS");
                setMoneda_objetivo("USD");
                break;

            case 3:
                // Dólar a Real brasileño
                setMoneda_base ("USD");
                setMoneda_objetivo("BRL");
                break;

            case 4:
                // Real brasileño a Dólar
                setMoneda_base("BRL");
                setMoneda_objetivo("USD");
                break;

            case 5:
                // Dólar a Peso colombiano
                this.moneda_base = "USD";
                this.moneda_objetivo = "COP";
                break;

            case 6:
                // Peso colombiano a Dólar
                this.moneda_base = "COP";
                this.moneda_objetivo = "USD";
                break;

            case 7:
                terminarBucle();
                break;

            default:
                System.out.println("Has ingresado una opción no válida.");
                terminarBucle();
                break;
        }
    }

    public static void mostrarMenu(){
        System.out.println("*************************************");
        System.out.println("=====================================");
        System.out.println("          Conversor de Monedas");
        System.out.println("=====================================");
        System.out.println("1) Dólar --> Peso argentino");
        System.out.println("2) Peso argentino --> Dólar");
        System.out.println("3) Dólar  --> Real brasileño");
        System.out.println("4) Real brasileño --> Dólar");
        System.out.println("5) Dólar --> Peso colombiano");
        System.out.println("6) Peso colombiano --> Dólar");
        System.out.println("7) Salir");
        System.out.println("*************************************");
    }
}
