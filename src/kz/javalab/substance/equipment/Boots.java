package substance.equipment;


public class Boots extends Equip {
    private String type;

    public Boots(String type, String brand, double weight, double price, double size, boolean ventilation) {
        super(brand, weight, price, size, ventilation);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Мотоботы: " +
                " Тип: " + type + "; " + super.toString();
    }
}
