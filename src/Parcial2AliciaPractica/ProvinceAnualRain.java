package Parcial2AliciaPractica;

public class ProvinceAnualRain {
    private final String name;
    private final int amount;

    public ProvinceAnualRain(String name, int amount){
        this.name = name;
        this.amount = amount;
    }

    public int getAmount() {return amount;}

    public String getName() {return name;}
}
