package substance.equipment;

public class Helmet extends Equip {
    private static final String HELMET = "\n- Helmet: ";
    private static final String TYPE = "Type: ";
    private static final String COLOR_OF_VISOR = "; Color of visor: ";
    private static final String SIGN = "; ";
    private String type;
    private String colorOfVisor;

    public Helmet(String type, String colorOfVisor, String brand, double weight, double price,
                  double size, boolean ventilation) {
        super(brand, weight, price, size, ventilation);
        this.type = type;
        this.colorOfVisor = colorOfVisor;
    }

    @Override
    public String toString() {
        return HELMET + TYPE + type + COLOR_OF_VISOR + colorOfVisor + SIGN + super.toString();
    }
}
