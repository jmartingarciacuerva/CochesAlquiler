package AlquilerDeCoches;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MiniMain {
    public static void main(String[] args) {
        /*Vehiculo v = new Vehiculo("a","a","a","a");
        System.out.println(v);

         */

        ArrayList<AlquilerDeCoches.Vehiculo> vehiculos = new ArrayList<AlquilerDeCoches.Vehiculo>();

        //Creamos una moto
        Moto moto = new AlquilerDeCoches.Moto("1234-AAA","BMW","A-345",
                "A1",5.2,true,500);
        vehiculos.add(moto);
/*
        System.out.println(moto);
        System.out.println();

        //Añadimos las fechas de alquiler, para poder calcular la tarifa
        System.out.println("**** Probamos el calcular precio ****");
        moto.setFechaAlquiler(LocalDateTime.now());
        moto.setFechaDevolucion(LocalDateTime.now().plusHours(7)); //Devolucion +7horas
        System.out.println(moto); //Mostramos la moto completa con fechas
        System.out.println("Precio: "+moto.calcularPrecio()+ " euros");//Mostramos el precio
        System.out.println("Precio simulado: "+moto.simularPrecio(LocalDateTime.now(),LocalDateTime.now().plusHours(10))+ " euros");//Mostramos el precio
*/

        Moto moto2 = new AlquilerDeCoches.Moto("1234-BBB","Honda","CBR",
                "A1",5.2,false,500);
        vehiculos.add(moto2);

        mostrarVehiculos(vehiculos);

        altaVehiculo(vehiculos);

        mostrarVehiculos(vehiculos);
    }

    private static void mostrarVehiculos(ArrayList<AlquilerDeCoches.Vehiculo> vehiculos) {
        for (AlquilerDeCoches.Vehiculo vehiculo :vehiculos) {
            System.out.println(vehiculo+"\n");
        }
    }

    private static void altaVehiculo(ArrayList<Vehiculo> vehiculos) {
        String opcion ="0";
        System.out.println("******** Alta vehiculo *****");
        System.out.println("1-Coche");
        System.out.println("2-Camion");
        System.out.println("3-Moto");
        System.out.println("4-Salir");

        String menuRegExp="[1-4]";
        opcion= pedirDatoConRegex(menuRegExp, "Elige opcion (1-4)");

        switch (opcion){
            case "1" : altaCoche(vehiculos);break;
           // case "2" : altaCamion(vehiculos); break;
           // case "3" :altaMoto(vehiculos);break;

        }






    }

    private static void altaCoche(ArrayList<Vehiculo> vehiculos) {

        String[] datosComunes=altaDatosComunes();

        int numeroOcupantes = 3; // Pedir por pantalla
        int numeroSillas= 1; //Pedir pantalla
        double precioDia=20.5; //Pedir por pantalla

        Coche cocheNuevo = new Coche(datosComunes[0],datosComunes[1],datosComunes[2],
                "B",precioDia,numeroOcupantes,numeroSillas);

        vehiculos.add(cocheNuevo);


    }

    private static String[] altaDatosComunes() {

        /*
         * Matricula, Fabricante, Modelo, Carnet (no lo pedimos, lo sacamos de los datos)
         * */

        Scanner teclado = new Scanner(System.in);
        String matriculaRegExp = "\\d{4}[A-Z]{3}";

        String matriculaNueva =
                pedirDatoConRegex(matriculaRegExp, "Introduce matricula (Ej:1111AAA)");

        String fabricanteRegExp="[A-Z]+";
        String fabricanteNuevo =
                pedirDatoConRegex(fabricanteRegExp, "Introduce nombre del fabricante");

        String modeloRegExp = "\\w+";
        String modeloNuevo=
                pedirDatoConRegex(modeloRegExp, "Introduce el modelo ");


        String[] arrayResultados = {matriculaNueva,fabricanteNuevo, modeloNuevo};
        return arrayResultados;
    }

    private static String pedirDatoConRegex(String regExp, String mensaje) {
        Scanner teclado = new Scanner(System.in);

        String dato = null;
        do {
            System.out.println(mensaje);
            dato = teclado.nextLine();
        }while (!Pattern.matches(regExp, dato));

        return dato;
    }








}

