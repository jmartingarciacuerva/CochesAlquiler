package AlquilerDeCoches;

import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.HOURS;

public class Moto extends VehiculosPorHoras{
    private boolean sideCar;
    private int cilindrada;
    private double precioSideCar_hora = 2.25;

    //Constructor
    public Moto(String matricula, String fabricante, String modelo, String carnetNecesario, double precioHora,boolean sideCar,int cilindrada) {
        super(matricula, fabricante, modelo, carnetNecesario, precioHora);
        this.sideCar = sideCar;
        this.cilindrada = cilindrada;
    }

    public Moto (String codVehiculo){
        super(codVehiculo);
    }

    @Override
    public double calcularPrecio() {
        return simularPrecio(super.getFecha_hora_alquiler(),super.getFecha_hora_devolucion());
    }

    @Override
    public double simularPrecio(LocalDateTime fecha_hora_alquiler, LocalDateTime fecha_hora_devolucion) {
        long horas = fecha_hora_alquiler.
                until(fecha_hora_devolucion, HOURS);
        if (sideCar){
            return (super.getPrecioHora()*horas)+(precioSideCar_hora*horas);
        }else {
            return super.getPrecioHora() * horas;
        }
    }

    @Override
    public String toString() {
        if (sideCar){
            return "MOTO: "+super.toString() + " |\nCON sidecar" + " | Cilindrada=" + cilindrada;
        }else {
            return super.toString() + " |\nSIN sidecar" + " | Cilindrada=" + cilindrada;
        }
    }
}
