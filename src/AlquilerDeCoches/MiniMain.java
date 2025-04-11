package AlquilerDeCoches;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MiniMain {
    public static void main(String[] args) {

        //Lista general para todos los vehiculos
        ArrayList<Vehiculo> vehiculos = new ArrayList<AlquilerDeCoches.Vehiculo>();
        //Lista propia para cada tipo de vehiculo
        ArrayList<Coche> coches = new ArrayList<Coche>();
        ArrayList<Camion> camiones = new ArrayList<Camion>();
        ArrayList<Moto> motos = new ArrayList<Moto>();

        //pruebasClaseMoto();

        crearVehiculosIniciales(vehiculos, motos, coches, camiones);
        mostrarVehiculos(vehiculos);
        mostrarCoches(coches);
        mostrarCochesSinAlquilar(coches);
   //     altaVehiculo(vehiculos, motos, coches, camiones);
        mostrarVehiculos(vehiculos);
        alquilarVehiculo(vehiculos);
        mostrarCoches(coches);

    }

    private static void alquilarVehiculo(ArrayList<Vehiculo> vehiculos) {
        String opcion ="0";
        System.out.println("******** Alquiler vehiculo *****");
        System.out.println("1-Coche");
        System.out.println("2-Camion");
        System.out.println("3-Moto");
        System.out.println("4-Salir");

        String menuRegExp="[1-4]";
        opcion= pedirDatoConRegex(menuRegExp, "Elige opcion (1-4)");

        //Solicitamos el codigo del vehiculo a alquilar
        String codVehiculoRegExp = "\\d{5}";
        String matricula = pedirDatoConRegex(codVehiculoRegExp, "Introduce el codigo del vehiculo a alquilar");
        //Generamos el objeto auxiliar, que nos ayuda en la búsqueda. Puede ser un coche, Camion o Moto
        Vehiculo vehiculoAux = null;
        switch (opcion){
            case "1" : vehiculoAux= new Coche(matricula);break;
            // case "2" : alquilerCamion(vehiculos, camiones); break;
            // case "3" :alquilerMoto(vehiculos, motos);break;
        }
        //Buscamos en "vehiculos" y lo alquilamos

        //Version de búsqueda más óptima
        Vehiculo vehiculoEncontrado = vehiculos.get(vehiculos.indexOf(vehiculoAux));
        if(vehiculoEncontrado!= null){  //Si el vehiculoEncontrado =  null, es porque no está en la lista
            //Comprobamos que el vehiculo solicitado, está sin alquilar
            if(!vehiculoEncontrado.estaAlquilado()){
                //Si no está alquilado, se alquila.
                //Habría que preguntar la FechaHora de alquiler, pero ahora mismo lo hacemos con now()
                vehiculoEncontrado.alquilar(LocalDateTime.now());
                System.out.println("Vehiculo alquilado correctamente");
            }else{
                System.out.println("Sorry, el vehiculo esta alquilado ahora mismo");
            }
        }else{
            System.out.println("El vehiculo indicado NO EXISTE");
        }

        /* //Version clásica de la busqueda
        if(vehiculos.contains(vehiculoAux)){
            int posicion = vehiculos.indexOf(vehiculoAux);
            Vehiculo vehiculoEncontrado = vehiculos.get(posicion);
            //Comprobamos que el vehiculo solicitado, está sin alquilar
            if(!vehiculoEncontrado.estaAlquilado()){
                //Si no está alquilado, se alquila.
                //Habría que preguntar la FechaHora de alquiler, pero ahora mismo lo hacemos con now()
                vehiculoEncontrado.alquilar(LocalDateTime.now());
                System.out.println("Vehiculo alquilado correctamente");
            }else{
                System.out.println("Sorry, el vehiculo esta alquilado ahora mismo");
            }
        }else{
            System.out.println("El vehiculo indicado NO EXISTE");
        }

    }

    private static void pruebasClaseMoto() {
        Moto moto = new AlquilerDeCoches.Moto("1234-AAA","BMW","A-345",
                "A1",5.2,true,500);
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

    }

    private static void crearVehiculosIniciales(ArrayList<Vehiculo> vehiculos,ArrayList<Moto> motos, ArrayList<Coche> coches, ArrayList<Camion> camiones) {
        //Creamos varios ejemplos de vehiculos.
        //Los añadimos a la lista general "vehiculos" y  a la lista especifica, según su tipo "motos", "camiones", "coches"
        Moto moto = new Moto("1234-AAA","BMW","A-345",
                "A1",5.2,true,500);
        vehiculos.add(moto);
        motos.add(moto);

        Moto moto2 = new Moto("1234-BBB","Honda","CBR",
                "A1",5.2,false,500);
        vehiculos.add(moto2);
        motos.add(moto2);

        Coche coche = new Coche("4444-AAA","BMW","300",
                "A1",30,5,3);
        Coche coche2 = new Coche("5555-AAA","AUDI","A300",
                "A1",35,5,3);
        coche.alquilar(LocalDateTime.now()); //Alquilamos uno de los coches
        vehiculos.add(coche);
        coches.add(coche);
        vehiculos.add(coche2);
        coches.add(coche2);

        Camion camion = new Camion("8888-AAA","PEGASO","RS300",
                "C1",30,5000);
        Camion camion2 = new Camion("9999-AAA","FORD","A300",
                "C",35,10000);
        vehiculos.add(camion);
        camiones.add(camion);
        vehiculos.add(camion2);
        camiones.add(camion2);
    }

    private static void mostrarVehiculos(ArrayList<Vehiculo> vehiculos) {
        System.out.println("***** Listado TOTAL de Vehiculos *****");
        for (Vehiculo vehiculo :vehiculos) {
            System.out.println(vehiculo+"\n");
        }
    }

    private static void mostrarCoches(ArrayList<Coche> coches) {
        System.out.println("***** Listado solo de coches *****");
        for (Coche coche:coches) {
            System.out.println(coche+"\n");
        }
    }

    private static void mostrarCochesSinAlquilar(ArrayList<Coche> coches) {
        System.out.println("***** Listado solo de coches SIN ALQUILAR *****");
        for (Coche coche:coches) {
            if(!coche.estaAlquilado()) {
                System.out.println(coche + "\n");
            }
        }
    }



    private static void altaVehiculo(ArrayList<Vehiculo> vehiculos, ArrayList<Moto> motos, ArrayList<Coche> coches, ArrayList<Camion> camiones) {
        String opcion ="0";
        System.out.println("******** Alta vehiculo *****");
        System.out.println("1-Coche");
        System.out.println("2-Camion");
        System.out.println("3-Moto");
        System.out.println("4-Salir");

        String menuRegExp="[1-4]";
        opcion= pedirDatoConRegex(menuRegExp, "Elige opcion (1-4)");

        switch (opcion){
            case "1" : altaCoche(vehiculos, coches);break;
           // case "2" : altaCamion(vehiculos, camiones); break;
           // case "3" :altaMoto(vehiculos, motos);break;

        }






    }

    private static void altaCoche(ArrayList<Vehiculo> vehiculos, ArrayList<Coche> coches) {

        String[] datosComunes=altaDatosComunes();

        int numeroOcupantes = 3; // Pedir por pantalla
        int numeroSillas= 1; //Pedir pantalla
        double precioDia=20.5; //Pedir por pantalla

        Coche cocheNuevo = new Coche(datosComunes[0],datosComunes[1],datosComunes[2],
                "B",precioDia,numeroOcupantes,numeroSillas);

        vehiculos.add(cocheNuevo);
        coches.add(cocheNuevo);


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

