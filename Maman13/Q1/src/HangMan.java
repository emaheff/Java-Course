import javax.swing.JOptionPane;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class HangMan {
	public void update(State state, GraphicsContext gc, double canvWidth, double canvHeigth) {
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		if(state.getMistakes() == 1) {
			gc.strokeLine((canvWidth/12), (canvHeigth/10*9), (canvWidth/12*3), (canvHeigth/10*9));
		}else if(state.getMistakes() == 2) {
			gc.strokeLine((canvWidth/12*2), (canvHeigth/10*9), (canvWidth/12*2), (canvHeigth/10));
		}else if(state.getMistakes() == 3) {
			gc.strokeLine((canvWidth/12), (canvHeigth/10), (canvWidth/12*10), (canvHeigth/10));
		}else if(state.getMistakes() == 4) {
			gc.strokeLine((canvWidth/12*7), (canvHeigth/10), (canvWidth/12*7), (canvHeigth/10*2));
		}else if(state.getMistakes() == 5) {
			gc.strokeOval((canvWidth/12*6), (canvHeigth/10*2), (canvWidth/12*2), (canvHeigth/10*2));
		}else if(state.getMistakes() == 6) {
			gc.strokeLine((canvWidth/12*7), (canvHeigth/10*4), (canvWidth/12*7), (canvHeigth/10*7));
		}else if(state.getMistakes() == 7) {
			gc.strokeLine((canvWidth/12*7), (canvHeigth/10*6), (canvWidth/12*6), (canvHeigth/10*5));
		}else if(state.getMistakes() == 8) {
			gc.strokeLine((canvWidth/12*7), (canvHeigth/10*6), (canvWidth/12*8), (canvHeigth/10*5));
		}else if(state.getMistakes() == 9) {
			gc.strokeLine((canvWidth/12*7), (canvHeigth/10*7), (canvWidth/12*6), (canvHeigth/10*8));
		}else if(state.getMistakes() == 10) {
			gc.strokeLine((canvWidth/12*7), (canvHeigth/10*7), (canvWidth/12*8), (canvHeigth/10*8));
			
			JOptionPane.showMessageDialog(null, "Game over!\nThe word was: " + state.getChoosenWord());
   		 	System.exit(0); // finish the program
   		 	
		}
	}
}
