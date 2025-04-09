package AlquilerDeCoches;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Vehiculo {
    //Atributos
    private String codigoVehiculo;
    private static int contadorVehiculo=0;
    private String matricula;
    private String fabricante;
    private String modelo;
    private LocalDateTime fecha_hora_alquiler;
    private LocalDateTime fecha_hora_devolucion;
    private String carnetNecesario;

    //Constructor
    public Vehiculo(String matricula,String fabricante,String modelo, String carnetNecesario){
        contadorVehiculo++;
        //Creamos un String de 5 posiciones, completando con ceros por delante
        this.codigoVehiculo = String.format("%05d",contadorVehiculo);
        this.matricula = matricula;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.fecha_hora_alquiler = null;
        this.fecha_hora_devolucion = null;
        this.carnetNecesario = carnetNecesario;
    }
    //ConstructorBuscador
    public Vehiculo(String codigoVehiculo){this.codigoVehiculo = codigoVehiculo;}

    // Getters y setters

    public static int getContadorVehiculo() {
        return contadorVehiculo;
    }

    public String getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public String getCarnetNecesario() {
        return carnetNecesario;
    }

    public LocalDateTime getFecha_hora_alquiler() {
        return fecha_hora_alquiler;
    }

    public LocalDateTime getFecha_hora_devolucion() {
        return fecha_hora_devolucion;
    }

    public void setFecha_hora_alquiler(LocalDateTime fecha_hora_alquiler) {
        this.fecha_hora_alquiler = fecha_hora_alquiler;
    }

    public void setFecha_hora_devolucion(LocalDateTime fecha_hora_devolucion) {
        this.fecha_hora_devolucion = fecha_hora_devolucion;
    }

    public boolean estaAlquilado (){
        return this.fecha_hora_alquiler!=null;
    }

    public void alquilar(LocalDateTime fecha_hora_alquiler){
        this.fecha_hora_alquiler = fecha_hora_alquiler;
    }
    public double devolver(LocalDateTime fecha_hora_devolucion){
        this.fecha_hora_devolucion = fecha_hora_devolucion;
        double precio = calcularPrecio();
        this.fecha_hora_alquiler = null;
        this.fecha_hora_devolucion = null;
        return precio;
    }
    public abstract double calcularPrecio();
    public abstract double simularPrecio(LocalDateTime fecha_hora_alquiler,LocalDateTime fecha_hora_devolucion);

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(codigoVehiculo, vehiculo.codigoVehiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigoVehiculo);
    }

    @Override
    public String toString() {
        return "CodVehiculo:"+ codigoVehiculo +
                " | Matricula=" + matricula +
                " | Fabricante=" + fabricante +
                " | Modelo=" + modelo +
                " |\nFecha_hora_alquiler=" + fecha_hora_alquiler +
                " | Fecha_hora_devolucion=" + fecha_hora_devolucion +
                " |\nCarnetNecesario=" + carnetNecesario;
    }
}
