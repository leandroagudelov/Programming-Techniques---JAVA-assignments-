import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	
public class GUI extends JFrame{
	private JTextField eco;
	private JButton playPause;
	private JSlider slider;
	private int timer;
	public GUI() {
		setTitle("SOlitario");
		JComponent botonera = creaBotonera();
		// Crea panel con botonera
		JSplitPane panelPrincipal = new JSplitPane(JSplitPane.VERTICAL_SPLIT,botonera,eco);
		// Añade el panel a la ventana principal
		getContentPane().add(panelPrincipal);
		// Se 'redimensiona' toda la interfaz gráfica en la ventana
		pack();
		// Y hace visible la ventana, con sus componentes
		setVisible(true);
	}
	private JComponent creaBotonera() {
		JPanel botonera = new JPanel(); 
		// Se crean los botones ...
		playPause = new JButton("Play");
		// .. y se añaden al panel
		playPause.addActionListener((ActionListener) this);
		botonera.add(playPause, BorderLayout.NORTH);
		slider = new JSlider();
		slider.setMajorTickSpacing(20);
	    slider.setMinorTickSpacing(5);
		botonera.add(slider, BorderLayout.SOUTH);
		return botonera;
	}
	private JComponent creaEco() {
		// Se crea el campo de texto donde poner el eco
		eco = new JTextField("Pulsa un botón");
		return eco;
	}
	public void cambiaBoton(){
		if (playPause.getText().equalsIgnoreCase("play"))
			playPause.setText("Stop");
		else 
			playPause.setText("Play");
	}
	public boolean isBotonPlay(){
		if (playPause.getText().equalsIgnoreCase("play"))
			return true;
		else
			return false;
	}
	public int getTimer(){
		return timer;
	}
	private void pulsadoPlay(){
		
	}
	public void actionPerformed(ActionEvent e) {
		if (isBotonPlay()){
			cambiaBoton();
			
		}
		else{
			cambiaBoton();
		}
	}
}

