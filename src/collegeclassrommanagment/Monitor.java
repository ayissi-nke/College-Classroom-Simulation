/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegeclassrommanagment;

/**
 *
 * @author AYISSI NKE JOEL NARC
 */
public class Monitor extends Thread
{
     private Classroom classroom[];
     private boolean stop = false ;
    

    Monitor(Classroom classroom[]) {
        this.classroom = classroom;
    }

    private void setStop(boolean stop)
    {
        this.stop = stop;
    }

    private boolean isStop()
    {
        return stop;
    }
    
    
    @Override 
    public void run() {
        
        while(!isStop()){
            

            System.out.println("=======================================================================");
            System.out.println("Classroom\tLecturer\tInSession\tStudents\tVisitor");
            System.out.println("=======================================================================");
            for (int i = 0; i < classroom.length; i++) {
                System.out.print(classroom[i].getClassRoomName());
                if (classroom[i].getLecturer() != null) {
                    System.out.print("\t\t" + classroom[i].getLecturer().getLecturName());
                } else {
                     System.out.print("\t\t");
                }
                System.out.print("\t\t" + classroom[i].isLectureRuning() + "\t\t");

                    System.out.print(classroom[i].getCurrentNumberOfStudents());


                    System.out.print("\t\t" + classroom[i].getCurrentNumberOfVisitors());


                System.out.println();
            }
        }    
    }
    
    public void stopMonitor(){
        
        boolean isAlive = false;
        boolean isClassEmpty = true ;
        
        do{
            for(int i=0;i < classroom.length;i++){
               
              isClassEmpty = isClassEmpty && (classroom[0].getStudentList().isEmpty()&& classroom[0].getVisitorList().isEmpty());
                if(!isAlive ){
                    for(Student student : classroom[i].getStudentList()){
                        if(student.isAlive()){     
                            isAlive = true;
                            break;
                        }

                    }
                }

                if(!isAlive ){

                    for(Visitor visitor : classroom[i].getVisitorList()){
                        if(visitor.isAlive()){
                            isAlive= true;
                            break;
                        }
                    }
                }        
            }
        }while(isAlive && !isClassEmpty); 
        
        setStop(true) ;
    }
}
