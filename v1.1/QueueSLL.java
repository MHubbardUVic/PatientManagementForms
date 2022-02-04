/* Made by Madelyn Hubbard, C0344379, as a lab assignment
 * Last modified 2019-08-16
 */
package finalproject_javafx;

/**
 * @author Madelyn Hubbard
 */
public class QueueSLL implements QueueADT {
    protected NodeSL head;
    protected NodeSL tail;
    protected int size;
    
    
    /**
     * Default constructor
     */
    public QueueSLL(){
        head = null;
        tail = head;
        size = 0;
    }//End default constructor
    
    /**
     * Enqueue a new object to the end of the queue
     * @param obj the object to enqueue to the end of the queue
     */
    public void enqueue(Object obj){
        if (isEmpty()){
            head = new NodeSL (obj);
            tail = head;
            size++;
        }else{
            tail.link = new NodeSL(obj);
            tail = tail.link;
            size++;
        }
    }//End set
    
    /**
     * Returns the queue's size (aka number of elements)
     * @return the queue's size (aka number of elements)
     */
    public int size(){
        return size;
    }//End get
    
    /**
     * Returns true if the queue has no elements, false otherwise
     * @return true if the queue has no elements, false otherwise
     */
    public boolean isEmpty(){
        return size==0;
    }//End get
    
    /**
     * Peek at front item of queue, returning it without removing it
     * @return top object from stack
     */
    public Object peek(){
        if (isEmpty())
            return null;
        else
            return head.data;
    }//End peek
    
    /**
     * Dequeue from item from the queue, returning it and removing it
     * @return front item from queue
     */
    public Object dequeue(){
        if (isEmpty())
            return null;
        else if (head==tail){
            Object temp = head.data;
            head = null;
            tail = null;
            size=0;
            return temp;
        }else{
            Object temp = head.data;
            head = head.link;
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
        NodeSL probe = head;
        while (probe!=null){
            output+=probe.toString();
            probe = probe.link;
        }
        return output;
    }//End toString
    
}//End StackDLL class
