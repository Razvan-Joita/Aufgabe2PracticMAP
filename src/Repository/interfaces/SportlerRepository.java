package Repository.interfaces;

import Model.Data.Aktivitat;
import Model.Data.Sportler;

import java.util.List;

public interface SportlerRepository extends CrudRepository<String, Sportler>
{


    List<Sportler> sortByname(boolean asecending);



    void listSportlers();


    List<Aktivitat> filterByAktivitat(String name);


}
