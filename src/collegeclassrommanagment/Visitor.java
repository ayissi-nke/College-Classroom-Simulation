
package collegeclassrommanagment;

/**
 *
 * @author AYISSI NKE JOEL NARC
 */
public class Visitor extends Thread 
{

   private String visitorName ;
    private Classroom classroom ;
    private boolean sitting = false;
    
    

    public Visitor(String visitorName)
    {
        this.visitorName = visitorName;
        
    }
    
    

    public boolean isSitting()
    {
        return sitting;
    }

    public void setSitting(boolean sitting)
    {
        this.sitting = sitting;
    }

    
    public String getVisitorName()
    {
        return visitorName;
    }

    public void setVisitorName(String visitorName)
    {
        this.visitorName = visitorName;
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
        boolean isEnter = classroom.addCurrentNumberOfVisitor(this);
        if(isEnter){
            this.classroom = classroom;
            this.start();
            return true ;
        }
        
        return false ;  
    }
    
    
    private void sitDown(){
        sitting = true ;
        System.out.println("visitor\t"+ this.getVisitorName() + " has sat down in class: \t" +classroom.getClassRoomName());
    }
    
     
    private void leave( ){
        // verify we are inside an existing class 
        if(this.classroom != null){
            // removing the visitors from the visitorsLirs of the class 
            this.classroom.removeCurrentNumberOfVisitor(this);
             System.out.println("visitor \t"+ this.getVisitorName()+ "\t leave successfully class :"+ classroom.getClassRoomName());
            this.classroom = null ;
            setSitting(false);
           
        }    
    }  

    @Override
    public void run()
    {
       try{
            Thread.sleep(2000);
        } catch (InterruptedException e){
            
                
        } 
       sitDown();
       
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e){
            
                
        } 
       leave();
    }  
    
}
 