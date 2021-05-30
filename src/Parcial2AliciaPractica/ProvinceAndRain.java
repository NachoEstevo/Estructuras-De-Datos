package Parcial2AliciaPractica;

public class ProvinceAndRain {
    private final int index;
    private final int january, febraury, march, april, may, june, july, august, september, october, november, december;

    public ProvinceAndRain(int index, int january, int febraury, int march, int april, int may, int june, int july, int august, int september, int october, int november, int december){
        this.index = index;
        this.january = january;
        this.febraury = febraury;
        this.march = march;
        this.april = april;
        this.may = may;
        this.june = june;
        this.july = july;
        this.august = august;
        this.september = september;
        this.october= october;
        this.november = november;
        this.december = december;
    }
    public int getIndex() {return index;}

    public int getJanuary() {return january;}

    public int getFebraury() {return febraury;}

    public int getMarch() {return march;}

    public int getApril() {return april;}

    public int getMay() {return may;}

    public int getJune() {return june;}

    public int getJuly() {return july;}

    public int getAugust() {return august;}

    public int getSeptember() {return september;}

    public int getOctober() {return october;}

    public int getNovember() {return november;}

    public int getDecember() {return december;}

    @Override
    public String toString() { //Test para el read
        return "ProvinceAndRain{" +
                "index=" + index +
                ", january=" + january +
                ", febraury=" + febraury +
                ", march=" + march +
                ", april=" + april +
                ", may=" + may +
                ", june=" + june +
                ", july=" + july +
                ", august=" + august +
                ", september=" + september +
                ", october=" + october +
                ", november=" + november +
                ", december=" + december +
                '}';
    }
}

