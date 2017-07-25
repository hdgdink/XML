package substance.equipment;

public class Gloves extends Equip {
    private static final String GLOVES = "\n- Gloves: ";
    private static final String TYPE = "Type: ";
    private static final String MATERIAL = "; Material: ";
    private static final String SIGN = "; ";
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
        return GLOVES + TYPE + type + MATERIAL + material + SIGN + super.toString();
    }


}
