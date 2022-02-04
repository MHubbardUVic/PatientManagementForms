/* Made by Madelyn Hubbard, C0344379
 * Last modified 2019-07-17
 * 
 */
package finalproject_javafx;



public class Employee implements EmployeeADT{
    protected String name;
    protected double grossPay;
    
    /**
     * Create full time employee with full information
     * @param n Employee name
     * @param gp Employee gross pay
     */
    public Employee(String n, double gp){
        name = n;
        grossPay = gp;
    }
    /**
     * Create full time employee with just name
     * @param n Employee name
     */
    public Employee(String n){
        name = n;
        grossPay = 0.0;
    }
    /**
     * Create full time employee with no information
     */
    public Employee(){
        name = "Unknown";
        grossPay = 0.0;
    }
    
    
    /**
     * Returns employee pay as a double
     * @return Employee pay as a double
     */
    @Override
    public double getGrossPay(){
        return grossPay;
    }
    
    /**
     * Returns employee name as a string
     * @return Employee name as a string
     */
    @Override
    public String getName(){
        return name;
    }
    
    /**
     * Returns employee information as a string
     * @return Employee information as a string
     */
    @Override
    public String toString(){
        return this.getName() + "\tEarns $" + this.getGrossPay();
    }
}
