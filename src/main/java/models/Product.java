package models;

public class Product {
    private int id;
    private String product_name;
    private String category;
    private String manufacturer;
    private String type;
    private String colour;
    private String expiry_date;
    private String date_added;
    private String supplier;
    private Boolean available;
    private String date_sold;
    private double price;
    private String serial_number;
    private String transaction_id;


    public Product(String serial_number, String product_name, String category, String manufacturer, String type, String colour, String expiry_date, String supplier, String date_added, double price) {
        this.product_name = product_name;
        this.category = category;
        this.manufacturer = manufacturer;
        this.type = type;
        this.colour = colour;
        this.expiry_date = expiry_date;
        this.date_added = date_added;
        this.supplier = supplier;
        this.available = true;
        this.date_sold = "n/a";
        this.transaction_id = "n/a";
        this.price = price;
        this.serial_number = serial_number;
    }


    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Boolean getAvailability() {
        return available;
    }

    public void setAvailability(Boolean available) {
        this.available = available;
    }

    public String getDate_sold() {
        return date_sold;
    }

    public void setDate_sold(String date_sold) {
        this.date_sold = date_sold;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
