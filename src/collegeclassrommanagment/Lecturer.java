
package collegeclassrommanagment;

/**
 *
 * @author AYISSI NKE JOEL NARC
 */
public class Lecturer extends Thread
{
    private String lecturerName ;
    private Classroom classroom ;

    public Lecturer(String lecturerName)
    {
        this.lecturerName = lecturerName;
        
        
    }

    public String getLecturName()
    {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName)
    {
        this.lecturerName = lecturerName;
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
        // verify if there is no lecture already in the class
        boolean isLecturer = classroom.getLecturer()== null;
        if(isLecturer){
              classroom.setLecturer(this);
              this.classroom = classroom ;
              this.start();
              System.out.println("Lecturer:\t" +classroom.getLecturer().lecturerName+ "\t enter successfully in class :" + classroom.getClassRoomName());
              return true ;
        }
       System.out.println("access denied to Lecturer: \t" +this.lecturerName+ "\t two lecturer cant be in a class : \t"+classroom.getClassRoomName()+" at the same time ");
       return false ;
    }
    
    public boolean startLecture(){
        //verify if the classroom exist
        if(classroom == null)
            return false ;
        // verify if all the student in the class have sat down
        boolean sitDown = true ;
        for(Student student: classroom.getStudentList()){
            sitDown = sitDown && student.isSitting();
        }
        // verify if all the visitors in the class have stat down
        for(Visitor visitor : classroom.getVisitorList()){
            sitDown = sitDown && visitor.isSitting();
        }
        if(sitDown){
            classroom.setLectureRuning(true);
            System.out.println("Lecturer"+this.getLecturName()+"\t started lecture successfully in classroom \t" +classroom.getClassRoomName());
            return true ;
        }
        
         System.out.println("Lecture can't be started student and visitors should sit down");

        return false ;    
    }
    
    public void leave() {
        if(this.classroom != null){
          System.out.println("Lecturer\t"+this.getLecturName()+" leave the class \t"+classroom.getClassRoomName());  
          classroom.setLecturer(null);
          classroom.setLectureRuning(false);
          this.classroom = null ;
          
        }  
       System.out.println("");
    }
 
    @Override
    public void run()
    {
     
       while(!startLecture());
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            
                
        } 
       leave();
    }
    
    
}
