
package collegeclassrommanagment;

import java.util.ArrayList;

/**
 *
 * @author AYISSI NKE JOEL NARC
 */
public class Classroom
{
    private int maxCapacity  ;
    private int capacity = 0 ;
    private int currentNumberOfStudents = 0;
    private int currentNumberOfVisitors = 0;
    private String classRoomName ;
    private Lecturer lecturer  ;
    private boolean lectureRuning = false ;
    private  ArrayList<Student> studentList ;
    private  ArrayList<Visitor> visitorList ;
    
    
    public Classroom(int maxCapacity, String classRoomName)
    {
        this.maxCapacity = maxCapacity;
        this.classRoomName = classRoomName;
        studentList = new ArrayList();
        visitorList = new ArrayList();
    }

    public ArrayList<Student> getStudentList()
    {
        return studentList;
    }

    public ArrayList<Visitor> getVisitorList()
    {
        return visitorList;
    }
    
   
    public int getMaxCapacity()
    {
        return maxCapacity;
    }

   
    public int getCapacity()
    {
        return capacity;
    }

    public int getCurrentNumberOfStudents()
    {
        return currentNumberOfStudents;
    }

    public void setCurrentNumberOfStudents(int currentNumberOfStudents)
    {
        this.currentNumberOfStudents = currentNumberOfStudents;
    }

    public int getCurrentNumberOfVisitors()
    {
        return currentNumberOfVisitors;
    }

    public void setCurrentNumberOfVisitors(int currentNumberOfVisitors)
    {
        this.currentNumberOfVisitors = currentNumberOfVisitors;
    }

    public String getClassRoomName()
    {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName)
    {
        this.classRoomName = classRoomName;
    }

    public Lecturer getLecturer()
    {
        return lecturer;
    }

    public synchronized void setLecturer(Lecturer lecturer)
    {
        this.lecturer = lecturer;
    }

    public boolean isLectureRuning()
    {
        return lectureRuning;
    }

    public void setLectureRuning(boolean lectureRuning)
    {
        this.lectureRuning = lectureRuning;
    }

   
    public boolean checkClassFull(){
    
        if(maxCapacity == capacity){
            
            return true ;
            
        }
        
        return false ;
    }
    
     
    private synchronized boolean addClassMember(){
        //verify if the class is not full and there is no lecture in the class
        if(!checkClassFull() && lecturer == null){
            // incrementing the current numbers of person both student and visitors
            capacity++ ;
            
            return true ;
        }
        
        return false ;
    }
    
    public  boolean addCurrentNumberOfStudent(Student student ){
        //if the student has been admit in the class we store him in le list of student
        if(addClassMember()){
           
            this.studentList.add(student) ;
            currentNumberOfStudents++ ;
           
            return true ;
        }  
        if(checkClassFull())
            System.out.println("student \t"+student.getStudentName()+" can't not enter the class is full");
        else if(lecturer != null){
            System.out.println("student \t"+student.getStudentName()+" can't not enter ,there is a lecturer in the class");
        
        }
       
        return false ;
    
    } 
    
    public boolean addCurrentNumberOfVisitor(Visitor visitor){
        // verify if the visitor has been admited in the classroom and if the number of visitors is < 5
        if(addClassMember() && visitorList.size() <5){
            currentNumberOfVisitors++ ;
            // adding the visitor in the visitor list of the class
            visitorList.add(visitor);
            System.out.println("visitors \t"+visitor.getVisitorName()+ "\t enter successfully");
            return true ;
        }  
        System.out.println("visitors \t" +visitor.getVisitorName()+ " \t not allow to enter");
        return false ;
    
    }
    
     private synchronized boolean removeClassMember(){
            // verify is the class is not empty  
            if(capacity > 0){
                 
                capacity-- ;
                //System.out.println("member remove successfully from the class");
                 return true ;
            }
        System.out.println("the class is  empty");         
        return false ;
    }
     
     
    public  boolean removeCurrentNumberOfStudent(Student student){
        
        if(removeClassMember() ){
           currentNumberOfStudents-- ;  
            studentList.remove(student) ;
            
        }  
       
        return false ; 
    
    } 
    
    public boolean removeCurrentNumberOfVisitor(Visitor visitor){
        // verify if the visitor has been succesfully remove as member of the class and the remove him from the visitorList 
        if(removeClassMember()){
            currentNumberOfVisitors-- ;
            visitorList.remove(visitor);
            
            return true ;
        }  
          
        return false ;
    
    }
     
    
}
