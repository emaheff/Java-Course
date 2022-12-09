public class Customer {
    private String name, ID, request;

    public Customer(String name, String ID, String request) {
        this.name = name;
        this.ID = ID;
        this.request = request;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (this == obj) return true;
        if (!(obj instanceof Customer)) return false;
        Customer that = (Customer) obj;
        return (this.ID.equals(that.ID) && this.request.equals(that.request));
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nID: " + this.ID + "\nrequest: " + this.request + "\n";
    }

}
