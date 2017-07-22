package substance.equipment;

public class Jacket extends Equip {
    private String material;
    private boolean buildInProtection;

    public Jacket(String material, boolean buildInProtection, String brand, double weight, double price,
                  double size, boolean ventilation) {
        super(brand, weight, price, size, ventilation);
        this.material = material;
        this.buildInProtection = buildInProtection;
    }

    @Override
    public String toString() {
        return "Куртка: " + "Материал: " + material
                + "; Наличие встроеной защиты: "
                + buildInProtection +
                "; " + super.toString();
    }
}
