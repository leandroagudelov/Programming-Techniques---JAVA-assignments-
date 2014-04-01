
import java.util.*;

public class PegSolitarie

{
	HashSet<Movimiento> visitados;
	//Lo que hacía antes el método main ahora en el constructor.
	public PegSolitarie (){
		visitados = new HashSet<Movimiento>();

        Tablero t = new Tablero();

//       t.print(0);

        if (resuelve(t, visitados, 1))

        {

            System.out.println("Tablero resuelto");

//            t.print(0);

        }

        else

            System.out.println("Tablero NO resuelto");

//        t.print(0);
	}

   // private static int numEstados = 0, numVistos = 0;

    public static boolean resuelve(Tablero t, HashSet<Movimiento> visitados, int depth)
    {
	if (t.solucionado()) return true;

	ArrayList<Movimiento> movs= t.getMovimientos();
        for (Movimiento movimiento: movs){
                    if (t.esMovimientoLegal(movimiento)&&(!visitados.contains(movimiento))){
                        t.hazMovimiento(movimiento);                        
                            if(resuelve(t, visitados, depth + 1)){
                            	visitados.add(movimiento);
                                return true;
                            }
                        t.deshazMovimiento(movimiento);
                    }
        } 
        return false;                
    }

    /**

     * @param args

     */

//    public static void main(String[] args)
//
//    {
//
//        HashSet<Movimiento> visitados = new HashSet<Movimiento>();
//
//        Tablero t = new Tablero();
//
//        t.print(0);
//
//        if (resuelve(t, visitados, 1))
//
//        {
//
//            System.out.println("Tablero resuelto");
//
//            t.print(0);
//
//        }
//
//        else
//
//            System.out.println("Tablero NO resuelto");
//
//        t.print(0);
//
//       // System.out.println("Estados: " + numEstados + " Vistos: " + numVistos +
//
//         //   " fracción: " + (numVistos*100)/numEstados + "%");
//
//    }
    public HashSet<Movimiento> getMovimientos (){
    	return visitados;
    }
}
