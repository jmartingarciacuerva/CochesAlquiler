package AlquilerDeCoches;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class Camion extends VehiculosPorDias{
    private int capacidad;
    private int precioVehiculosEspeciales_hora = 20;

    public Camion(String matricula, String fabricante, String modelo, String carnetNecesario, double precioPorDia, int capacidad) {
        super(matricula, fabricante, modelo, carnetNecesario, precioPorDia);
        this.capacidad = capacidad;
    }

    @Override
    public double calcularPrecio() {
        return simularPrecio(super.getFecha_hora_alquiler(),super.getFecha_hora_devolucion());
    }

    @Override
    public double simularPrecio(LocalDateTime fecha_hora_alquiler, LocalDateTime fecha_hora_devolucion) {
        long dias = fecha_hora_alquiler.until(fecha_hora_devolucion, DAYS);
        if (capacidad>3500){
            return (super.getPrecioPorDia()*dias)+(precioVehiculosEspeciales_hora*dias);
        }else {
            return (super.getPrecioPorDia()*dias);
        }
    }

    @Override
    public String toString() {
        return "CAMION: " + super.toString()+ " |\ncapacidad=" + capacidad + " | precioVehiculosEspeciales_hora=" + precioVehiculosEspeciales_hora;
    }
}
