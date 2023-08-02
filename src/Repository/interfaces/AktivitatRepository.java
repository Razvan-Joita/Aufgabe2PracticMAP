package Repository.interfaces;

import Model.Data.Aktivitat;

import java.util.List;

public interface AktivitatRepository extends CrudRepository<String, Aktivitat>
{

    void listAktivitat();


    public List<Aktivitat> getAktivitatList();



    List<Aktivitat> sortByName(boolean ascending);

}
