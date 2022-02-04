/* Made by Madelyn Hubbard, C0344379, as a lab assignment
 * Last modified 2019-08-17
 * NOTE: name stands for Patients In Care Binary Search Tree
 */
package finalproject_javafx;

/**
 *
 * @author Madelyn Hubbard
 */
public class PICBST {
    NodeBT root;
    
    /**
     * Default constructor
     */
    public PICBST(){
        root = null;
    }//End default constructor
    
    /**
     * Constructor with initial patient
     * @param p the initial patient
     */
    public PICBST(Patient p){
        root = new NodeBT(p);
    }//End constructor with initial object
    
    /**
     * Determine if the BST is empty
     * @return true if empty, false if non-empty
     */
    public boolean isEmpty(){
        return root==null;
    }//End isEmpty
    
    /**
     * Add a new patient to the set of patients in care. I'm assuming I will
     * never get a non-unique patient number (which I won't)
     * @param np the new patient
     */
    public void insert(Patient np){
        if (!isEmpty()){
            NodeBT probeParent = root;
            NodeBT probe;
            if (np.pNumber<root.data.pNumber)
                probe = root.left;
            else
                probe = root.right;
            
            while (probe!=null){
                probeParent = probe;
                if (np.pNumber<probe.data.pNumber){
                    probe = probe.left;
                }else{
                    probe = probe.right;
                }//end else
            }//end while
            
            probe = new NodeBT(np);
            probe.parent = probeParent;
            if (probe.data.pNumber<probeParent.data.pNumber)
                probeParent.left = probe;
            else
                probeParent.right = probe;
        }//end if
    }//End of insert
    
    /**
     * Remove a patient from patients in care, discharging them from the list
     * @param num the patient's number
     * @return a patient
     */
    public Patient remove(int num){
        if (isEmpty()){
            return null;
        }else if (root.data.pNumber == num){
            
            return root.data;
        }else{
            NodeBT probeParent = root;
            NodeBT probe;
            if (num<root.data.pNumber)
                probe = root.left;
            else
                probe = root.right;
            
            while (probe!=null){
                probeParent = probe;
                if (num<probe.data.pNumber){
                    probe = probe.left;
                }else{
                    probe = probe.right;
                }//end else
            }//end while
            
            //probe = new NodeBT(np);
            probe.parent = probeParent;
            if (probe.data.pNumber<probeParent.data.pNumber)
                probeParent.left = probe;
            else
                probeParent.right = probe;
            
        }
        return null;
    }//End of remove
    
}//End PICBST
