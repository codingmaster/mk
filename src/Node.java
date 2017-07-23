
/**
 * Write a description of class RBTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node
{
    // instance variables - replace the example below with your own
    private Node _left;
    private Node _right;
    private Node _p;
    private int _key;
    private String _color;

    /**
     * Constructor for objects of class RBTree
     */
    public Node(int x)
    {
        Node nil=new Node(); 
        _left=nil;
        _right=nil;
        _p=nil;
        _key=x;
        _color="black";
    }
    
    public Node()
    {
        _key=-1;
        _color="black";
    }

    public Node getLeft()
    {
        return _left;
    }

    public Node getRight()
    {
        return _right;
    }

    public Node getP()
    {
        return _p;
    }

    public int getKey()
    {
        return _key;
    }

    public String getColor()
    {
        return _color;
    }

    public void setLeft(Node l) 
    {
            _left = l;
    }

    public void setRight(Node r)
    {
            _right = r;
    }

    public void setP(Node p) 
    {
            _p = p;
    }
    
    public void setKey(int k) 
    {
        _key = k;
    }

    public void setColor(String c) 
    {
        _color = c;
    }
}
