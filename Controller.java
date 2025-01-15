import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import Model.Medikament;
import Model.Patient;
import Repository.Repository;

/**
 * The Controller class is responsible for managing interactions between
 * the Patient and Medikament repositories.
 * It provides an abstraction layer for operations related to customers (Patient)
 * and products (Medikament).
 */

public class Controller {

    private final Repository<Patient> repoPatient;
    private final Repository<Medikament> repoMedikament;

    /**
     * Constructs a Controller instance with the specified repositories for Patient and Mediakemnet.
     *
     * @param inMemoryRepositoryPatient  The repository for managing Patient objects.
     * @param inMemoryRepositoryMediakemnt The repository for managing Medikament objects.
     */
    public Controller(Repository<Patient> inMemoryRepositoryPatient, Repository<Medikament> inMemoryRepositoryMediakemnt) {
        this.repoPatient = inMemoryRepositoryPatient;
        this.repoMedikament = inMemoryRepositoryMediakemnt;
    }

    /**
     * CRUD Operation : get,getall,create,update,delete
     */
    public void viewPatienten() {
        StringBuilder output = new StringBuilder("Alle patienten:\n");
        repoPatient.getAll().forEach(patient -> output.append(patient.toString()).append("\n"));
        System.out.println(output);
    }

    public void viewMedikamente() {
        StringBuilder output = new StringBuilder("Available Medikamente:\n");
        repoMedikament.getAll().forEach(medikament -> output.append(medikament.toString()).append("\n"));
        System.out.println(output);
    }

    public void deletePatient(Scanner scanner) {
        System.out.println("Enter the id of the patient you want to delete from the system:");
        Integer id = Integer.parseInt(scanner.nextLine());
        repoPatient.delete(id);
    }
    public void deleteMedikament(Scanner scanner) {
        System.out.println("Enter the id of the medikament you want to delete from the system:");
        Integer id = Integer.parseInt(scanner.nextLine());
        repoMedikament.delete(id);
    }
    public void createPatient(Scanner scanner) {
        System.out.println("Enter Patient id:");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Patient name:");
        String name = scanner.nextLine();
        System.out.println("Enter Patient alter:");
        Integer alter = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Patient diagnose:");
        String diagnose = scanner.nextLine();
        ArrayList<Medikament> MedikamenteList = new ArrayList<>();
        Patient patient= new Patient(id, name, alter, MedikamenteList);
        repoPatient.create(patient);
        System.out.println("Patient created: " + patient);
    }

    public void createMedikament(Scanner scanner) {
        System.out.println("Enter Medikament id:");
        Integer id =Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Medikament name:");
        String name = scanner.nextLine();
        System.out.println("Enter Medikament price:");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Medikament Krankheit:");
        String krankheit = scanner.nextLine();

        Medikament medikament = new Medikament(id,name, price, krankheit);
        repoMedikament.create(medikament);
        System.out.println("Medikament created: " + medikament);
    }

    public  void getPatient(Scanner scanner) {
        System.out.println("Enter the id of the Patient you want to get:");
        Integer id = Integer.parseInt(scanner.nextLine());
        Patient patient = repoPatient.get(id);
        if (patient != null) {
            System.out.println("patient found: " + patient);
        } else {
            System.out.println("patient not found with id: " + id);
        }
    }

    public void getMedikament(Scanner scanner) {
        System.out.println("Enter the id of the Medikament you want to get:");
        Integer id = Integer.parseInt(scanner.nextLine());
        Medikament medikament = repoMedikament.get(id);
        if (medikament != null) {
            System.out.println("medikament found: " + medikament);
        } else {
            System.out.println("medikament not found with id: " + id);
        }
    }

    public void updatePatient(Scanner scanner) {
        System.out.println("Enter the id of the Patient you want to update:");
        Integer id = Integer.parseInt(scanner.nextLine());
        Patient patient = repoPatient.get(id);
        if (patient != null) {

            System.out.println("Enter new name for Patient:");
            String newName = scanner.nextLine();
            System.out.println("Enter new alter for Patient:");
            Integer newAlter = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new diagnose for Patient:");
            String newDiagnose = scanner.nextLine();
            patient.setName(newDiagnose);
            patient.setAlter(newAlter);
            repoPatient.update(patient);
            System.out.println("patient updated: " + patient);
        } else {
            System.out.println("patient not found with id: " + id);
        }
    }


    public void updateMedikament(Scanner scanner) {
        System.out.println("Enter the id of the Medikament you want to update:");
        Integer id = Integer.parseInt(scanner.nextLine());
        Medikament medikament = repoMedikament.get(id);
        if (medikament != null) {
            System.out.println("Enter new name for medikament:");
            String newname = scanner.nextLine();
            System.out.println("Enter new price for medikament:");
            int newPrice = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new krankheit for medikament:");
            String newKrankenheit = scanner.nextLine();

            medikament.setName(newname);
            medikament.setPrice(newPrice);
            medikament.setKrankenheit(newKrankenheit);


            repoMedikament.update(medikament);
            System.out.println("medikament updated: " + medikament);
        } else {
            System.out.println("medikament not found with name: " + id);
        }
    }

