package Model.Data;

public class Aktivitat
{

    private String Name;

    private int NummerKalorien;

    public Aktivitat(String name, int nummerKalorien) {
        Name = name;
        NummerKalorien = nummerKalorien;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getNummerKalorien() {
        return NummerKalorien;
    }

    public void setNummerKalorien(int nummerKalorien) {
        NummerKalorien = nummerKalorien;
    }

    @Override
    public String toString() {
        return "Aktivitat{" +
                "Name='" + Name + '\'' +
                ", NummerKalorien=" + NummerKalorien +
                '}';
    }
}
