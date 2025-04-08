package AlquilerDeCoches;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class AlquilerMain {
    public static void main(String[] args) {
        Moto moto = new Moto("a","a","a","a",19,true,250);
        System.out.println(moto);
        moto.setFecha_hora_alquiler(LocalDateTime.now());
        moto.setFecha_hora_devolucion(LocalDateTime.now().plusHours(7));
        System.out.println(moto.calcularPrecio()+"€");
        Moto moto1 = new Moto("a","a","a","a",19,false,250);
        System.out.println(moto1);
        moto1.setFecha_hora_alquiler(LocalDateTime.now());
        moto1.setFecha_hora_devolucion(LocalDateTime.now().plusHours(7));
        System.out.println(moto1.calcularPrecio()+"€");

        Coche coche = new Coche("a","a","a","a",50,5,2);
        System.out.println(coche);
        coche.setFecha_hora_alquiler(LocalDateTime.now());
        coche.setFecha_hora_devolucion(LocalDateTime.now().plusDays(7));
        System.out.println(coche.calcularPrecio()+"€");

        Camion camion = new Camion("a","a","a","a",50,5000);
        System.out.println(camion);
        camion.setFecha_hora_alquiler(LocalDateTime.now());
        camion.setFecha_hora_devolucion(LocalDateTime.now().plusDays(7));
        System.out.println(camion.calcularPrecio()+"€");
    }
}
