package Model.Comparators;

import Model.Data.Aktivitat;

import java.util.Comparator;

public class AktivitatNameComparator implements Comparator<Aktivitat>
{

    @Override
    public int compare(Aktivitat aktivitat1, Aktivitat aktivitat2)
    {
        return aktivitat2.getName().compareTo(aktivitat1.getName());
    }
}
