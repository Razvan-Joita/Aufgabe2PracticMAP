package Repository.inMemoryRepository;

import Model.Comparators.SportlerNameComparator;
import Model.Data.Aktivitat;
import Model.Data.Sportler;

import java.util.ArrayList;
import java.util.List;

public class SportlerRepository implements Repository.interfaces.SportlerRepository
{


    List<Sportler> sportlerList = new ArrayList<>();

    public SportlerRepository()
    {
        this.sportlerList = new ArrayList<>();
        populate();
    }


    private void populate()
    {


        Aktivitat aktivitat1 = new Aktivitat("Football",1000);

        Aktivitat aktivitat2 = new Aktivitat("Tennis",900);

        ArrayList<Aktivitat> aktivitatArrayList1 = new ArrayList<>();

        aktivitatArrayList1.add(aktivitat1);

        aktivitatArrayList1.add(aktivitat2);


        Sportler sportler1 = new Sportler("Messi",aktivitatArrayList1);

        sportlerList.add(sportler1);



        Aktivitat aktivitat3 = new Aktivitat("Best-Football",800);

        Aktivitat aktivitat4 = new Aktivitat("Swimming",1200);

        ArrayList<Aktivitat> aktivitatArrayList2 = new ArrayList<>();

        aktivitatArrayList2.add(aktivitat3);

        aktivitatArrayList2.add(aktivitat4);

        Sportler sportler2 = new Sportler("Ronaldo",aktivitatArrayList2);

        sportlerList.add(sportler2);




    }

    public List<Sportler> getSportlerList() {
        return sportlerList;
    }



    public void setSportlerList(List<Sportler> sportlerList) {
        this.sportlerList = sportlerList;
    }

    @Override
    public boolean add(Sportler entity)
    {

        boolean found = false;

        for(Sportler sportler:sportlerList)
        {

            if(sportler.getName().equals(entity.getName()))
            {
                found= true;
                break;
            }

            if(!found)
            {
                sportlerList.add(entity);
                return true;
            }

        }

        return false;
    }

    @Override
    public Sportler remove(String s)
    {

        Sportler temp = this.find(s);

        if(temp!=null)
        {
            this.sportlerList.remove(temp);
        }

        return temp;

    }

    @Override
    public void update(Sportler newSportler, String s)
    {
        for (int i = 0; i < sportlerList.size(); i++)
        {
            if (this.sportlerList.get(i).getName().equals(s))
            {
                this.sportlerList.set(i, newSportler);
            }
        }


    }

    @Override
    public Sportler find(String s)
    {
        for(Sportler sportler:sportlerList)
        {

            if(sportler.getName().equals(s))
            {
                return sportler;
            }

        }

        return null;
    }

    @Override
    public List<Sportler> sortByname(boolean asecending)
    {

        if(asecending)
        {
            sportlerList.sort(new SportlerNameComparator());
        }

        else
        {
            sportlerList.sort(new SportlerNameComparator().reversed());

        }

        return sportlerList;

    }


    @Override
    public void listSportlers()
    {

        for(Sportler sportler:sportlerList)
        {
            System.out.println(sportler);
        }

    }


    @Override
    public List<Aktivitat> filterByAktivitat(String name)
    {

        List<Aktivitat> resultList = new ArrayList<>();

        for(Sportler sportler:sportlerList)
        {
            for(Aktivitat aktivitat:sportler.getAktivitatArrayList())
            {

                resultList.add(aktivitat);
                break;

            }
        }



        return resultList;
    }
}


