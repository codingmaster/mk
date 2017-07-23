
/**
 * Write a description of class Mink here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mink
{
    public Mink()
    {
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void mink(int[] A,int k,int n1, int n2, int n3)
    {
        RBTree T= new RBTree(k);
        int i=0;
        while(i<=n1)
        {
            T.insert(A[i]);
            i++;
        }
        T.printkMin();
        System.out.println();
        while(i<=n2)
        {
            T.insert(A[i]);
            i++;
        }
        T.printkMin();
        System.out.println();
        while(i<=n3)
        {
            T.insert(A[i]);
            i++;
        }
        T.printkMin();
        System.out.println();
    }
}
