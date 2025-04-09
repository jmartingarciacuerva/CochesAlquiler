package AlquilerDeCoches;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class Coche extends VehiculosPorDias{
    private int numeroDePersonas;
    private int cantidadSillas;
    private static double precioPorSillas = 10;

    public Coche(String matricula, String fabricante, String modelo, String carnetNecesario, double precioPorDia, int numeroDePersonas, int cantidadSillas) {
        super(matricula, fabricante, modelo, carnetNecesario, precioPorDia);
        this.numeroDePersonas = numeroDePersonas;
        this.cantidadSillas = cantidadSillas;
    }

    @Override
    public double calcularPrecio() {
        return simularPrecio(super.getFecha_hora_alquiler(),super.getFecha_hora_devolucion());
    }

    @Override
    public double simularPrecio(LocalDateTime fecha_hora_alquiler, LocalDateTime fecha_hora_devolucion) {
        long dias = fecha_hora_alquiler.until(fecha_hora_devolucion, DAYS);
        if (cantidadSillas!= 0){
            return (super.getPrecioPorDia()*dias)+(precioPorSillas*dias);
        }else {
            return super.getPrecioPorDia()*dias;
        }
    }

    @Override
    public String toString() {
        return "COCHE :" + super.toString()+ " |\nCapacidad: " + numeroDePersonas + " | cantidad de sillas=" + cantidadSillas;
    }
}
