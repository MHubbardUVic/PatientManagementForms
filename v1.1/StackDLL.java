/* Made by Madelyn Hubbard, C0344379, as a lab assignment
 * Last modified 2019-08-16
 */
package finalproject_javafx;

/**
 * @author Madelyn Hubbard
 */
public class StackDLL implements StackADT {
    protected NodeDL head;
    protected NodeDL tail;
    protected int size;
    
    
    /**
     * Default constructor
     */
    public StackDLL(){
        head = null;
        tail = head;
        size = 0;
    }//End default constructor
    
    /**
     * Push a new object onto the top of the stack
     * @param obj the object to push onto the top of the stack
     */
    public void push(Object obj){
        if (isEmpty()){
            head = new NodeDL (obj);
            tail = head;
            size++;
        }else{
            tail.next = new NodeDL(obj);
            tail.next.prev = tail;
            tail = tail.next;
            size++;
        }
    }//End set
    
    /**
     * Returns the stack's size (aka number of elements)
     * @return the stack's size (aka number of elements)
     */
    public int size(){
        return size;
    }//End get
    
    /**
     * Returns true if the stack has no elements, false otherwise
     * @return true if the stack has no elements, false otherwise
     */
    public boolean isEmpty(){
        return size==0;
    }//End get
    
    /**
     * Peek at top item of stack, returning it without removing it
     * @return top object from stack
     */
    public Object peek(){
        return tail.data;
    }//End peek
    
    /**
     * Peek at top item of stack, returning it without removing it
     * @return top object from stack
     */
    public Object pop(){
        if (isEmpty())
            return null;
        else if (tail==head){
            Object temp = tail.data;
            head = null;
            tail = null;
            size--;
            return temp;
        }else{
            Object temp = tail.data;
            tail = tail.prev;
            tail.next = null;
            size--;
            return temp;
        }
    }//End pop
    
    /**
     * Returns object's information as a string
     * @return Object information as a string
     */
    @Override
    public String toString(){
        String output = "";
        NodeDL probe = head;
        while (probe!=null){
            output+=probe.toString();
            probe = probe.next;
        }
        return output;
    }//End toString
    
}//End StackDLL class
