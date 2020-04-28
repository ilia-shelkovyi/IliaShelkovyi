package hw7.enities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import utils.PropertyReader;

@Getter
@AllArgsConstructor
public class User {

	public static User ROMAN = new User(PropertyReader.get("username"), PropertyReader.get("password"), PropertyReader.get("fullUsername"));

    private String name;
    private String password;
    private String fullName;

}