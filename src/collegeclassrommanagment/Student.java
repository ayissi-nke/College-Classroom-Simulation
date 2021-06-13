
package collegeclassrommanagment;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AYISSI NKE JOEL NARC
 */
public class Student extends Thread
{
    private String studentName ;
    private Classroom classroom ;
    private boolean sitting = false;

    
    public Student(String studentName)
    {
        this.studentName = studentName;
        
    }
    
    
     
    public boolean isSitting() 
    {
        return sitting;
    }

    public void setSitting(boolean sitting)
    {
        this.sitting = sitting;
    }

   

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public Classroom getClassroom()
    {
        return classroom;
    }

    private void setClassroom(Classroom classroom)
    {
        this.classroom = classroom;
    }
    
    public boolean enter(Classroom classroom){
        /*Random rand = new Random();
        int studentDelay = rand.nextInt(5000);*/
        
        boolean isEnter = classroom.addCurrentNumberOfStudent(this);
        if(isEnter){
            this.classroom = classroom;
            
            System.out.println("student \t"+this.getStudentName()+" enter successfully in the class: \t" +classroom.getClassRoomName());
            this.start();
            
        
            return true;
        }    
        return false ; 
    }
    
    
    private void sitDown(){
        sitting = true ;
        System.out.println("student\t"+this.getStudentName()+" has sat down in class\t: "+ classroom.getClassRoomName() );
    }
    
    
    private boolean leave( ){
        // verify if the clssromm is not null and if there is no lecturer in the class before a student can leave
        if(this.classroom != null && classroom.getLecturer() == null ){
            // removing the student from the studentList
            System.out.println("student\t"+this.getStudentName()+ "\t  left the class successfully \t"+ classroom.getClassRoomName());
            this.classroom.removeCurrentNumberOfStudent(this);
            //reset his others attribut to default
            setSitting(false);
            this.classroom = null ;
            return true ;
        }   
         
        return false ;
    }

    @Override
    public void run()
    {   
      
        try
            {
                Thread.sleep(2000);
            } catch (InterruptedException e)
            {
                
            }
        sitDown();
        
        try
            {
                Thread.sleep(10000);
            } catch (InterruptedException e)
            {
                
            }
        while(!leave());
       
    }
           
}
