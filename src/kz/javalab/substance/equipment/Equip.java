package substance.equipment;

public abstract class Equip {
    private String brand;
    private double weight;
    private double price;
    private double size;
    private boolean ventilation;

    public Equip(String mBrand, double mWeight, double mPrice, double mSize, boolean mVentilation) {
        this.brand = mBrand;
        this.weight = mWeight;
        this.price = mPrice;
        this.size = mSize;
        this.ventilation = mVentilation;
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
        return " " +
                "Производитель: " + brand +
                "; Вес: " + weight +
                "; Цена: " + price +
                "; Размер: " + size +
                "; Наличие вентиляции: " + ventilation;

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
