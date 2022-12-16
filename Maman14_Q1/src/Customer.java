public class Customer {
    private String name, id, request;

    public Customer(String name, String id, String request) {
        this.name = name;
        this.id = id;
        this.request = request;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (this == obj) return true;
        if (!(obj instanceof Customer)) return false;
        Customer that = (Customer) obj;
        return (this.id.equals(that.id) && this.request.equals(that.request));
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nID: " + this.id + "\nrequest: " + this.request + "\n";
    }

}
