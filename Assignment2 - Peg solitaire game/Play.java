import java.awt.event.*;

  public class Play implements ActionListener {
      private int estado = 0;
      private PegSolitarie solitario;
      private boolean resolviendo = false;
      private boolean isPlay = false;
      private miThread thread;

      /*
       * actionPerformed acción que realiza al escuchar
       *
       * @params ActionEvent recibe el evento
       */
        public void actionPerformed(ActionEvent e) {
        	if (!isPlay){
        		//Esto es lo que se hará al pulsar Play
        		isPlay = true;
        		resolviendo = true;
        		thread = new miThread();
        		thread.start();
        	}
        	else {
        		//Aquí cuando se pulse stop;
        		isPlay = false;
        	}
        }

       /*
        * getEstado getter del estado
        *
        * @return int estado que marca el reinicio de la partida
        */
        public int getEstado(){
            return this.estado;
        }

        /*
         * setEstado setter del estado de reinicio.
         *
         * @params int estado que tras iniciarse debería ser otro
         */
        public void setEstado(int estado){
            this.estado = estado;
        }
        public void resuelve(){
        	solitario = new PegSolitarie();
        }
    }

