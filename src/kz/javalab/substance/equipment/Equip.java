package substance.equipment;

public abstract class Equip {
    private String brand;
    private double weight;
    private double price;
    private double size;
    private boolean ventilation;
    private static final String BRAND = " Brand: ";
    private static final String WEIGHT = "; Weight: ";
    private static final String PRICE = "; Price: ";
    private static final String SIZE = "; Size: ";
    private static final String VENTILATION = "; Ventilation: ";
    private static final String SIGN = "; ";

    public Equip(String brand, double weight, double price, double size, boolean ventilation) {
        this.brand = brand;
        this.weight = weight;
        this.price = price;
        this.size = size;
        this.ventilation = ventilation;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getBrand() {
        return brand;
    }

    public double getSize() {
        return size;
    }

    public boolean isVentilation() {
        return ventilation;
    }

    @Override
    public String toString() {
        return BRAND + brand + WEIGHT + weight + PRICE + price + SIZE + size + VENTILATION + ventilation + SIGN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equip)) return false;
        Equip equip = (Equip) o;
        if (Double.compare(equip.getWeight(), getWeight()) != 0) return false;
        if (Double.compare(equip.getPrice(), getPrice()) != 0) return false;
        if (Double.compare(equip.getSize(), getSize()) != 0) return false;
        if (isVentilation() != equip.isVentilation()) return false;
        return getBrand().equals(equip.getBrand());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getBrand().hashCode();
        temp = Double.doubleToLongBits(getWeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getSize());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isVentilation() ? 1 : 0);
        return result;
    }
}
