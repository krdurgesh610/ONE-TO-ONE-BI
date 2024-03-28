package org.jsp.one2onebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByUserId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the User Id to fetch Aadhar Card Details");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query q = manager.createQuery("select c from AadharCard c where c.user.id=?1");
		q.setParameter(1, id);
		try {
			AadharCard card = (AadharCard) q.getSingleResult();
			System.out.println(card);
		} catch (NoResultException e) {
			System.err.println("Invalid User Id Entered...!!!");
		}
	}
}
