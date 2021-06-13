
package collegeclassrommanagment;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AYISSI NKE JOEL NARC
 */
public class College
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Random rand = new Random();
        
        
        Classroom W201 = new Classroom(4, "W201");
        Classroom W202 = new Classroom(2, "W202");
        Classroom W101 = new Classroom(3, "W101");
        Classroom W102 = new Classroom(4, "W102");
        
        Classroom[] classrooms = {W201,W202} ;
        
        
        Student Ayissi = new Student("Ayissi");
        Student Joel = new Student("Joel");
        Student Cabrel = new Student("Cabrel");
        Student Fokam = new Student("Fokam");
        
        Student[] students = {Ayissi,Joel,Cabrel};
        
        
        Visitor Nigaying = new Visitor("Mr Nigaying");
        Visitor Aldan = new Visitor("Mr Aldan");
        Visitor Tchassem = new Visitor("Mr Tchassem");
        Visitor[] visitors = {Nigaying,Aldan,Tchassem};
        
        Lecturer Osama = new Lecturer("Osama");
        Lecturer Barry = new Lecturer("Barry");
        Lecturer Faheem  = new Lecturer("Faheem"); 
        Lecturer Alex  = new Lecturer("Alex");
        Lecturer Aqeel  = new Lecturer("Aqeel");
        Lecturer Waseem  = new Lecturer("Waseem");
        
        Lecturer[] lectures = {Osama,Barry,Faheem,Alex,Aqeel,Waseem};
        
        
        Monitor monitor = new Monitor(classrooms) ;
        monitor.start();
        
        
        for(Student student : students){
            
            student.enter(classrooms[rand.nextInt(classrooms.length)]);
            try
            {
                student.sleep(2000);
            } catch (InterruptedException ex)
            {
                
            }
            
        }
        
        for(Visitor visitor : visitors){
            
            visitor.enter(classrooms[rand.nextInt(classrooms.length)]);
            
        }
        
       
        for(Lecturer lecturer: lectures){
            
            lecturer.enter(classrooms[rand.nextInt(classrooms.length)]);
            
        }
        students[0].enter(classrooms[0]);
        visitors[0].enter(classrooms[0]);
        
       
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException ex)
        {
            Logger.getLogger(College.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        monitor.stopMonitor();
        
        
        
        
    }
    
}
 