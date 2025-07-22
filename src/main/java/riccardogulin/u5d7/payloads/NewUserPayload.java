package riccardogulin.u5d7.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewUserPayload {
	// N.B. Non rappresenta uno user in quanto entity, ma rappresenta solamente il contenuto del payload necessario per creare un nuovo user
	private String name;
	private String surname;
	private String email;

	@Override
	public String toString() {
		return
				"name='" + name + '\'' +
						", surname='" + surname + '\'' +
						", email='" + email + '\''
				;
	}
}
