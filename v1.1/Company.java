/* Made by Madelyn Hubbard, C0344379
 * Last modified 2019-08-16
 * 
 */
package finalproject_javafx;



public class Company {
    
    protected String name;
    protected Employee[] staffList;
    protected HourlyEmployee[] auxList;
    
    /**
     * Create company with no information
     */
    public Company(){
        name = "Unknown";
        staffList = null;
        auxList = null;
    }
    /**
     * Create company with name and full-time employee list
     * @param n Company name
     * @param ft List of full time employees
     */
    public Company(String n, Employee[] ft){
        name = n;
        staffList = ft;
       
    }
    
    /**
     * Create company with full information
     * @param n Company name
     * @param ft List of full time employees
     * @param he List of auxiliary (aka hourly) employees
     */
    public Company(String n, Employee[] ft, HourlyEmployee[] he){
        name = n;
        staffList = ft;
        auxList = he;
    }
    
    /**
     * Return company's highest earner by walking through lists of regular
     * and hourly employees using for loops
     * @return The company's highest earner
     */
    public Employee getBestPaid(){
        Employee bestPaid = new Employee();
        for(int i=0; i<staffList.length; i++){
            if(staffList[i].getGrossPay() > bestPaid.getGrossPay())
                bestPaid = staffList[i];
        }
        for(int i=0; i<auxList.length; i++){
            if(auxList[i].getGrossPay() > bestPaid.getGrossPay())
                bestPaid = auxList[i];
        }
        return bestPaid;
    }
}
