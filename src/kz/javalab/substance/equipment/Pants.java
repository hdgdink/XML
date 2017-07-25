package substance.equipment;

public class Pants extends Equip {
    private static final String PANTS = "\n- Pants: ";
    private static final String MATERIAL = "Material: ";
    private static final String BUILD_IN_PROTECTION = "; Build-in protection: ";
    private static final String SIGN = "; ";
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
        return PANTS + MATERIAL + material + BUILD_IN_PROTECTION + buildInProtection + SIGN + super.toString();
    }
}
