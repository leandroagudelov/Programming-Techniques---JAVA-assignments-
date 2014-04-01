public class miThread extends Thread {
	private PegSolitarie solitario;
	// constructor
	public miThread () {
	}
	// redefinición del método run()
	public void run() {
		solitario = new PegSolitarie();
	}
	public PegSolitarie getSolitario(){
		return solitario;
	}
	
}


