/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabasejpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author keepa
 */
public class StudentDatabaseJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      // Student stu1 = new Student(1, "John", 3.5);
       //Student stu2 = new Student(2, "Marry",4.0);
       //StudentTable.insertStudent(stu1);
      // StudentTable.insertStudent(stu2);
      Student stu;
      
       stu = StudentTable.findStudentById(1);
       if (stu != null) {
           //stu.setName("Jack");
           StudentTable.removeStudent(stu);
           //StudentTable.updateStudent(stu);
       }
     
     
       List<Student> stuList = StudentTable.findAllStudent();
       printAllStudent(stuList);
    }
 public static void printAllStudent(List<Student> studentList) {
        for(Student emp : studentList) {
           System.out.print(emp.getId() + " ");
           System.out.print(emp.getName() + " ");
           System.out.println(emp.getGpa()+ " ");
       }
    }
    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentDatabaseJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
