package vehiculosJaime;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Moto extends VehiculoHoras{


    private boolean sideCar;
    private int cilindrada;

    protected Moto(String matricula, String fabricante, String modelo, String carnetNecesario, double precioHora, boolean sideCar, int cilindrada) {
        super(matricula, fabricante, modelo, carnetNecesario, precioHora);
        this.sideCar = sideCar;
        this.cilindrada =cilindrada;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSideCar="+ this.sideCar + " Cilindrada="+this.cilindrada ;
    }



    @Override
    public double calcularPrecio() {/*
        int distanciaEnHoras =(int) super.getFechaAlquiler().
                until(super.getFechaDevolucion(), ChronoUnit.HOURS);

        return distanciaEnHoras*super.getPrecioHora();
        */
        return simularPrecio(super.getFechaAlquiler(), super.getFechaDevolucion());
    }
    @Override
    public double simularPrecio(LocalDateTime inicio, LocalDateTime fin){
        int distanciaEnHoras =(int) inicio.
                until(fin, ChronoUnit.HOURS);

        return distanciaEnHoras*super.getPrecioHora();
    }


}
