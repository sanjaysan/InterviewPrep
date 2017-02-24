import java.util.HashMap;
import java.util.Map;

/**
 * Created by sanjay on 12/30/16.
 */

class Node
{
    int key;
    int value;
    Node prev;
    Node next;
    Node (int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}
public class LRUCache
{
    int capacity;
    HashMap <Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null, end = null;

    public LRUCache (int capacity)
    {
        this.capacity = capacity;
    }

    private void remove(Node n)
    {
        if (n.prev != null)
        {
            n.prev.next = n.next;
        }
        else
        {
            head = n.next;
        }

        if (n.next != null)
        {
            n.next.prev = n.prev;
        }
        else
        {
            end = n.prev;
        }
    }

    private void setHead(Node n)
    {
        n.next = head;
        n.prev = null;
        if (head != null)
        {
            head.prev = n;
        }
        head = n;
        if (end == null)
        {
            end = head;
        }
    }

    private void set(int key, int value)
    {
        if (map.containsKey(key))
        {
            Node old = map.get(key);
            if (old != null)
            {
                old.value = value;
            }
            if (head != null)
            {
                if (old != head)
                {
                    remove(old);
                    setHead(old);
                }
            }
            else
            {
                setHead(old);
            }

        }
        else
        {
            Node created = new Node(key, value);
            if (map.size() >= capacity)
            {
                map.remove(end.key);
                remove(end);
                setHead(created);
            }
            else
            {
                setHead(created);
            }
            map.put(key, created);
        }
    }

    private int getPage(int key)
    {
        if (map.containsKey(key))
        {
            Node n = map.get(key);
            if (n != null && n != head)
            {
                remove(n);
                setHead(n);
            }
            return n.value;
        }
        return -1;
    }

    private void printCache()
    {
        if (head != null)
        {
            Node temp = head;
            while (temp != null)
            {
                System.out.println("key: " + temp.key + " value: " + temp.value);
                temp = temp.next;
            }
        }
    }

    public static void main (String [] args)
    {
        LRUCache lruCache = new LRUCache(4);
        lruCache.set(1, 1);
        lruCache.set(1, 3);
        lruCache.set(2, 2);
        lruCache.set(4, 1);
        lruCache.set(5, 4);
        lruCache.set(6, 5);
        lruCache.printCache();
    }
}
