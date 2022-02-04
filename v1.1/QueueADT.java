/* Made by Madelyn Hubbard, C0344379, as a lab assignment
 * Last modified 2019-08-16
 * 
 */
package finalproject_javafx;

/**
 * @author Madelyn Hubbard
 */
public interface QueueADT {
    Object dequeue();
    Object peek();
    void enqueue(Object o);
    boolean isEmpty();
    int size();
    
    @Override
    String toString();
    
}//End of StackADT interface
