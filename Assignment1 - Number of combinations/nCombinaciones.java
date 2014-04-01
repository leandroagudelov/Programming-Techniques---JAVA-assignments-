import java.io.*;
import java.util.Calendar;

/**
 * Write a description of class nCombinaciones here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class nCombinaciones
{
    
    public static long factorial (int n){
        long i;
	long r = 1;
	for(i = 1; i <= n; i++)
	{
		r = r * i;
	}
        if (r <0)
		return 1;
	return r;
    
    }
    public static long combinacionesFactorial (int n, int m){
 
        long factorialn =factorial(n);
	if (factorialn <= 0)
		return 1; 
	return ((factorialn)) / ((factorial(n-m)) * (factorial (m)));

    }
    
    public static long combinacionesPD (int n, int m, long tabla[][]){
        if (tabla [n][m]== 0.0)
            if (m==0||m==n){
                tabla [n][m] = 1;
            }
            else{
                if (m==1)
                    tabla [n][m]= n;
                else {
                    tabla [n][m] = combinacionesPD(n-1, m-1, tabla) + combinacionesPD(n-1, m , tabla);
                }
            }
        return tabla [n][m];
    }

    public static long combinacionesR (int n, int m){

            if (m==0||n==m)
                return 1;
            if (m==1)
                return n;
            else{
                return combinacionesR (n-1,m-1) + combinacionesR (n-1,m);
            }
            
        
        
    }
    
    /**

     * @param args

     */

    public static void main(String[] args)

    {
        long resultado = 0;
        long tiempo = 0;
        long tiempo1;
        long tiempo2;
        int n = 0;
        int m = 0;
        InputStreamReader isr = new InputStreamReader(System.in); 
		BufferedReader br = new BufferedReader(isr);
		try{
    		System.out.print("\n\n\n\nIntroduce el número de elementos distintos: ");
    		n = Integer.parseInt(br.readLine());
    		System.out.print("Introduce el orden de cada grupo de elementos: ");
    		m = Integer.parseInt(br.readLine());
        }
        catch (Exception e){
        }
        
        System.out.print("Ahora contabilizaremos cuanto tardan las tres maneras distlongas de calcular el resultado.\n");
        
        System.out.print("Primero calculando mediante la fórmula directamente, \nhaciendo uso de la definición de factorial.\n");
        
        tiempo1 = Calendar.getInstance().getTimeInMillis();
        resultado  = combinacionesFactorial (n, m);
        tiempo2 = Calendar.getInstance().getTimeInMillis();
        tiempo = tiempo2 - tiempo1;
        
        System.out.print("El resultado de esta operación es: " + resultado + " y ha tardado: " + tiempo  + " ms\n");
        
        System.out.print("Ahora lo calculamos utilizando recursividad.\n");
        
        tiempo1 = Calendar.getInstance().getTimeInMillis();
        resultado  = combinacionesR ( n, m);
        tiempo2 = Calendar.getInstance().getTimeInMillis();
        tiempo = tiempo2 - tiempo1;
        
        System.out.print("El resultado de esta operación es: " + resultado + " y ha tardado: " + tiempo + " ms");
        
        System.out.print("\nAhora añadimos a la recursividad programación dinámica.\n");
        
        tiempo1 = Calendar.getInstance().getTimeInMillis();
        resultado = combinacionesPD ( n, m, new long[n + 1][m + 1]);
        tiempo2 = Calendar.getInstance().getTimeInMillis();
        tiempo = tiempo2 - tiempo1;
        
        System.out.print("El resultado de esta operación es: " + resultado + " y ha tardado: " + tiempo + " ms\n");
        
    }
}
