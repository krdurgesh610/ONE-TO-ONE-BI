package org.jsp.one2onebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the User Id to fetch All Details");
		int id = sc.nextInt();
		String qry = "select u from User u where u.id=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, id);
		try {
			User u = (User) q.getSingleResult();
			System.out.println(u);
		}
		catch(NoResultException e) {
			System.err.println("Invalid Entered User Id...!!");
		}
	}
}
