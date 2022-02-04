/* Made by Madelyn Hubbard, C0344379, as a lab assignment
 * Last modified 2019-08-16
 * 
 */
package finalproject_javafx;

/**
 * @author Madelyn Hubbard
 */
public class NodeDL {
    protected Object data;
    protected NodeDL prev;
    protected NodeDL next;
    
    
    /**
     * Default constructor
     */
    public NodeDL(){
        data = null;
        prev = null;
        next = null;
    }//End default constructor
    
    /**
     * Constructor with object as data
     * @param obj the String to be the data item in this node
     */
    public NodeDL(Object obj){
        data = obj;
        prev = null;
        next = null;
    }//End constructor
    
    /**
     * Constructor with object as data, previous and next nodes
     * @param obj the String to be the data item in this node
     * @param p the previous node
     * @param n the next node
     */
    public NodeDL(Object obj, NodeDL p, NodeDL n){
        data = obj;
        prev = p;
        next = n;
    }//End constructor
    
    /**
     * Set new object to overwrite current contents of the node
     * @param nd the new object
     */
    public void setData(Object nd){
        data = nd;
    }//End setData
    
    /**
     * Reset next link to point to new node
     * @param nn the new node to link to
     */
    public void setNext(NodeDL nn){
        next = nn;
    }//End setNext
    
    /**
     * Reset prev link to point to new node
     * @param np the new node to link to
     */
    public void setPrev(NodeDL np){
        next = np;
    }//End setPrev
    
    /**
     * Retrieve the data currently in the node
     * @return the String currently stored in the node
     */
    public Object getData(){
        return data;
    }//End getData
    
    /**
     * Retrieve the node currently linked to by this node
     * @return the node currently linked to by this node
     */
    public NodeDL getNext(){
        return next;
    }//End getNext
    
    /**
     * Retrieve the node currently linked to by this node
     * @return the node currently linked to by this node
     */
    public NodeDL getPrev(){
        return prev;
    }//End getPrev
    
    /**
     * Returns object's data as a string with explanation
     * @return Object information as a string
     */
    @Override
    public String toString(){
        return data.toString();
    }//End toString
    
}//End NodeSL class
