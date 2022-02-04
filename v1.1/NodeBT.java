/* Made by Madelyn Hubbard, C0344379, as a lab assignment
 * Last modified 2019-08-17
 * 
 */
package finalproject_javafx;

/**
 *
 * @author Madelyn Hubbard
 */
public class NodeBT {
    protected Patient data;
    protected NodeBT left;
    protected NodeBT right;
    protected NodeBT parent;
    
    /**
     * Default constructor
     */
    public NodeBT(){
        data = null;
        left = null;
        right = null;
        parent = null;
    }//End default constructor
    
    /**
     * Constructor with data
     * @param d the String to be the data item in this node
     */
    public NodeBT(Patient d){
        data = d;
        left = null;
        right = null;
        parent = null;
    }//End constructor with data
    
    /**
     * Constructor with data and subtree pointers
     * @param d the String to be the data item in this node
     * @param l the left pointer
     * @param r the right pointer
     */
    public NodeBT(Patient d, NodeBT l, NodeBT r){
        data = d;
        left = l;
        right = r;
    }//End constructor with data and pointers
    
    /**
     * Set new object to overwrite current contents of the node
     * @param nd the new object
     */
    public void setData(Patient nd){
        data = nd;
    }//End setData
    
    /**
     * Reset left link to point to new node
     * @param nl the new node to link to on the left
     */
    public void setLeft(NodeBT nl){
        left = nl;
    }//End setLeft
    
    /**
     * Reset right link to point to new node
     * @param nr the new node to link to on the right
     */
    public void setRight(NodeBT nr){
        right = nr;
    }//End setRight
    
    /**
     * Reset parent link to point to new node
     * @param p the new parent node
     */
    public void setParent(NodeBT p){
        parent = p;
    }//End setParent
    
    /**
     * Retrieve the data currently in the node
     * @return the String currently stored in the node
     */
    public Patient getData(){
        return data;
    }//End getData
    
    /**
     * Retrieve the node currently linked to on the left
     * @return the node currently linked to by this node
     */
    public NodeBT getLeft(){
        return left;
    }//End getLeft
    
    /**
     * Retrieve the node currently linked to on the right
     * @return the node currently linked to by this node
     */
    public NodeBT getRight(){
        return right;
    }//End getRight
    
    /**
     * Retrieve the node's parent
     * @return the node's parent
     */
    public NodeBT getParent(){
        return parent;
    }//End getParent
    
    /**
     * Returns object's data as a string
     * @return Patient information as a string
     */
    @Override
    public String toString(){
        return data.toString();
    }//End toString
    
}// End NodeBST class
