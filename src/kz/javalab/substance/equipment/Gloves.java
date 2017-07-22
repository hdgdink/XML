package substance.equipment;

public class Gloves extends Equip {
    private String type;
    private String material;

    public Gloves(String type, String material, String brand, double weight, double price, double size,
                  boolean mVentilation) {
        super(brand, weight, price, size, mVentilation);
        this.material = material;
        this.type = type;
    }


    @Override
    public String toString() {
        return "Перчатки: " + "Тип: "
                + type + "; Материал: "
                + material + "; "
                + super.toString();
    }


}
