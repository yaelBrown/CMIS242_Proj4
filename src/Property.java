public class Property implements StateChangeable {
    private String address = "";
    private String addressOut = "";
    private int numOfBedrooms = 0;
    private int squareFootage = 0;
    private int price = 0;
    private Status statusOfProperty;

    public String getAddresss() {
        return this.addressOut;
    }

    public void setAddress(String address) {
        this.address = address;
        this.addressOut = address;
    }

    public int getNumOfBedrooms() {
        return numOfBedrooms;
    }

    public void setNumOfBedrooms(int numOfBedrooms) {
        this.numOfBedrooms = numOfBedrooms;
    }

    public int getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(int squareFootage) {
        this.squareFootage = squareFootage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Status getStatusOfProperty() {
        return statusOfProperty;
    }

    public void setStatusOfProperty(Status statusOfProperty) {
        this.statusOfProperty = statusOfProperty;
    }

    public Property(String address, int numOfBedrooms, int squareFootage, int price) {
        this.address = address;
        this.addressOut = address;
        this.numOfBedrooms = numOfBedrooms;
        this.squareFootage = squareFootage;
        this.price = price;
        this.statusOfProperty = Status.FOR_SALE;
    }

    @Override
    public void changeState(Enum anEnum) {
        this.statusOfProperty = (Status) anEnum;
    }

    @Override
    public String toString() {
        return "Property{" +
                "address='" + address + '\'' +
                ", numOfBedrooms=" + numOfBedrooms +
                ", squareFootage=" + squareFootage +
                ", price=" + price +
                ", statusOfProperty=" + statusOfProperty +
                '}';
    }
}
