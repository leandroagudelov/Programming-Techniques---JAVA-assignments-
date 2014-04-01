import java.util.*;

public class Tablero

{
    private boolean tablero [][];
    
    Tablero()

    {

        // constructor del tablero, versión inglesa
        tablero = new boolean [7][7];
        //i para filas, j columnas
        //True para casilla con Peg y false casilla sin Peg
        for (int i = 0; i<tablero.length; i++){
            for (int j = 0; j<tablero.length; j++){
                if (fueraTablero(i,j)||(i==3&&j==3)){
                    tablero[i][j] = false;
                }
                else
                    tablero[i][j] = true;
            }
        }

    }

    // devuelve el número actual de pegs en el tablero

    public int numPegs() 

    {
        
        int numPegs = 0;
        for (int i = 0; i<tablero.length; i++){
            for (int j = 0; j<tablero.length; j++){
                if (tablero[i][j] == true)
                    numPegs++;
            }
        }
        return numPegs;
        
    }

    // devuelve true si el tablero está solucionado

    // un tablero solucionado es aquel que queda un solo peg

    // y está situado en el centro del tablero (tablero inglés).

    public boolean solucionado()

    {
        if (numPegs()==1&&tablero[3][3]==true)
            return true;
        return false;

    }

    // Determina si el movimiento “m” es legal en el tablero

    // Debe comprobar que existe un peg en el origen del movimiento

    // que casilla saltada existe un peg

    // que el movimiento es horizontal o vertical con salto de 2

    // y que hay hueco en el destino

    public boolean esMovimientoLegal(Movimiento m)

    {
        Casilla origen = m.getOrigen();        
        if (tablero[origen.getX()][origen.getY()]==false)
            return false;
        Casilla saltada = m.getSaltada();
        if (fueraTablero(saltada)){
            return false;
        }
        if (tablero[saltada.getX()][saltada.getY()]==false)
            return false;
        Casilla destino = m.getDestino();
        if (fueraTablero(destino)){
            return false;
        }
        if (tablero[destino.getX()][destino.getY()]==true)
            return false;
        return true;
        //Considero inútil comprobar la legalidad del movimiento ya que está limitado por la clase Movimiento, 
        //por lo que siempre será vertical u horizontal y de salto 2.

    }

    // Devuelve un array con los movimientos

    // legales del tablero

    public ArrayList<Movimiento> getMovimientos()

    {

        ArrayList<Movimiento> movs = new ArrayList<Movimiento>();
        Casilla casilla;
        Movimiento movimiento;
        for (int i = 0; i<tablero.length; i++){
            for (int j = 0; j<tablero.length; j++){
                if (tablero[i][j] == true){
                    casilla = new Casilla (i, j);
                    for (Direccion dir : Direccion.values()){
                        movimiento = new Movimiento (casilla, dir);
                        if (esMovimientoLegal (movimiento)){
                            movs.add(movimiento);
                        }
                    }
                }
            }
        }

        return movs;

    }

    // Realiza el movimiento “m” sobre el tablero si “m” es legal

    // Deja hueco en casilla origen e intermedio

    // pone un peg en destino

    public void hazMovimiento(Movimiento m)

    {

       if (!esMovimientoLegal(m))
           return;
       Casilla origen = m.getOrigen();
       Casilla destino = m.getDestino();
       Casilla saltada = m.getSaltada();
       tablero[origen.getX()][origen.getY()] = false;
       tablero[saltada.getX()][saltada.getY()] = false;
       tablero[destino.getX()][destino.getY()] = true;
      
    }

    // Realiza el inverso del movimiento “m” sobre el tablero

    // Deja hueco en casilla destino

    // pone un peg en destino e intermedio

    public void deshazMovimiento(Movimiento m)

    {
       Casilla origen = m.getOrigen();
       Casilla destino = m.getDestino();
       Casilla saltada = m.getSaltada();
       tablero[origen.getX()][origen.getY()] = true;
       tablero[saltada.getX()][saltada.getY()] = true;
       tablero[destino.getX()][destino.getY()] = false;
       
    }

    // Genera una representación única del tablero en forma de String
    
    //Pinta espacio cuando no pertenece una casilla al tablero, X cuando encuentra un peg y O cuando no lo hay.

    @Override

    public String toString()

    {
        String tableroString = "";
        for (int i = 0; i<tablero.length; i++){          
            for (int j = 0; j<tablero.length; j++){
                if (fueraTablero(i,j)){
                    tableroString += " ";
                }
                else {
                    if (tablero[i][j]==true)
                        tableroString += "X";
                    else 
                        tableroString += "O";
                }        
            }
        }
        return tableroString;
    }

    // Imprime por la salida standard el tablero

    // d representa el número de espacios que hay que dejar a la izquierda

    // de la representación

    public void print(int d)

    {
        String espacio = "";
        String tableroString = toString();
        for (int i = 1; i <= d; i++){
            espacio += " ";
        }
        for (int i = 0; i < tablero.length; i++){
            System.out.println (espacio + tableroString.substring(i*7, i*7 + 7));
        }
    }    
        
    //Comprueba si la casilla se encuentra fuera del tablero dado un objeto Casilla.
    public boolean fueraTablero (Casilla casilla){
        int i = casilla.getX();
        int j = casilla.getY();
        if ((i<2&&(j<2||j>4))||(i>4&&(j<2||j>4))||(i<0)||(i>6)||(j<0)||(j>6)){
                    return true;
        }
        return false;
    }
    
    //Comprueba si la casilla se encuentra fuera del tablero dadas las coordenadas.
    public boolean fueraTablero (int i, int j){
        if ((i<2&&(j<2||j>4))||(i>4&&(j<2||j>4))||(i<0)||(i>6)||(j<0)||(j>6)){
                    return true;
        }
        return false;
    }
}
