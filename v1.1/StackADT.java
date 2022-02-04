/* Made by Madelyn Hubbard, C0344379, as a lab assignment
 * Last modified 2019-07-17
 * 
 */
package finalproject_javafx;

/**
 * @author Madelyn Hubbard
 */
public interface StackADT {
    Object pop();
    Object peek();
    void push(Object o);
    boolean isEmpty();
    int size();
    
    @Override
    String toString();
    
}//End of StackADT interface
