package AlquilerDeCoches;

public abstract class VehiculosPorDias extends Vehiculo{

    private double precioPorDia;

    public VehiculosPorDias(String matricula, String fabricante, String modelo, String carnetNecesario, double precioPorDia) {
        super(matricula, fabricante, modelo, carnetNecesario);
        this.precioPorDia= precioPorDia;
    }

    public VehiculosPorDias(String codVehiculo){
        super(codVehiculo);
    }
    public double getPrecioPorDia() {
        return precioPorDia;
    }

    @Override
    public String toString() {
        return super.toString()+ " | precio/dia " + precioPorDia+"€";
    }
}
