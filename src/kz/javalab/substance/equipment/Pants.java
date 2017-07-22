package substance.equipment;

public class Pants extends Equip {
    private String material;
    private boolean buildInProtection;

    public Pants(String material, boolean buildInProtection, String brand, double weight, double price,
                 double size, boolean ventilation) {
        super(brand, weight, price, size, ventilation);
        this.material = material;
        this.buildInProtection = buildInProtection;
    }


    @Override
    public String toString() {
        return "Штаны: " + "Материал: "
                + material
                + "; Наличие встроеной защиты: "
                + buildInProtection +
                "; " + super.toString();
    }
}
