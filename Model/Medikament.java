package Model;

/**
 * Represents a product (Medikament) with an ID, name, price, and krankenheit.
 * The class provides getters and setters for the product's attributes.
 */

public class Medikament implements HasID {
    private int id;
    private String name;
    private int price;
    private String krankenheit;

    /**
     * Constructor for the Medikament class
     * @param id , the id of the Medikament
     * @param name,the name of the Medikament
     * @param price, the price of the Medikament
     * @param Krankenheit, the Krankenheit of the Medikament
     */
    public Medikament(Integer id, String name, int price, String Krankenheit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.krankenheit = Krankenheit;
    }

    /**
     * Represents a product (Medikament) with an ID, name, price, and Krankenheit.
     * The class provides getters and setters for the product's attributes.
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets the name of the product.
     *
     * @return The product's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the krankenheit associated with the product.
     *
     * @return The product's krankenheit .
     */
    public String getKrankenheit() {
        return krankenheit;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The new name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the krankenheit  of the product.
     *
    // * @param krankenheit  The new season for the product.
     */
    public void setKrankenheit (String jahreszeit) {
        this.krankenheit = krankenheit;
    }

    /**
     * Sets the price of the product.
     *
     * @param price The new price for the product.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     *
     * @return a representation of a product ,as a String concatenation
     */
    @Override
    public String toString() {
        return  "id=" +id+
                "name=" + name  +
                ", price=" + price +
                ", krankenheit=" + krankenheit ;

    }
}


