/* Made by Madelyn Hubbard, C0344379, as a lab assignment
 * Last modified 2019-07-24
 * 
 */
package finalproject_javafx;

/**
 * @author Madelyn Hubbard
 */
public class Patient {
    protected String firstName;
    protected String lastName;
    protected int priority;
    protected int pNumber;
    protected Bed bed;
    
    static protected int count = 0;
    
    
    /**
     * Default constructor
     */
    public Patient(){
    }//End default constructor
        
    /**
     * Constructor for full name and priority
     * @param f Patient's firstName
     * @param p Patient's priority
     */
    public Patient(String f, String l, int p){
        firstName = f;
        lastName = l;
        pNumber = 0;
        if (1<=p && p<=10)
            priority = p;
        else if (p<1)
            priority = 1;
        else if (p>10)
            priority = 10;
        
    }//End constructor
    
    /**
     * Setter assigns new first name, to correct errors
     * @param nn Patient's new, correct first name
     */
    public void setFirstName(String nn){
        firstName = nn;
    }//End setFirstName
    
    /**
     * Setter assigns new last name, to correct errors
     * @param nn Patient's new, correct last name
     */
    public void setLastName(String nn){
        lastName = nn;
    }//End setLastName
    
    /**
     * Setter assigns new priority, to adjust to changing patient conditions
     * @param np Patient's new priority
     */
    public void setPriority(int np){
        priority = np;
    }//End setPriority
    
    /**
     * Setter assigns new patient number, to use when patient is taken
     * into care
     * @param num Patient's new patient number
     */
    public void setnumber(int num){
        pNumber = num;
    }//End setPriority
    
    /**
     * Setter assigns new bed, to facilitate moving patients
     * @param nb Patient's new bed
     */
    public void setBed(Bed nb){
        bed = nb;
    }//End setBed
    
    
    /**
     * Retrieve patient's first name
     * @return Patient's first name
     */
    public String getFirstName(){
        return firstName;
    }//End getFirstName
    
    /**
     * Retrieve patient's last name
     * @return Patient's last name
     */
    public String getLastName(){
        return lastName;
    }//End getLastName
    
    /**
     * Retrieve patient's current priority
     * @return Patient's priority
     */
    public int getPriority(){
        return priority;
    }//End getPriority
    
    /**
     * Retrieve patient's patient number
     * @return Patient's number
     */
    public int getPatientNumber(){
        return pNumber;
    }//End getPatientNumber
    
    /**
     * Retrieve patient's current assigned bed
     * @return
     */
    public Bed getBed(){
        return bed;
    }//End getBed
 
    
    /**
     * Returns a quick sentence outlining patient name, priority, and only if
     * they are admitted into care, their bed and patient number
     * @return Object information as a string
     */
    @Override
    public String toString(){
        //Check if patient has a bed or number assigned; return that info only
        //if they do
        String bedAppend = "";
        String pNumAppend = "";
        if (this.bed!=null)
            bedAppend = ", is assigned to bed "+ bed.toString();
        if (this.pNumber!=0)
            pNumAppend = ", and is patient number "+ pNumber;
        
        return firstName +" "+ lastName +"\tpriority "+ priority
                + bedAppend + pNumAppend +"\n";
    }//End toString
    
}//End Patient class
