package mariana.studio.com.listadapter;

public class User {
    private String firstName;
    private String lastName;
    private String food;

    public User(String firstName, String lastName, String food) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.food = food;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFood() {
        return food;
    }
}
