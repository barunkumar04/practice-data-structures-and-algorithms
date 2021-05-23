package com.practice.cache;

import java.util.HashMap;
import java.util.Map;

/**
Approach:
1. Have a HashMap<Integer, Node(prev, value, next)>, with a capacity defined
2. Lets say capacity is 4. Node represents a node of DoublyLinkedList as follows: Head ->/<- firstNode ->/<- secondNode ->/<- thirdNode ->/<- fourthNode ->/<- Tail
3. On put operation:
    a. If capacity reached
        - Get tail.previous
        - and delete tailPrevious
    b.Else
        - map.put(k, node)
        - Add node as first node
4. On get operation
    a. Node node = map.get(key)
    b. delete node from DoublyLinked list and add to head.

**/

class LRUCacheImpl {
    
    private int capacity;
    private Map<Integer, Node> lruMap;
    private Node head;
    private Node tail;
    
    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
        
        lruMap = new HashMap<>(capacity);
        
        //Dummy head and tail be linked
        head = new Node();
        tail = new Node();
        
        //Bi-directional linking
        
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        int result = -1;
        
        Node resultNode = this.lruMap.get(key);
        
        if(resultNode!=null){
            //marking it as recently used
            deleteNode(resultNode);
            addToHead(resultNode);
            result = resultNode.value;
        }
        
        return result;
        
    }
    
    public void put(int key, int value) {
        Node nodeVal = this.lruMap.get(key);
        
        //If already exists value would be updated and moved next to head 
        if(nodeVal != null){ 
            nodeVal.setValue(value);
            deleteNode(nodeVal);
            addToHead(nodeVal);
        }else{
            //if capacity reached, delete last one from doubly linked list i.e. least recently used. Also, delete from map.
            if(this.lruMap.size() == capacity){
                this.lruMap.remove(this.tail.prev.key);
                deleteNode(this.tail.prev);
                
            }
            
            //add to map and linked list
            nodeVal = new Node(key, value);
            addToHead(nodeVal);
             this.lruMap.put(key, nodeVal);
            
        }
    }     
    
    private void deleteNode(Node node){
        // Getting previous and next nodes of current node
        Node prev = node.prev;
        Node next = node.next;
        
        //Delinking current node
        prev.next = next;
        next.prev = prev;
        
    }
    
    private void addToHead(Node node){
        Node headNext = this.head.next;
        
        this.head.next = node;
        node.prev = this.head;
        
        headNext.prev = node;
        node.next = headNext;
    }
}

class Node{
    Node prev;
    int key;
    int value;
    Node next;
    public Node(){}
    public Node(int key, int value){
        prev = null;
        this.key = key;
        this.value = value;
        next = null;
    }
    
    public void setValue(int value){
        this.value = value;
    }
}

public class LRUCache{
	public static void main(String args[]) {
		LRUCacheImpl lruCache = new LRUCacheImpl(2);
		
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		System.out.println(lruCache.get(1));
		lruCache.put(3, 3);
		System.out.println(lruCache.get(2));
		lruCache.put(4, 4);
		System.out.println(lruCache.get(1));
		System.out.println(lruCache.get(3));
		System.out.println(lruCache.get(4));
		
	}				
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */




