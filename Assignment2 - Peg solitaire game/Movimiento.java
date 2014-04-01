public class Movimiento {

    private Casilla origen;

    private Direccion dir;
    
    public Movimiento(Casilla origen, Direccion dir)

    {

        this.origen = origen;

        this.dir = dir;

    }

    public Casilla getOrigen()

    {

        return origen;

    }

    public Direccion getDir()

    {

        return dir;

    }

    // devuelve la casilla destino del movimiento

    public Casilla getDestino()

    {
            int x, y;
            switch (dir){
                case NORTE:
                    y = origen.getY() + 2;
                    x = origen.getX();
                    break;
                case SUR:
                    y = origen.getY() - 2;
                    x = origen.getX();
                    break;
                case ESTE:
                    y = origen.getY();
                    x = origen.getX() + 2;
                    break;
                case OESTE:
                    y = origen.getY();
                    x = origen.getX() - 2;
                    break;
                default: 
                    x = origen.getX();
                    y = origen.getY();
                    break;
            }
            Casilla destino = new Casilla (x, y);
        

        return destino;

    }

    // devuelve la casilla sobre la que saltaría el PEG al moverse

    public Casilla getSaltada()

    {
            int x, y;
            switch (dir){
                case NORTE:
                    y = origen.getY() + 1;
                    x = origen.getX();
                    break;
                case SUR:
                    y = origen.getY() - 1;
                    x = origen.getX();
                    break;
                case ESTE:
                    y = origen.getY();
                    x = origen.getX() + 1;
                    break;
                case OESTE:
                    y = origen.getY();
                    x = origen.getX() - 1;
                    break;
                default: 
                    x = origen.getX();
                    y = origen.getY();
                    break;
            }
            Casilla saltada = new Casilla (x, y);
        

        return saltada;
    }

}
