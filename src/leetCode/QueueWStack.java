package leetCode;

import java.util.Stack;

public class QueueWStack {
	
	Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
    /** Initialize your data structure here. */
    public QueueWStack() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        st1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //will be different from stack
        if(st1.isEmpty() && st2.isEmpty())
            return 0;
        
        if(st2.isEmpty()){
            while(!st1.isEmpty())
                st2.push(st1.pop());
        }
        return st2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
       
        if(!st2.isEmpty())
            return st2.peek();
        else{
            while(!st1.isEmpty())
            st2.push(st1.pop());
        }
        return st2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(st1.isEmpty() && st2.isEmpty())
            return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * QueueWStack obj = new QueueWStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

