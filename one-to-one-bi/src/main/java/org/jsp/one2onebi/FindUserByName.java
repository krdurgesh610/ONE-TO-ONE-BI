package org.jsp.one2onebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the User Name to fetch All Details");
		String name = sc.next();
		String qry = "select u from User u where u.name=?1";
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query q = manager.createQuery(qry);
		q.setParameter(1, name);
		try {
			User u = (User) q.getSingleResult();
			System.out.println(u);
		} catch (NoResultException e) {
			System.err.println("Invalid Entered User Name...!!!");
		}
	}
}
