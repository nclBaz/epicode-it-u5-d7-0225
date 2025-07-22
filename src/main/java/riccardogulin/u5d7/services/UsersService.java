package riccardogulin.u5d7.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import riccardogulin.u5d7.entities.User;
import riccardogulin.u5d7.exceptions.NotFoundException;
import riccardogulin.u5d7.payloads.NewUserPayload;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UsersService {
	private List<User> usersDB = new ArrayList<>();

	public List<User> findAll() {
		return this.usersDB;
	}

	public User saveUser(NewUserPayload payload) {
		User newUser = new User(payload.getName(), payload.getSurname(), payload.getEmail(), "https://picsum.photos/200/300");
		this.usersDB.add(newUser);
		log.info("L'utente con email " + payload.getEmail() + " è stato salvato correttamente!");
		return newUser;
	}

	public User findById(int userId) {
		User found = null;
		for (User user : this.usersDB) {
			if (user.getId() == userId) found = user;
		}

		if (found == null) throw new NotFoundException(userId);
		return found;
	}

	public User findByIdAndUpdate(int userId, NewUserPayload payload) {
		User found = null;
		for (User user : this.usersDB) {
			if (user.getId() == userId) {
				found = user;
				found.setName(payload.getName());
				found.setSurname(payload.getSurname());
				found.setEmail(payload.getEmail());
			}
		}

		if (found == null) throw new NotFoundException(userId);
		return found;
	}

	public void findByIdAndDelete(int userId) {
		User found = null;
		for (User user : this.usersDB) {
			if (user.getId() == userId) found = user;
		}

		if (found == null) throw new NotFoundException(userId);
		this.usersDB.remove(found);
	}
}
