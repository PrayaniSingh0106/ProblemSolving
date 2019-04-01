package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	    class DLinkedList{
	        int key;
	        int value;
	        DLinkedList pre;
	        DLinkedList next;
	    }
	    private void addNode(DLinkedList node){
	        
	        node.next = head.next;
	        node.pre = head;
	        
	        head.next.pre = node;
	        head.next = node;
	       
	    }
	    
	     private void removeNode(DLinkedList node){
	        DLinkedList pre = node.pre;
	        DLinkedList post = node.next;
	        
	        pre.next = post;
	        post.pre = pre;
	    }
	    
	    private void moveToHead(DLinkedList node){
	        this.removeNode(node);
	        this.addNode(node);
	    }
	    
	    private DLinkedList popFromTail(){
	        DLinkedList res = tail.pre;
	        this.removeNode(res);
	        return res;
	    }
	    
	    
	    private int capacity, count;
	    private DLinkedList head;
	    private DLinkedList tail;
	    private Map<Integer, DLinkedList> cache = new HashMap<Integer, DLinkedList>();
	        
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        this.count = 0;
	        
	        head = new DLinkedList();
	        head.pre = null;
	        
	        tail = new DLinkedList();
	        tail.next=null;
	        
	        head.next = tail;
	        tail.pre = head;
	    }
	    
	    public int get(int key) {
	       DLinkedList node = cache.get(key);
	        
	        if(node==null)
	            return -1;
	        
	        this.moveToHead(node);

	        return node.value;
	    }
	    
	    public void put(int key, int value) {
	       DLinkedList node = cache.get(key);
	        
	        if(node==null){
	          DLinkedList newNode = new DLinkedList();
	            newNode.key = key;
	            newNode.value = value;
	            
	            this.cache.put(key,newNode);
	            this.addNode(newNode); 
	            
	            ++count;
	            
	            if(count>capacity){
	               DLinkedList tail = this.popFromTail();
	                this.cache.remove(tail.key);
	                --count;
	            }
	            
	        }  
	        else{
	            node.value = value;
	            this.moveToHead(node);
	        }
	    }

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
}