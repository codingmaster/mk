
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Random;
public class Test
{
    
    public static void main(String[] args)
    {
        Mink k=new Mink();
        Random r=new Random();
        int[] A= new int[200], B=new int[400],C= new int[800];
        int a=0, b=0, c=0;
        while(a<200)
        {
            A[a]=r.nextInt(1000000);
            a++;
        }
        while(b<400)
        {
            B[b]=r.nextInt(1000000);
            b++;
        }
        while(c<800)
        {
            C[c]=r.nextInt(1000000);
            c++;
        }
        k.mink(A,10,50,100,150);
        k.mink(A,50,50,100,150);
        k.mink(A,100,50,100,150);
        k.mink(B,10,100,200,300);
        k.mink(B,50,100,200,300);
        k.mink(B,100,100,200,300);
        k.mink(C,10,200,400,600);
        k.mink(C,50,200,400,600);
        k.mink(C,100,200,400,600);
    }
}