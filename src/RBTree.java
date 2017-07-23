
/**
 * Write a description of class RBTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RBTree
{
    // instance variables - replace the example below with your own
    private Node _root;
    private Node _max;
    private int _k;
    private int _numOfNodes;

    /**
     * Constructor for objects of class RBTree
     */
    public RBTree(int x)
    {
        Node empty=new Node();
        _root=empty;
        _max=empty;
        _k=x;
        _numOfNodes=0;
    }
    
       public Node getRoot()
    {
        return _root;
    }
    
       public Node getMax()
    {
        return _max;
    }
    
       public int getK()
    {
        return _k;
    }
    
       public int getNumOfNodes()
    {
        return _numOfNodes;
    }
    
    public void setK(int l) 
    {
        _k = l;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public Node search(Node root,int y)
    {
        if (root==null||y==root.getKey())
            return root;
        if (y<root.getKey())
            return search(root.getLeft(),y);
        else
            return search(root.getRight(),y);
    }

    public Node minimum(Node x)
    {
        while (x.getLeft().getKey()!=-1)
            x=x.getLeft();
        return x;
    }

    public Node maximum(Node x)
    {
        while (x.getRight().getKey()!=-1)
            x=x.getRight();
        return x;
    }

    public Node successor(Node x)
    {
        if (x.getRight().getKey()!=-1)
            return minimum(x.getRight());
        Node y=x.getP();
        while (y.getKey()!=-1&&x.equals(y.getRight()))
        {
            x=y;
            y=y.getP();
        }
        return y;
    }

    public Node predecessor(Node x)
    {
        if (x.getLeft().getKey()!=-1)
            return maximum(x.getRight());
        Node y=x.getP();
        while (y.getKey()!=-1&&x.equals(y.getLeft()))
        {
            x=y;
            y=y.getP();
        }
        return y;
    }

    private void leftRotate(RBTree T,Node x)
    {
        Node y=x.getRight();
        x.setRight(y.getLeft());
        if (y.getLeft().getKey()!=-1)
            y.getLeft().setP(x);
        y.setP(x.getP());    
        if (x.getP().getKey()==-1)
            T._root=y;
        else if (x.equals(x.getP().getLeft()))
            x.getP().setLeft(y);
        else
            x.getP().setRight(y);
        y.setLeft(x);
        x.setP(y);
    }

    private void rightRotate(RBTree T,Node x)
    {
        Node y=x.getLeft();
        x.setLeft(y.getRight());
        if (y.getRight().getKey()!=-1)
            y.getRight().setP(x);
        y.setP(x.getP());
        if (x.getP().getKey()==-1)
            T._root=y;
        else if (x.equals(x.getP().getRight()))
            x.getP().setRight(y);
        else
            x.getP().setLeft(y);
        y.setRight(x);
        x.setP(y);
    }
    
    public void insert(int x)
    {
        Node d= new Node(x);
        if (_numOfNodes<_k)
        {
            insert(this,d);
            _max=this.maximum(_root);
            _numOfNodes++;
        }
        else if(_numOfNodes>=_k&&d.getKey()<_max.getKey())
        {
            insert(this,d);
            delete(this,this._max);
            _max=this.maximum(this._root);
            _numOfNodes++;
        }
    }

    private void insert(RBTree T,Node z)
    {
        Node empty=new Node();
        Node y=empty;
        Node x=T._root;
        while(x.getKey()!=-1)
        {
            y=x;
            if (z.getKey()<x.getKey())
                x=x.getLeft();
            else
                x=x.getRight();
        }
        z.setP(y);
        if (y.getKey()==-1)
            T._root=z;
        else if(z.getKey()<y.getKey())
            y.setLeft(z);
        else
            y.setRight(z);
        z.setLeft(empty);
        z.setRight(empty);
        String s= new String("red");
        z.setColor(s);
        insertFixup(T,z);
    }

    private void insertFixup(RBTree T,Node z)
    {
        String b= new String("black");
        String r= new String("red");
        while (z.getP().getColor().equals(r))
        {
            if (z.getP().equals(z.getP().getP().getLeft()))
            {
                Node y;
                y=z.getP().getP().getRight();
                if (y.getColor().equals(r))
                {
                    z.getP().setColor(b);
                    y.setColor(b);
                    z.getP().getP().setColor(r);
                    z=z.getP().getP();
                }
                else if(z.equals(z.getP().getRight()))
                {
                    z=z.getP();
                    leftRotate(T,z);
                    z.getP().setColor(b);
                    z.getP().getP().setColor(r);
                    rightRotate(T,z.getP().getP());
                }
            }
            else
            {
                Node y;
                y=z.getP().getP().getLeft();
                if (y.getColor().equals(r))
                {
                    z.getP().setColor(b);
                    y.setColor(b);
                    z.getP().getP().setColor(r);
                    z=z.getP().getP();
                }
                else if(z.equals(z.getP().getLeft()))
                {
                    z=z.getP();
                    rightRotate(T,z);
                    z.getP().setColor(b);
                    z.getP().getP().setColor(r);
                    leftRotate(T,z.getP().getP());
                }
            }
        }
        T._root.setColor(b);
    }

    public Node delete(RBTree T, Node z)
    {
        String b= new String("black");
        Node y,x;
        if (z.getLeft().getKey()==-1||z.getRight().getKey()==-1) 
            y=z;
        else
            y=successor(z);
        if (y.getLeft().getKey()!=-1)
            x=y.getLeft();
        else
            x=y.getRight();
        x.setP(y.getP());
        if (y.getP().getKey()==-1)
            T._root=x;
        else if (y.equals(y.getP().getLeft()))
            y.getP().setLeft(x);
        else
            y.getP().setRight(x);
        if (!y.equals(z))
        {
            z.setKey(y.getKey());
            z.setRight(y.getRight());
            z.setLeft(y.getLeft());
        }
        if (y.getColor().equals(b))
            deleteFixup(T,x);
        return(y);
    }
    
    private void deleteFixup(RBTree T,Node x)
    {
        String b= new String("black");
        String r= new String("red");
        while (!x.equals(T._root)&&(x.getColor()).equals(b))
        {
            if (x.equals(x.getP().getLeft()))
            {
                Node w;
                w=x.getP().getRight();
                if (w.getColor().equals(r))
                {
                    w.setColor(b);
                    x.getP().setColor(r);
                    leftRotate(T,x.getP());
                    w=x.getP().getRight();
                }
                if (w.getLeft().getColor().equals(b)&&w.getRight().getColor().equals(b))
                {
                    w.setColor(r);
                    x=x.getP();
                }
                else if(w.getRight().getColor().equals(b))
                {
                    w.getLeft().setColor(b);
                    w.setColor(r);
                    rightRotate(T,w);
                    w=x.getP().getRight();
                    w.setColor(x.getP().getColor());
                    x.getP().setColor(b);
                    w.getRight().setColor(b);
                    leftRotate(T,x.getP());
                    x=T._root;
                }
            }
            else
            {
                 Node w;
                w=x.getP().getLeft();
                if (w.getColor().equals(r))
                {
                    w.setColor(b);
                    x.getP().setColor(r);
                    rightRotate(T,x.getP());
                    w=x.getP().getLeft();
                }
                if (w.getRight().getColor().equals(b)&&w.getLeft().getColor().equals(b))
                {
                    w.setColor(r);
                    x=x.getP();
                }
                else if(w.getLeft().getColor().equals(b))
                {
                    w.getRight().setColor(b);
                    w.setColor(r);
                    leftRotate(T,w);
                    w=x.getP().getLeft();
                    w.setColor(x.getP().getColor());
                    x.getP().setColor(b);
                    w.getLeft().setColor(b);
                    rightRotate(T,x.getP());
                    x=T._root;
                }
            }
        }
        x.setColor(b);
    }
    
    public void printkMin()
    {
         printkMin(this._root);
    }
    
    private void printkMin(Node x)
    {
        if (x.getKey()!=-1)
        {
            printkMin(x.getLeft());
            System.out.print(x.getKey() + ", ");
            printkMin(x.getRight());
        }
    }
}
