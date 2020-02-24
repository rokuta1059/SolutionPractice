import java.util.NoSuchElementException;
import java.util.Scanner;
 
class LinkedList {
    
    private static class Node {
        
        private int item;
        private int count;
        private Node next;
        
        private Node(int item) {
            this.item = item;
            count = 1;
        }
        
        private Node(int item, Node next) {
            this.item = item;
            count = 1;
            this.next = next;
        }
        
    }
    
    private Node head;
    private int size;
    private Node scanPos;
    
    public LinkedList() {
        head = null;
        size = 0;
        scanPos = null;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int getCount(int item) {
        Node s = search(item);
        if (s == null) {
            throw new NoSuchElementException("getCount()");
        }
        return s.count;
    }
    
    public void insert(int item) {
        if(head == null) {
            head = new Node(item);
            size++;
        }
        else if(search(item) != null) {
            search(item).count++;
        }
        else {
            Node newNode = new Node(item, head);
            head = newNode;
            size++;
        }
    }
    
    public Node search(int item) {
        if(isEmpty())
            throw new NoSuchElementException("search()");
        Node tmp = head;
        while(tmp != null) {
            if (tmp.item == item)
                return tmp;
            else
                tmp = tmp.next;
        }
        return null;
    }
    
    public int findBiggest() {
        if(isEmpty())
            throw new NoSuchElementException("findBiggest()");
        Node tmp = head;
        int biggestInt = 0;
        int biggestCount = 0;
        while(tmp != null) {
            if(tmp.count > biggestCount) {
                biggestInt = tmp.item;
                biggestCount = tmp.count;
            }
            else if(tmp.count == biggestCount) {
                biggestInt = tmp.item;
            }
            tmp = tmp.next;
        }
        return biggestInt;
    }
    
    public boolean remove(int item) {
        if(isEmpty())
            throw new NoSuchElementException("remove()");
        Node prev = null;
        Node curr = head;
        while(curr != null) {
            if(curr.item == item)
                break;
            else {
                prev = curr;
                curr = curr.next;
            }
        }
        if(curr == null)
            return false;
        else if (prev == null)
            head = head.next;
        else
            prev.next = curr.next;
        size--;
        return true;
    }
}

// LinkedList를 직접 구현하지 않고도 아래 코드를 실행할 수 있게 하는 게
// 더 좋을 것이라고 생각한다
 
public class W2_P2 {
 
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        
        LinkedList mush = new LinkedList();
        
        while(a.hasNextLine()) {
 
            String[] spl = a.nextLine().split(" ");
            
            int n = Integer.parseInt(spl[0]);
            int m = Integer.parseInt(spl[1]);
            
            String num = a.nextLine();
            
            for(String split : num.split(" ")) {
                int r = Integer.parseInt(split);
                if(r <= m)
                    mush.insert(r);
            }
            
            while(!mush.isEmpty()) {
                int t = mush.findBiggest();
                int k = mush.getCount(t);
                for (int i = 0; i < k; i++) {
                    System.out.print(t + " ");
                }
                mush.remove(t);
            }
            System.out.println();
        }
 
    }
 
}
