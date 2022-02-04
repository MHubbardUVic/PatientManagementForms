/* Made by Madelyn Hubbard, C0344379
 * Last modified 2019-08-16
 * 
 */
package finalproject_javafx;



public class HourlyEmployee extends Employee {
    protected double hours;
    protected double payRate;
    protected double regularPay;
    protected double overtimePay;
    
    
    /**
     * Create hourly employee with no information
     */
    public HourlyEmployee(){
        super();
        this.setPay();
    }
    
    /**
     * Create hourly employee with full information
     * @param n Hourly employee name
     * @param h Hourly employee hours
     * @param pr Hourly employee rate of pay
     */
    public HourlyEmployee(String n, double h, double pr){
        super(n);
        hours = h;
        payRate = pr;
        this.setPay();
    }
    
    
    /**
     * Calculates amounts of each type of pay - regular, overtime, and gross -
     * and sets them
     */
    private void setPay(){
        overtimePay =  this.overtimePay();   
        regularPay =  payRate * hours;
        grossPay = regularPay + overtimePay;
    }
    
    /**
     * Calculates overtime pay when enough hours are worked to qualify for it
     * @return      The overtime pay as a double (might be 0)
     */
    private double overtimePay(){
        //If statement necessary to avoid negative pay for <40 hours of work!
        if (hours > 40)
            return (payRate*1.5) * (hours-40);
        else
            return 0;
    }
    
    
    /**
     * Gets employee gross pay as a double
     * @return Employee gross pay as a double
     */
    @Override
    public double getGrossPay(){
        return grossPay;
    }
    
    /**
     * Gets employee information as a string
     * @return Employee information as a string
     */
    @Override
    public String toString(){
        return this.getName() + "\tWorked "+ hours +" hours" + "\tEarns $" 
                + this.getGrossPay();
    }
}
