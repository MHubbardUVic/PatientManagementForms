/* Made by Madelyn Hubbard, C0344379, as a lab assignment
 * Last modified 2019-08-16
 * 
 */
package finalproject_javafx;

/**
 * @author Madelyn Hubbard
 */
public class Bed {
    protected String name;
    protected String location;
    
    
    /**
     * Default constructor
     */
    public Bed(){
    }//End default constructor
    
    /**
     * Full constructor
     * @param n The bed's name
     * @param l The bed's location as a qualitative descriptor
     */
    public Bed(String n, String l){
        name = n;
        location = l;
    }//End full constructor
    
    
    /**
     * Reset the bed's name
     * @param nn The bed's new name
     */
    public void setName(String nn){
        name = nn;
    }//End setName
    
    /**
     * Reset the bed's location
     * @param nl The bed's new location
     */
    public void setLocation(String nl){
        location = nl;
    }//End setLocation
    
    
    /**
     * Retrieve bed's name
     * @return Bed's name
     */
    public String getName(){
        return name;
    }//End getName
    
    /**
     * Retrieve bed's location
     * @return Bed's location
     */
    public String getLocation(){
        return location;
    }//End getLocation
    
    
    /**
     * Returns name and location with no preamble text
     * @return name and location with no preamble text
     */
    @Override
    public String toString(){
        return name +" in "+ location +"\n";
    }//End toString
    
}//End Bed class
