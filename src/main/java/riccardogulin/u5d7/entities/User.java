package riccardogulin.u5d7.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Getter
@Setter
@ToString
public class User {
	@Setter(AccessLevel.NONE)
	private int id;
	private String name;
	private String surname;
	private String email;
	private String imgURL;

	public User(String name, String surname, String email, String imgURL) {
		Random rndm = new Random();
		this.id = rndm.nextInt(1, 10000);
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.imgURL = imgURL;
	}
}
