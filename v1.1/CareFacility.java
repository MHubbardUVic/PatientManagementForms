/* Made by Madelyn Hubbard, C0344379, as a lab assignment
 * Last modified 2019-08-16
 * 
 */
package finalproject_javafx;


/**
 * @author Madelyn Hubbard
 */
public class CareFacility extends Company{
    /* My CareFacility class doesn't have an hourly employee roster since
     * my Company class already has one
     */
    protected StackDLL beds = new StackDLL();
    
    //To expedite patient sorting, each priority class of patient is placed
    //in their own queue
    protected QueueSLL patientP1 = new QueueSLL();
    protected QueueSLL patientP2 = new QueueSLL();
    protected QueueSLL patientP3 = new QueueSLL();
    protected QueueSLL patientP4 = new QueueSLL();
    protected QueueSLL patientP5 = new QueueSLL();
    protected QueueSLL patientP6 = new QueueSLL();
    protected QueueSLL patientP7 = new QueueSLL();
    protected QueueSLL patientP8 = new QueueSLL();
    protected QueueSLL patientP9 = new QueueSLL();
    protected QueueSLL patientP10 = new QueueSLL();
    
    //Didn't make a heap of patient queues; satisfied myself with an array
    protected QueueSLL[] patientIntakes = {patientP1, patientP2, patientP3,
        patientP4, patientP5, patientP6, patientP7, patientP8, patientP9,
        patientP10};
    
    //
    protected QueueSLL patientsInCare = new QueueSLL();
        
    
    
    /**
     * Default constructor
     */
    public CareFacility(){
        super();
    }//End default constructor    
    
    /**
     * Constructor for a care facility with a name
     * @param n The care facility's name
     */
    public CareFacility(String n){
        super();
        name = n;
    }//End constructor with facility name
    
    
    /**
     * Retrieves patient at the front of the highest priority queue
     * @return
     */
    public Patient getTopPriorityPatient(){
        int hpqi=-1; /* Highest Priority Queue Index 
                        Java insists that it get initialized */
        boolean priorityFound=false;
                     // Has the top priority non-empty queue been found?
            
        /* Identify highest priority non-empty queue, walking backwards (since
         * I've put the highest priority queue at the end of the array)
         */
        for (short i=9; i>=0 && priorityFound==false; i--){
            if (!patientIntakes[i].isEmpty()){
                priorityFound=true;
                hpqi=i;
            }//End if    
        }//End for
        
        //If a non-empty patient queue was found, return a patient from
        //the highest priority queue
        if (priorityFound)
            return (Patient)patientIntakes[hpqi].dequeue();  
        //If no patients were found, issue a placeholder patient
        //Not ideal exception handling, I know...
        else return new Patient();
    }//End getTopPriorityPatient
    
    
    /**
     * Determines whether or not the overall patient intake list is empty by
     * determining if each individual patient queue is empty
     * @return Boolean that will be true if there are no intake patients
     */
    public boolean intakeisEmpty(){
        boolean iisEmpty=true;
        
        for (short i=9; i>=0 && iisEmpty==true; i--){
            if (!patientIntakes[i].isEmpty()){
                iisEmpty=false;
            }//End if    
        }//End for
        
        return iisEmpty;
    }//End intakeisEmpty
    
    /**
     * Retrieves bed to be assigned first
     * @return Bed at the top of the "beds" stack
     */
    public Bed getFirstBed(){
        return (Bed)beds.peek();
    }//End getFirstBed
    
    
    /**
     * Add new patient to the appropriate intake queue based on priority
     * @param np New patient
     * @return A message indicating patient has been assigned or not
     */
    public String intakePatient(Patient np){
        boolean patientAssigned=false;
        switch( np.getPriority() ){
            case 1:
                patientP1.enqueue(np);
                patientAssigned = true;
                break;
            case 2:
                patientP2.enqueue(np);
                patientAssigned = true;
                break;
            case 3:
                patientP3.enqueue(np);
                patientAssigned = true;
                break;
            case 4:
                patientP4.enqueue(np);
                patientAssigned = true;
                break;
            case 5:
                patientP5.enqueue(np);
                patientAssigned = true;
                break;
            case 6:
                patientP6.enqueue(np);
                patientAssigned = true;
                break;
            case 7:
                patientP7.enqueue(np);
                patientAssigned = true;
                break;
            case 8:
                patientP8.enqueue(np);
                patientAssigned = true;
                break;
            case 9:
                patientP9.enqueue(np);
                patientAssigned = true;
                break;
            case 10:
                patientP10.enqueue(np);  
                patientAssigned = true;            
        }
        
        if (patientAssigned)
            return "Patient "+ np.getFirstName() +" "+ np.getLastName() 
                    +" received at priority "+ np.getPriority();
        else
            return "Patient not received; priority is invalid";      
    }//End intakePatient
    
    /**
     * Add new bed to bed stack using a Bed object
     * @param nb New bed
     */
    public void addBed(Bed nb){
        beds.push(nb);
    }//End addBed
    
    /**
     * Add new bed to bed stack by bed name and location
     * @param bn The bed's name
     * @param bl The bed's location
     */
    public void addBed(String bn, String bl){
        Bed tempBed = new Bed(bn, bl);
        beds.push(tempBed);
    }//End addBed
    
    /**
     * Assign available bed to highest priority patient
     * @return Message indicating success - who went to what bed - or failure
     */
    public String assignBed(){
        //Check if we have any available beds
        if (beds.isEmpty())
            return "Cannot assign a bed to a patient. No beds available.";
        //Check if we have any patients waiting for beds
        else if (this.intakeisEmpty()){
            return "Cannot assign a bed to a patient. No patients need beds!"
                    + " :)";
        }
        /* Give the priority patient the
         * first available bed and register them as being in care */
        else{
            Bed tempBed = (Bed)beds.pop();
            Patient tempPatient = this.getTopPriorityPatient();
            tempPatient.setBed(tempBed);
            //Give the patient a patient number
            tempPatient.pNumber=(++Patient.count);
           
            patientsInCare.enqueue(tempPatient);
            
            return "Patient "+ tempPatient.getFirstName() +" "+ 
                    tempPatient.getLastName() +" assigned to "+ 
                    tempBed.getName() +" bed in "+ tempBed.getLocation();
        }//End else
    }//End assignBed method
    
    /**
     * Return the names and priorities of all patients in the intake list
     * @return a long, indented string of all intake patient's info
     */
    public String getIntakeList(){
        String temp = "";
        for (short i=9; i>=0; i--){
            if (!patientIntakes[i].isEmpty()){
                temp += patientIntakes[i].toString();
            }//End if    
        }//End for
        return temp;
    }//End getIntakeList
    
    /**
     * Return a care facility's name, number of beds, and number of patients
     * currently receiving care. Patient intake queue information is not
     * returned, as it is confidential.  ;)
     * @return Object information as a string
     */
    @Override
    public String toString(){
        return "The care facility "+ name +" has "+ beds.size() +" beds and "+
                patientsInCare.size() +" patients in care.";
    }//End toString
    
}//End CareFacility class
