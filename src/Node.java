
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
    //REVIEW: What is _p? Is this a parent? Why don't call it parent?
    private Node _p;
    private int _key;
    private String _color;

    /**
     * Constructor for objects of class RBTree
     */
    public Node(int x)
    {
        //REVIEW: Why is this node nil? Is this a
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
	
	@Override
	public String toString()
	{
		String result = "";
		String node = "(node: " + _key + ", " + _color + ")";
		result += node;
		if(_left != null && _left.getKey() != -1){
			result = "<left: " + _left + "> \t" + result;
		}
		if(_right != null && _right.getKey() != -1){
			result = result + " \t{right: " + _right + "}\n";
		}
		return result;
	}
}
