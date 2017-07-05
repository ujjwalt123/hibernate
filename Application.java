package com.hibernate.demo;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {

    public static void main(String[] args) {

        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Author Author1 = new Author();
        Author1.setId(1);
        Author1.setFirstname("First 1");
        Author1.setLastname("Last 1");
        Author1.setAge(20);
        Author1.setDob("11-5-1996");
        session.save(Author1);

        Author Author2 = new Author();
        Author2.setId(2);
        Author2.setFirstname("First 2");
        Author2.setLastname("Last 2");
        Author2.setAge(22);
        Author2.setDob("11-5-1996");
        session.save(Author2);

        Author Author3 = new Author();
        Author3.setId(3);
        Author3.setFirstname("First 3");
        Author3.setLastname("Last 3");
        Author3.setAge(24);
        Author3.setDob("11-5-1996");
        session.save(Author3);

        Author Author4 = new Author();
        Author4.setId(4);
        Author4.setFirstname("First 4");
        Author4.setLastname("Last 4");
        Author4.setAge(26);
        Author4.setDob("11-5-1996");
        session.save(Author4);
        session.getTransaction().commit();

        // to read
        Author auth = (Author) session.load(Author.class, 1);
        System.out.println("Name :" + auth.getFirstname()+auth.getLastname() + " and Age :" + auth.getAge()+ "dob is: "+auth.getDob());

        // to delete
        Author auth1 = (Author) session.load(Author.class, 1);
        session.delete(auth1);
        try {
            Author auth2 = (Author) session.load(Author.class, 1);
            System.out.println("Name :" + auth2.getFirstname() + auth2.getLastname() + " and Age :" + auth2.getAge()+ "dob is: "+auth.getDob());
        }
        catch(ObjectNotFoundException e)
        {
            System.out.println("the row has been deleted");
        }

        //to update
        Author auth3 = (Author)session.get(Author.class, 2);
        auth3.setFirstname("UpdatedFirst");
        auth3.setLastname("UpdatedLast");
        auth3.setAge(50);
        System.out.println("Name :" + auth3.getFirstname() + auth3.getLastname() + " and Age :" + auth3.getAge());


        session.close();
        sessionFactory.close();
        System.out.println("Hello World 1234 !!!!");
    }
}
