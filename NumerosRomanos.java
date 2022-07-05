import java.util.Scanner;

public class NumerosRomanos 
{
    public static void main (String[]args)
    {
        Scanner Sc= new Scanner (System.in);
        String opcion;

        do
        {
            System.out.print("Ingrese un numero del 1 al 5000: ");
            int num = Sc.nextInt( );
        
            if (num >=1 && num <= 5000)
            {
        
                int m = num/1000; //Millares
                int x2= num/100;

                int c= x2%10;//Centenas
                int y = num%100;

                int d=y/10; //Decenas

                int u=num%10; //Unidades


                //MILLARES
                if (m>0 && m<4) 
                {
                    for(int i=1 ;i<=m;i++)
                    {System.out.print('M');}
                }

                else if (m==4)
                { System.out.print("IVm");} //Para diferenciarlo de IV(4) le agregue la "m" de millar.

                else if(m==5)
                {System.out.print("Vm");}//Para diferenciarlo de V(5) le agregue la "m" de millar.
    

                //CENTENAS
                if (c>0 && c<4)
                {
                    for(int i=1; i<=c; i++)
                    {System.out.print("C");}
                }
                
                else if (c==4)
                {System.out.print("CD");}

                else if (c>=5 && c<6)
                {System.out.print("D");}
                
                else if(c>=6 && c<9)
                {
                    System.out.print("D");
                    for(int i=6;i<=c;i++)
                    {System.out.print("C");}
                }
                
                else if(c==9)
                {System.out.print("CM");}


                //DECENAS
                if (d>0 && d<4)
                {
                    for(int i=1; i<=d; i++)
                    {System.out.print("X");}
                }
                
                else if(d==4)
                {System.out.print("XL");}
                
                else if(d>=5 && d<9)
                {
                    System.out.print("L");
                    for(int j=6; j<=d; j++)
                    {System.out.print("X");}
                }

                else if(d==9)
                {System.out.print("XC");}


                //UNIDADES
                if (u>0 && u<4)
                {
                    for (int i=1; i<=u; i++) 
                    {System.out.print("I");}
                }

                else if (u==4)
                {System.out.print("IV");}

                else if (u>=5 && u<9)
                {
                    int t = u%5;
                    System.out.print("V");
                    for(int i=1; i<=t; i++) {System.out.print("I");}
                }

                else if (u==9)
                {System.out.print("IX");}

            }

            System.out.println("\nDeseas ingresar otro numero? S/N");
            opcion = Sc.next();
        }
        while("S".equals(opcion));
    }
}    
