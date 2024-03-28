package org.jsp.one2onebi;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByAadharNumberAndDob {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Aadhar Number to fetch User Details");
		long number = sc.nextLong();
		System.out.println("Enter the Date of Birth (yyyy-mm-dd)");
		LocalDate dob = LocalDate.parse(sc.next());
		String qry = "select u from User u where u.card.number=?1 and u.card.dob=?2";
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, number);
		q.setParameter(2, dob);
		try {
			User u = (User) q.getSingleResult();
			System.out.println(u);
		} catch (NoResultException e) {
			System.err.println("Invalid Aadhar number or Dob...!!!");
		}
	}
}
