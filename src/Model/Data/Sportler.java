package Model.Data;

import Model.Data.Aktivitat;

import java.util.ArrayList;

public class Sportler
{

    private String Name;

    private ArrayList<Aktivitat> aktivitatArrayList = new ArrayList<>();

    public Sportler(String name, ArrayList<Aktivitat> aktivitatArrayList) {
        Name = name;
        this.aktivitatArrayList = aktivitatArrayList;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Aktivitat> getAktivitatArrayList() {
        return aktivitatArrayList;
    }


    public void setAktivitatArrayList(ArrayList<Aktivitat> aktivitatArrayList) {
        this.aktivitatArrayList = aktivitatArrayList;
    }

    @Override
    public String toString() {
        return "Sportler{" +
                "Name='" + Name + '\'' +
                ", aktivitatArrayList=" + aktivitatArrayList +
                '}';
    }
}
