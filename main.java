import Model.Patient;

import Model.Medikament;
import Repository.FileRepository;
import Repository.InMemoryRepository;
import Repository.Repository;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main console application class that provides a command-line interface for interacting with the system.
 */

public class Main {

    private final Controller controller;


    public Main(Controller controller) {
        this.controller = controller;
    }

    /**
     * Starts the console application, displaying a menu and handling user input.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.print("""
                    Select an option:
                    
                    1.Get all Patients
                    2.Get all medikamente
                    3.Delete Patient
                    4.Delete medikament
                    5.Add Patient
                    6.Add medikament
                    7.Update patient
                    8.Update medikament
                    9.Get patient
                    10. Get medikament
                 
                    11.Filter by krankenheit
                   
                   
                    0. Exit
                    """);

            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    continueLoop = false;
                    break;
                case "1":
                    controller.viewPatienten();
                    break;
                case "2":
                    controller.viewMedikamente();
                    break;
                case "3":
                    controller.deletePatient(scanner);
                    break;
                case "4":
                    controller.deleteMedikament(scanner);
                    break;
                case "5":
                    controller.createPatient(scanner);
                    break;
                case "6":
                    controller.createMedikament(scanner);
                    break;
                case "7":
                    controller.updatePatient(scanner);
                    break;
                case "8":
                    controller.updateMedikament(scanner);
                    break;
                case "9":
                    controller.getPatient(scanner);
                    break;
                case "10":
                    controller.getMedikament(scanner);
                    break;
                case "11":
                    controller.filterKundedurchDiagnose(scanner);
                    break;

                default:
            }
        }
    }
    public static void main(String[] args) {

        Repository<Patient> patientRepositoryRepo = createInFilePatientenRepository();
        Repository<Medikament> medikamentRepositoryRepo =createInFileMedikamentRepository();

        Controller controller = new Controller(patientRepositoryRepo, medikamentRepositoryRepo);

        Main consoleApp = new Main(controller);
        consoleApp.start();

    }

    /**
     * Creates an in-memory repository for customers and populates it with some initial data.
     *
     * @return The in-memory repository for customers.
     */
    private static Repository<Patient> createInMemoryPatientRepository() {
        Repository<Patient> kundenRepo = new InMemoryRepository<>();
        Medikament produkt1 = new Medikament(1,"paracetamol", 200, "durere");
        Medikament produkt2 = new Medikament(2,"algocalmin", 300, "febra");
        Medikament produkt3=new Medikament(3,"nospa",400,"menstruatie");



        ArrayList<Medikament> productList = new ArrayList<>();
        ArrayList<Medikament> productList1 = new ArrayList<>();
        ArrayList<Medikament> productList2= new ArrayList<>();

        //Adaugam la lista
        productList.add(produkt1);
        productList.add(produkt2);
        productList1.add(produkt3);

        kundenRepo.create(new Patient(1,"Maria",12, "menstruatrie",productList));
        kundenRepo.create(new Patient(2,"Denisa",23, "durere",productList1));
        kundenRepo.create(new Patient(3,"Luciana", 44, "febra",productList2));

        return kundenRepo;
    }

    /**
     * Creates an in-memory repository for products and populates it with some initial data.
     *
     * @return The in-memory repository for products.
     */
    private static Repository<Medikament> createInMemoryProduktRepository() {
        Repository<Medikament> medikamentRepository = new InMemoryRepository<>();

        medikamentRepository.create(new Medikament(1,"algocalmin",200,"febra"));
        medikamentRepository.create(new Medikament(2,"nospa",300,"menstruatie"));
        medikamentRepository.create(new Medikament(3,"paracetamol",400,"vara"));

        return medikamentRepository;
    }
    /**
     * Creates an in-file repository for customers and populates it with some initial data.
     *
     * @return The in-file repository for customers.
     */

    private static Repository<Patient> createInFilePatientenRepository() {
        Repository<Patient> kundenRepo = new FileRepository<>("kunden.db");
        Medikament produkt1 = new (1,"algo", 200, "durere");
        Medikament produkt2 = new Produkt(2,"Clapari", 300, "Iarna");
        Medikament produkt3=new Produkt(3,"Bicicleta",400,"vara");



        ArrayList<Medikament> productList = new ArrayList<>();
        ArrayList<Medikament> productList1 = new ArrayList<>();
        ArrayList<Medikament> productList2= new ArrayList<>();


        productList.add(produkt1);
        productList.add(produkt2);
        productList1.add(produkt3);

        kundenRepo.create(new Patient(1,"Maria","Sebes",productList));
        kundenRepo.create(new Patient(2,"Denisa","Alba Iulia",productList1));
        kundenRepo.create(new Patient(3,"Luciana","Bucuresti",productList2));
        return kundenRepo;
    }
    /**
     * Creates an in-file repository for products and populates it with some initial data.
     *
     * @return The in-file repository for products.
     */
    private static Repository<Medikament> createInFileProduktRepository() {
        Repository<Medikament> produktRepo = new FileRepository<>("produkt.db");
        produktRepo.create(new Produkt(1,"Schiuri",200,"iarna"));
        produktRepo.create(new Produkt(2,"Clapari",300,"iarna"));
        produktRepo.create(new Produkt(3,"Bicicleta",400,"vara"));
        return produktRepo;
    }



    //daca avem o entitate , si am facut constructor fara lista  de produse

    private static Repository<Kunde1> createInMemoryKundenRepository1() {
        Repository<Kunde1> kundenRepo = new InMemoryRepository<>();


        kundenRepo.create(new Kunde1(1,"Maria","Sebes"));
        kundenRepo.create(new Kunde1(2,"Denisa","Alba Iulia"));
        kundenRepo.create(new Kunde1(3,"Luciana","Bucuresti"));

        return kundenRepo;
    }
}