package tests.service;

import com.qit.server.dto.QitResponse;
import com.qit.server.model.user.Gender;
import com.qit.server.model.user.User;
import com.qit.server.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tests.AbstractTest;

import java.util.Date;

public class UserServiceTest extends AbstractTest {

	@Autowired
	private UserService userService;

	@Test
	public void createUser() {
		User user = newUser();
		QitResponse qitResponse = userService.save(user);
		Assert.assertTrue(qitResponse.isSuccessfully());
		qitResponse = userService.save(null);
		Assert.assertFalse(qitResponse.isSuccessfully());
	}

	@Test
	public void deleteUser() {
		User user = newUser();
		QitResponse qitResponse = userService.delete(user);
		Assert.assertTrue(qitResponse.isSuccessfully());
	}

	private User newUser() {
		User user = new User();
		user.setGender(Gender.FEMALE);
		user.setAdditionalInfo("fdsjf");
		user.setBirthday(new Date());
		user.setEmail("vasya@pupkin.com");
		user.setEnabled(false);
		user.setLogin("test");
		user.setPassword("test");
		user.setFirstName("Anton");
		user.setLastName("Rynkovoy");
		user.setPhoneNumber("+32432425324");

		return user;
	}
}
