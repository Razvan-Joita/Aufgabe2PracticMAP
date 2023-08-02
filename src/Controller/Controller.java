package Controller;

import Model.Data.Aktivitat;
import Model.Data.Sportler;
import Repository.interfaces.AktivitatRepository;
import Repository.interfaces.SportlerRepository;

import java.util.List;

public class Controller
{

    AktivitatRepository aktivitatRepository;

    SportlerRepository sportlerRepository;

    public Controller(AktivitatRepository aktivitatRepository, SportlerRepository sportlerRepository)
    {
        this.aktivitatRepository = aktivitatRepository;
        this.sportlerRepository = sportlerRepository;
    }

    public AktivitatRepository getAktivitatRepository() {
        return aktivitatRepository;
    }

    public void setAktivitatRepository(AktivitatRepository aktivitatRepository) {
        this.aktivitatRepository = aktivitatRepository;
    }

    public SportlerRepository getSportlerRepository() {
        return sportlerRepository;
    }

    public void setSportlerRepository(SportlerRepository sportlerRepository) {
        this.sportlerRepository = sportlerRepository;
    }

    public Controller()
    {

    }




    //singleton Instance

    private static Controller single_instance = null;


    public static Controller getInstance()
    {

        if(single_instance==null)
        {
            single_instance = new Controller();

        }

        return single_instance;

    }

    public boolean addAktivitat( Aktivitat aktivitat)
    {
        return this.aktivitatRepository.add(aktivitat);

    }

    public Aktivitat removeAktivitat(String s)
    {

       return this.aktivitatRepository.remove(s);

    }

    public void updateAktivitat(Aktivitat newAktivitat,String s)
    {
        this.aktivitatRepository.update(newAktivitat,s);

    }

    public Aktivitat findAktivitat(String s)
    {
        return this.aktivitatRepository.find(s);
    }

    public List<Aktivitat> sortByName(boolean ascending)
    {
        return this.aktivitatRepository.sortByName(ascending);

    }

    public boolean addSportler(Sportler sportler)
    {
        return this.sportlerRepository.add(sportler);
    }


    public Sportler removeSportler(String s)
    {
        return this.sportlerRepository.remove(s);
    }

    public void updateSportler(Sportler newSportler,String s)
    {
        this.sportlerRepository.update(newSportler,s);
    }

    public Sportler findSportler(String s)
    {
        return this.sportlerRepository.find(s);
    }


   public List<Sportler> sortbyname(boolean ascending)
   {
       return this.sportlerRepository.sortByname(ascending);
   }



    public void listAktivitat()
    {
        this.aktivitatRepository.listAktivitat();
    }

    public void listSportlers()
    {
        this.sportlerRepository.listSportlers();
    }

    public List<Aktivitat> filterbyAktivitat(String s)
    {

        return sportlerRepository.filterByAktivitat(s);

    }



}

