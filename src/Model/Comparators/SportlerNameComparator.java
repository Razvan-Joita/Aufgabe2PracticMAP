package Model.Comparators;

import Model.Data.Sportler;

import java.util.Comparator;

public class SportlerNameComparator implements Comparator<Sportler>
{
    @Override
    public int compare(Sportler sportler1, Sportler sportler2)
    {
        return sportler2.getName().compareTo(sportler1.getName());
    }
}
