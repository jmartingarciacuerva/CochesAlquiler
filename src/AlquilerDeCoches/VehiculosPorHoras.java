package AlquilerDeCoches;

public abstract class VehiculosPorHoras extends Vehiculo{
    private double precioHora;

    public VehiculosPorHoras(String matricula, String fabricante, String modelo, String carnetNecesario,double precioHora) {
        super(matricula, fabricante, modelo, carnetNecesario);
        this.precioHora = precioHora;
    }

    public VehiculosPorHoras(String codVehiculo){
        super(codVehiculo);
    }

    public double getPrecioHora() {
        return precioHora;
    }

    @Override
    public String toString() {
        return super.toString() + " | Precio/hora " + precioHora+"€";
    }
}
