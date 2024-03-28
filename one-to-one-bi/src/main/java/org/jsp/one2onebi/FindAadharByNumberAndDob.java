package org.jsp.one2onebi;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAadharByNumberAndDob {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Aadhar Number to fetch Aadhar Details");
		long number = sc.nextLong();
		System.out.println("Enter the Dob(yyyy-mm-dd)");
		LocalDate dob = LocalDate.parse(sc.next());
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query q = manager.createQuery("select c from AadharCard c where c.number=?1 and c.dob=?2");
		q.setParameter(1, number);
		q.setParameter(2, dob);
		try {
			AadharCard card = (AadharCard) q.getSingleResult();
			System.out.println(card);
		} catch (NoResultException e) {
			System.err.println("Invalid Aadhar Number or Dob Entered...!!!");

		}
	}
}
