package substance.equipment;

public class Boots extends Equip {
    private static final String BOOTS = "- Boots: ";
    private static final String TYPE = "Type: ";
    private static final String SIGN = "; ";
    private String type;

    public Boots(String type, String brand, double weight, double price, double size, boolean ventilation) {
        super(brand, weight, price, size, ventilation);
        this.type = type;
    }

    @Override
    public String toString() {
        return BOOTS + TYPE + type + SIGN + super.toString();
    }
}
