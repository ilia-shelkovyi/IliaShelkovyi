package hw6.entities;

public class UserTableRow {

    private String number;
    private String user;
    private String description;

    public UserTableRow(String number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

}