    //c
    public void filterKundedurchDiagnose(Scanner scanner){
        System.out.println("Enter the name of the diagnose");
        String diagnose = scanner.nextLine();
        StringBuilder output = new StringBuilder("patients :\n");
        List<Patient> filterPatient =new ArrayList<>(repoPatient.getAll());
        filterPatient.stream().filter(patient -> patient.getDiagnose().equals(diagnose)).forEach(patient -> output.append(patient).append("\n"));
        System.out.println(output);
    }


//    //filtrare clienti
//
//    /**
//     * Filters and displays customers (Kunde) based on their location (Ort).
//     * The method prompts the user to enter the name of a city, then filters
//     * the customers from the repository whose location matches the input.
//     *
//     * <p>
//     * The filtered customers are displayed in the console.
//     * </p>
//     *
//     * @param scanner The {@link Scanner} object used to read the user's input.
//     *                The user is prompted to enter the name of the city to filter by.
//     *
//     * Example usage:
//     * <pre>
//     * Enter the name of the city
//     * Berlin
//     * Kunden:
//     * Kunde{name='John Doe', ort='Berlin'}
//     * Kunde{name='Anna Meyer', ort='Berlin'}
//     * </pre>
//     */
//    public void filterPatientsbymedikament(Scanner scanner){
//        System.out.println("Enter a krankenheit");
//        String krankenheit = scanner.nextLine();
//        StringBuilder output = new StringBuilder("patients :\n");
//        List<Kunde> filterKunden=new ArrayList<>(repoPatient.getAll());
//        for(Kunde kunde:filterKunden){
//            for(Produkt produkt :kunde.getOrederdProducts()){
//                if(produkt.getJahreszeit().equals(jahreszeit))
//                    output.append(kunde.getName()).append("\n");
//                break;
//            }
//        }
//        System.out.println(output);
//    }
//
//    /**
//     * Sorts the products ordered by a specific user based on their price.
//     * The user is prompted to enter the ID of the user and the sorting order
//     * (ascending or descending).
//     *
//     * @param scanner The {@link Scanner} object used to read user input.
//     *                The input includes the user ID and the sorting preference.
//     *
//     * <p>
//     * Example usage:
//     * <pre>
//     * Enter the id of the user
//     * 1
//     * Enter a if you want to sort them < or d if you want to sort them >
//     * a
//     * John Doe with the followings Products:
//     * Produkt{name='Laptop', price=999.99}
//     * Produkt{name='Mouse', price=49.99}
//     * </pre>
//     * </p>
//     */
//    public void sortByUser(Scanner scanner){
//        System.out.println("Enter the id of the user");
//        Integer id = Integer.parseInt(scanner.nextLine());
//        System.out.println("Enter a if you want to sort them < or d if you want to sort them >");
//        String letter = scanner.nextLine();
//        List<Produkt> products=new ArrayList<>(repoPatient.get(id).getOrederdProducts());
//        System.out.println(repoPatient.get(id).getName()+" with the followings Products ");
//        if(letter.charAt(0)=='a'){
//            products.sort(Comparator.comparing(Produkt::getPrice));
//            for(Produkt produkt : products)
//                System.out.println(produkt);
//        }
//        if (letter.charAt(0)=='d'){
//            products.sort(Comparator.comparing(Produkt::getPrice).reversed());
//            for (Produkt produkt : products)
//                System.out.println(produkt);
//        }
//    }
//
//    /**
//     * Adds a product to a specific customer's ordered products.
//     * The user is prompted to enter the customer's ID and the product's ID.
//     *
//     * @param scanner The {@link Scanner} object used to read user input.
//     *                The input includes the customer ID and the product ID.
//     *
//     * <p>
//     * Example usage:
//     * <pre>
//     * Enter the id of the customer
//     * 1
//     * Enter the id of the product you want to give the customer
//     * 101
//     * </pre>
//     * </p>
//     */
//    public void addProductsforKunde(Scanner scanner){
//        System.out.println("Enter the id of the customer");
//        Integer id = Integer.parseInt(scanner.nextLine());
//        System.out.println("Enter the id of the product you want to give the customer");
//        Integer productId = Integer.parseInt(scanner.nextLine());
//        Kunde kunde = repoPatient.get(id);
//        Produkt produkt = repoMedikament.get(productId);
//        kunde.getOrederdProducts().add(produkt);
//        repoPatient.update(kunde);
//    }
//}
