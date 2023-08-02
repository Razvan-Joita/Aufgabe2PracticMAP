package View;

import Controller.Controller;
import Model.Data.Aktivitat;
import Model.Data.Sportler;
import Repository.interfaces.AktivitatRepository;
import Repository.interfaces.SportlerRepository;


import java.util.ArrayList;
import java.util.Scanner;

public class View
{

    private static View single_instance = null;

    private final Controller controller;


    public View()
    {

        this.controller = Controller.getInstance();
    }

    public static View getInstance()
    {

        if(single_instance==null)
        {
            single_instance = new View();
        }
        return single_instance;
    }

    private void setUpInMemory()
    {

        AktivitatRepository aktivitatRepository= new Repository.inMemoryRepository.AktivitatRepository();
        SportlerRepository sportlerRepository = new Repository.inMemoryRepository.SportlerRepository();


        controller.setAktivitatRepository(aktivitatRepository);

        controller.setSportlerRepository(sportlerRepository);



    }

    public void mainMenu()
    {

        setUpInMemory();

        System.out.println("Sportler Anwendung MAP");


        while(true)
        {


            System.out.println("1-Add Aktivitat");
            System.out.println("2-Remove Aktivitat");
            System.out.println("3-Update Aktivitat");
            System.out.println("4-Find Aktivitat");
            System.out.println("5-Sort Aktivitat by Name");


            System.out.println("6-Add Sportler");
            System.out.println("7- Remove Sportler");
            System.out.println("8-Update Sportler");
            System.out.println("9-Find Sportler");
            System.out.println("10-Sort Sportler by Name");

            System.out.println("11-List Aktivitat");
            System.out.println("12-List Sportler");


            Scanner myObj = new Scanner(System.in);
            int option = myObj.nextInt();

            if(option==1)
            {
                String Name = myObj.next();
                int NummerKalorien=myObj.nextInt();
                this.controller.addAktivitat(new Aktivitat(Name,NummerKalorien));

            }

            if(option==2)
            {
                String name = myObj.next();

                this.controller.removeAktivitat(name);
            }

            if(option==3)
            {

                String name = myObj.next();

                int NummerKalorien = myObj.nextInt();

                Aktivitat neuAktivitat = new Aktivitat(name,NummerKalorien);

                this.controller.updateAktivitat(neuAktivitat,name);

            }


            if(option==4)
            {

                String name = myObj.next();

                Aktivitat aktivitat = this.controller.findAktivitat(name);

                if(aktivitat!=null)
                {

                    System.out.println(aktivitat.getName()+","+aktivitat.getNummerKalorien());

                }

                else
                {
                    System.out.println("Aktivitat es gibt nicht in die Liste");
                }


            }


            if(option==5)
            {

                System.out.println(controller.sortByName(false));

            }


            if (option==6)
            {

                String Name=myObj.next();

                int number = myObj.nextInt();

                ArrayList<Aktivitat> aktivitats = new ArrayList<>();

                for(int i=0;i<number;i++)
                {

                    String name = myObj.next();
                    int NummerKalorien=myObj.nextInt();

                    aktivitats.add(new Aktivitat(name,NummerKalorien));

                }


                this.controller.addSportler(new Sportler(Name,aktivitats));


            }


            if(option==7)
            {

                String name = myObj.next();

                this.controller.removeSportler(name);



            }

            if(option==8)
            {

                String Name1 = myObj.next();

                int number = myObj.nextInt();

                ArrayList<Aktivitat> aktivitats = new ArrayList<>();



                for(int i=0;i<number;i++)
                {
                    String Name=myObj.next();

                    int NummerKalorien=myObj.nextInt();

                    aktivitats.add(new Aktivitat(Name,NummerKalorien));


                }


                this.controller.updateSportler(new Sportler(Name1,aktivitats),Name1);


            }

            if(option==9)
            {

                String s = myObj.next();

                System.out.println(this.controller.findSportler(s));

            }

            if(option==10)
            {

                String name = myObj.next();

                System.out.println(controller.filterbyAktivitat(name));

            }


            if(option==11)
            {
                controller.listAktivitat();
            }

            if(option==12)
            {
                controller.listSportlers();
            }


            if(option==0)
            {
                break;
            }



        }
    }

}
