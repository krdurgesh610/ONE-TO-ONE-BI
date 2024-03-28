package org.jsp.one2onebi;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveUserAndAadhar {
	public static void main(String[] args) {
		User user = new User();
		user.setName("Komal");
		user.setPhone(8051231984L);

		AadharCard card = new AadharCard();
		card.setNumber(371443940999L);
		card.setDob(LocalDate.parse("2000-12-25"));
		card.setCity("Patna");

		user.setCard(card);
		card.setUser(user);

		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(user);
		transaction.begin();
		transaction.commit();

	}
}
