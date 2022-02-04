/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject_javafx;

/**
 *
 * @author Madelyn
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StackDLL stack = new StackDLL();
        String beep = "beep";
        String bop = "bop";
        stack.push(beep);
        stack.push(bop);
        System.out.println(""+ stack.pop().toString());
        System.out.println(""+ stack.pop().toString());
        
        QueueSLL queue = new QueueSLL();
        queue.enqueue(beep);
        queue.enqueue(bop);
        System.out.println(""+ queue.dequeue().toString());
        System.out.println(""+ queue.dequeue().toString());
    }
    
}
