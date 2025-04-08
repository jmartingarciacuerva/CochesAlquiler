package vehiculosJaime;

import java.time.LocalDateTime;

public abstract class VehiculoHoras extends Vehiculo{

    private double precioHora;

    protected VehiculoHoras(String matricula, String fabricante, String modelo, String carnetNecesario, double precioHora) {
        super( matricula,  fabricante,  modelo,  carnetNecesario);
        this.precioHora = precioHora;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPrecio Hora="+ precioHora;
    }

    @Override
    public abstract double calcularPrecio() ;

    @Override
    public abstract double simularPrecio(LocalDateTime fechaAlquiler, LocalDateTime fechaDevolucion) ;
}
