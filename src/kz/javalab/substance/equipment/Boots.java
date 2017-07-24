package substance.equipment;


public class Boots extends Equip {
    private String type;
    private final String BOOTS = "- Мотоботы: ";
    private final String TYPE = "Тип: ";
    private final String SIGN = "; ";

    public Boots(String type, String brand, double weight, double price, double size, boolean ventilation) {
        super(brand, weight, price, size, ventilation);
        this.type = type;
    }

    @Override
    public String toString() {
        return BOOTS + TYPE + type + SIGN + super.toString();
    }
}
