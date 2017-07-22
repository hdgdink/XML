package substance.equipment;

public class Helmet extends Equip {
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
        return "Шлем: " +
                "Тип: " + type + "; Цвет щитка: "
                + colorOfVisor + "; "
                + super.toString();
    }
}
