/* Made by Madelyn Hubbard, C0344379, as a lab assignment
 * Last modified 2019-08-16
 * 
 */
package finalproject_javafx;

/**
 * @author Madelyn Hubbard
 */
public class NodeSL {
    protected Object data;
    protected NodeSL link;
    
    
    /**
     * Default constructor
     */
    public NodeSL(){
        data = "";
        link = null;
    }//End default constructor
    
    /**
     * Constructor with name and pointer
     * @param s the String to be the data item in this node
     */
    public NodeSL(Object s){
        data = s;
    }//End constructor
    
    /**
     * Set new String to overwrite current contents of the node
     * @param nd the new String
     */
    public void setData(Object nd){
        data = nd;
    }//End setData
    
    /**
     * Reset link to point to new node
     * @param nl the new node to link to
     */
    public void setLink(NodeSL nl){
        link = nl;
    }//End setLink
    
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
    public NodeSL getLink(){
        return link;
    }//End getLink
    
    /**
     * Returns object's data as a string with explanation
     * @return Object information as a string
     */
    @Override
    public String toString(){
        return data.toString();
    }//End toString
    
}//End NodeSL class
