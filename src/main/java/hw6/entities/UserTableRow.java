package hw6.entities;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof UserTableRow)) return false;
        UserTableRow userTableRow = (UserTableRow) o;
        return Objects.equals(number, userTableRow.number) && Objects.equals(user, userTableRow.user) && Objects.equals(description, userTableRow.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, user, description);
    }

}