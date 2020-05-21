/**
 * 
 */
package com.vinayparihar.jpa.xmlconfig.client;

import javax.persistence.EntityManager;

import com.vinayparihar.jpa.xmlconfig.model.Student;
import com.vinayparihar.jpa.xmlconfig.util.JPAUtil;

/**
 * @author VinayParihar
 * @date May 14, 2020 @time 5:11:22 PM
 */
public class CRUD_Client_2_merge {

	public static void main(String[] args) {

		EntityManager entitymanager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entitymanager.getTransaction().begin();

		Student student = entitymanager.find(Student.class, 1);

		System.out.println("*** Before Updation ***");
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		System.out.println(student.getEmail());

		student.setFirstName("LaxmiDigamber");
		student.setLastName("Parihar");
		student.setEmail("ld@gmail.com");

		Student updatedStudent = entitymanager.merge(student);

		System.out.println("*** After Updation ***");
		System.out.println(updatedStudent.getId());
		System.out.println(updatedStudent.getFirstName());
		System.out.println(updatedStudent.getLastName());
		System.out.println(updatedStudent.getEmail());

		entitymanager.getTransaction().commit();

		entitymanager.close();
		JPAUtil.shutdown();

	}

}
