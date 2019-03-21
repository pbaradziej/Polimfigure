
package polimfigury;

/**
 *
 * @author PawelB
 */

import java.util.Scanner;

class Figura
{
    public double obliczPole() { return 0; }
    public double obliczObwod() { return 0; }    
}
 
class Kwadrat extends Figura
{
    public Kwadrat( double bok )
    {
        this.bok = bok;
    }
 
    public Kwadrat()
    {
        this( 0 );
    }
   
    private double bok;
 
    public double podajBok()
    {
        return bok;
    }
 
    public void ustawBok(double bok)
    {
        this.bok = bok;
    }
    public double obliczPole()
    {
        return bok * bok;
    }
    public double obliczObwod()
    {
        return 4 * bok;
    }
}
 
class Kolo extends Figura
{
    public Kolo( double r )
    {
        this.r = r;
    }
 
    public Kolo()
    {
        this( 0 );
    }
   
    private double r;
 
    public double podajR()
    {
        return r;
    }
 
    public void ustawR(double r)
    {
        this.r = r;
    }
    public double obliczPole()
    {
        return r * r * Math.PI;
    }
    public double obliczObwod()
    {
        return 2 * Math.PI * r;
    }
}
 
class FabrykaFigur
{
    Figura utworzFigure( int jakaFigura )
    {
        switch( jakaFigura )
        {
            case 1  : return new Kwadrat();
            case 2  : return new Kolo();
            default : return null;
        }
    }    
}
class KalkulatorFigurIO
{
    Scanner we = new Scanner(System.in);
    int ustalRodzajFigury()
    {
        System.out.print( "\n1. Kwadrat\n2. Kolo\n3. Koniec\n>> " );
        return we.nextInt();        
    }
    void wyprowadzInformacje( double pole, double obwod )
    {
        System.out.printf( "\nPole figury: %f", pole );
        System.out.printf( "\nObwód figury: %f", obwod );
    }
    void ustalParametryFigury( Figura figura )
    {
        if( figura instanceof Kwadrat )
        {
            System.out.print( "\nBok: ");
            double bok = we.nextDouble();
            ( ( Kwadrat ) figura ).ustawBok(bok);  
        }
       
        if( figura instanceof Kolo )
        {
            System.out.print( "\nPromień: ");
            double r = we.nextDouble();
            ( ( Kolo ) figura ).ustawR(r);  
        }
    }
}
 
class  KalkulatorFigur
{
   
    void oblicz( FabrykaFigur fabryka, KalkulatorFigurIO io  )
    {
        Figura figura;
               
        figura = fabryka.utworzFigure( io.ustalRodzajFigury() );
        if( figura != null )
        {
            io.ustalParametryFigury( figura );
            io.wyprowadzInformacje( figura.obliczPole(), figura.obliczObwod() );            
        }
    }
}
public class Polimfigury
{
   
    public static void main(String[] args)
    {
        KalkulatorFigur kalk = new KalkulatorFigur();
        kalk.oblicz( new FabrykaFigur(), new KalkulatorFigurIO() );
       
//        Scanner we = new Scanner(System.in);
//        System.out.print( "\n1. Kwadrat\n2. Kolo\n3. Koniec\n>> " );
//        int jakaFigura = we.nextInt();
//        switch( jakaFigura )
//        {
//            case 1 : Kwadrat kw = new Kwadrat();
//                     System.out.print( "\nBok: ");
//                     double bok = we.nextDouble();
//                     kw.ustawBok(bok);
//                     System.out.print( "\nPole: " + kw.obliczPole());
//                     System.out.print( "\nObwod: " + kw.obliczObwod());
//                     break;
//            case 2 : Kolo ko = new Kolo();
//                     System.out.print( "\nPromien: ");
//                     double r = we.nextDouble();
//                     ko.ustawR(r);
//                     System.out.print( "\nPole: " + ko.obliczPole());
//                     System.out.print( "\nObwod: " + ko.obliczObwod());
//                     break;
//        }
    }
   
}
