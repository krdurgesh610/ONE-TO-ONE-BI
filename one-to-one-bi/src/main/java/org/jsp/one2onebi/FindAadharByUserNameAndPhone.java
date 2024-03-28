package org.jsp.one2onebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByUserNameAndPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the User Name to fetch Aadhar Card Details");
		String name = sc.next();
		System.out.println("Enter the User Phone ");
		long phone = sc.nextLong();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query q = manager.createQuery("select c from AadharCard c where c.user.name=?1 and c.user.phone=?2");
		q.setParameter(1, name);
		q.setParameter(2, phone);
		try {
			AadharCard card = (AadharCard) q.getSingleResult();
			System.out.println(card);
		} catch (NoResultException e) {
			System.err.println("Invalid User Name And Phone Entered...!!!");
		}
	}
}
