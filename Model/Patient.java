package Model;
import java.util.List;


/**
 * Represents a Patient with an ID, name, alter, diagnose, and a list of ordered medikamente.
 */

public class Patient implements HasID {

    private Integer id;
    private String name;
    private Integer alter;
    private String diagnose;
    List<Medikament> orederdMedikamente;

    /**
     * Constructs a new {@code Patient} object with the specified ID, name, alter, diagnose,
     * and list of ordered medikamente.
     *
     * @param id              The unique identifier for the patient.
     * @param name            The name of the patient.
     * @param alter             The alter of the kunde.
     * @param diagnose          The diagnose of the patient.
     * @param orederdMedikamente The list of medikamente ordered by the patient.
     */
    public Kunde(Integer id, String name, String ort, List<Medikament> orederdMedikamente) {
        this.id = id;
        this.name = name;
        this.alter = alter;
        this.diagnose = diagnose;
        this.orederdMedikamente = orederdMedikamente;

    }

    /**
     * Gets the unique identifier of the customer.
     *
     * @return The kunde's ID.
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * Gets the name of the kunde.
     *
     * @return The kunde's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the kunded.
     *
     * @param name The new name of the kunde.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the alter of the customer.
     *
     * @return The customer's location.
     */
    public Integer getalter() {
        return alter;
    }

    /**
     * Sets the alter of the patient.
     *
     * @param alter The new location of the patient.
     */
    public void setAlter(Integer alter) {
        this.alter = alter;
    }

    /**
     * Gets the diagnose of the patient.
     *
     * @return The patient's diagnolse.
     */
    public String getDiagnose() {
        return diagnose;
    }

    /**
     * Sets the diagnose of the patient.
     *
     * @param diagnose The new name of the patient.
     */
    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    /**
     * Gets the list of medikamente ordered by the kunde.
     *
     * @return A list of {@link Medikament} objects ordered by the kunde.
     */
    public List<Medikament> getOrederdMedikamente() {
        return orederdMedikamente;
    }

    /**
     * Sets the list of medikamnte ordered by the patient.
     *
     * @param orederdMedikamente A new list of {@link Medikament} objects for the customer.
     */
    public void setOrederdMedikamente(List<Medikament> orederdMedikamente) {
        this.orederdMedikamente = orederdMedikamente;
    }

    /**
     * Returns a string representation of the customer, including the ID, name,
     * location, and ordered products.
     *
     * @return A string representation of the customer.
     */
    @Override
    public String toString() {
        return "Patient "+ id + " " + name + " " + alter + " " + diagnose + " " + orederdMedikamente;
    }
}
