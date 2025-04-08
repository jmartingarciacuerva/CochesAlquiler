package vehiculosJaime;

import java.time.LocalDateTime;

public abstract class Vehiculo {
    //Atributos

    private String codigoVehiculo;
    private static int contadorVehiculos = 0;
    private String matricula;
    private String fabricante;
    private String modelo;
    private LocalDateTime fechaAlquiler;
    private LocalDateTime fechaDevolucion;
    private String carnetNecesario;

    //Constructores

    public Vehiculo(String matricula, String fabricante, String modelo, String carnetNecesario) {
        this.matricula = matricula;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.carnetNecesario = carnetNecesario;
        this.fechaAlquiler=null;
        this.fechaDevolucion=null;
        contadorVehiculos++;
        //Creamos un String de 5 posiciones, completando con ceros por delante
        this.codigoVehiculo= String.format("%05d",contadorVehiculos);

    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    @Override
    public String toString() {
        return
                "codigoVehiculo='" + codigoVehiculo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
               ", fechaAlquiler=" + fechaAlquiler +
                ", fechaDevolucion=" + fechaDevolucion +
                ", carnetNecesario='" + carnetNecesario + '\'' ;
    }


    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    public boolean estaAlquilado(){
        return this.fechaAlquiler!=null;
    }

    public abstract double calcularPrecio();
    public abstract double simularPrecio(LocalDateTime fechaAlquiler, LocalDateTime fechaDevolucion);
}
