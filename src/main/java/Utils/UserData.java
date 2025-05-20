package Utils;

public class UserData {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String company;
    public String address;
    public String state;
    public String city;
    public String zip;
    public String mobile;

    public UserData(String firstName, String lastName, String email, String password,
                    String company, String address, String state, String city, String zip, String mobile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.company = company;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.mobile = mobile;
    }
}
