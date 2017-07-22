package creator;

import substance.biker.Biker;
import substance.equipment.*;

public class EquipsCreator {

    final String SPORT = "Sport";
    final String STREET = "Street";
    final String ALPINE = "AlpineStars";
    final String ARAI = "Arai";
    final String DAINESE = "Dainese";
    final String LEATHER = "Leather";
    final String CEVLAR = "Cevlar";
    final String TRANSPARENT = "Transparent";
    final String NAME = "Johan" + "\n";

    public Biker creatEquip() {

        Equip boots = new Boots(SPORT, ALPINE, 3.5, 215.35, 40, true);
        Equip gloves = new Gloves(SPORT, LEATHER, ALPINE, 0.6, 80, 2, true);
        Equip helmet = new Helmet(STREET, TRANSPARENT, ARAI, 1.58, 326, 58, true);
        Equip jacket = new Jacket(CEVLAR, true, DAINESE, 1.23, 180.54, 48, false);
        Equip pants = new Pants(CEVLAR, true, DAINESE, 1.5, 190.15, 48, false);

        Biker biker = new Biker();
        biker.setName(NAME);
        biker.addEquips(boots);
        biker.addEquips(gloves);
        biker.addEquips(helmet);
        biker.addEquips(jacket);
        biker.addEquips(pants);

        return biker;
    }


}
