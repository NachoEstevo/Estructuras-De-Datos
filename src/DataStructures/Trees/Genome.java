package DataStructures.Trees;

public class Genome implements Comparable<Genome> {
    String organism_Code;
    String type;
    String description;
    int size;

    public Genome(String code, String type, String description, int size){ //How do we compare them? By size or code?
        this.organism_Code = code;
        this.type = type;
        this.description = description;
        this.size = size;
    }

    public String getOrganism_Code() {return organism_Code;}

    public String getType() {return type;}

    public String getDescription() {return description;}

    public int getSize() {return size;}

    @Override
    public int compareTo(Genome gen) { //Redefine compareTo
        return Integer.compare(0, this.getOrganism_Code().compareTo(getOrganism_Code()));
    }
}
