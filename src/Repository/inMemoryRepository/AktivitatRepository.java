package Repository.inMemoryRepository;

import Model.Comparators.AktivitatNameComparator;
import Model.Data.Aktivitat;

import java.util.ArrayList;
import java.util.List;

public class AktivitatRepository implements Repository.interfaces.AktivitatRepository
{


    private List<Aktivitat> aktivitatList = new ArrayList<>();

    public AktivitatRepository()
    {
        this.aktivitatList = new ArrayList<>();
        populate();
    }

    public void setAktivitatList(List<Aktivitat> aktivitatList)
    {
        this.aktivitatList = new ArrayList<>();
        populate();
    }

    private void populate()
    {

        Aktivitat aktivitat1 = new Aktivitat("Football",1000);

        Aktivitat aktivitat2 = new Aktivitat("Tennis",900);

        aktivitatList.add(aktivitat1);

        aktivitatList.add(aktivitat2);



    }

    @Override
    public void listAktivitat()
    {

        for(Aktivitat aktivitat:aktivitatList)
        {
            System.out.println(aktivitat);
        }

    }



    @Override
    public List<Aktivitat> getAktivitatList()
    {
        return aktivitatList;
    }


    @Override
    public List<Aktivitat> sortByName(boolean ascending)
    {
        if(ascending)
        {
            aktivitatList.sort(new AktivitatNameComparator());
        }

        else
        {
            aktivitatList.sort(new AktivitatNameComparator().reversed());

        }

        return aktivitatList;
    }

    @Override
    public boolean add(Aktivitat entity)
    {
        boolean found = false;

        for(Aktivitat aktivitat:aktivitatList)
        {
            if(aktivitat.getName().equals(entity.getName()))
            {
                found = true;

                break;

            }

            if(!found)
            {
                aktivitatList.add(entity);
                return true;
            }
        }



        return false;
    }

    @Override
    public Aktivitat remove(String s)
    {

        Aktivitat temp = this.find(s);

        if(temp!=null)
        {
            this.aktivitatList.remove(temp);
        }

        return temp;
    }

    @Override
    public void update(Aktivitat newAktivitat, String s)
    {
        for(int i=0;i<aktivitatList.size();i++)
        {
            if(this.aktivitatList.get(i).getName().equals(s))
            {
                this.aktivitatList.set(i,newAktivitat);
            }
        }


    }

    @Override
    public Aktivitat find(String s)
    {
        for(Aktivitat aktivitat:aktivitatList)
        {
            if(aktivitat.getName().equals(s))
            {
                return aktivitat;
            }
        }

        return null;
    }


}
