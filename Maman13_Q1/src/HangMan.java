import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class HangMan {
	
    // the method draw the hang man
	public void draw(int mistakes, GraphicsContext gc, double canvWidth, double canvHeigth) {
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(5);
		if(mistakes == 1) {
			gc.strokeLine((canvWidth/12), (canvHeigth/10*9), (canvWidth/12*3), (canvHeigth/10*9));
		}else if(mistakes == 2) {
			gc.strokeLine((canvWidth/12*2), (canvHeigth/10*9), (canvWidth/12*2), (canvHeigth/10));
		}else if(mistakes == 3) {
			gc.strokeLine((canvWidth/12), (canvHeigth/10), (canvWidth/12*10), (canvHeigth/10));
		}else if(mistakes == 4) {
			gc.strokeLine((canvWidth/12*7), (canvHeigth/10), (canvWidth/12*7), (canvHeigth/10*2));
		}else if(mistakes == 5) {
			gc.strokeOval((canvWidth/12*6), (canvHeigth/10*2), (canvWidth/12*2), (canvHeigth/10*2));
		}else if(mistakes == 6) {
			gc.strokeLine((canvWidth/12*7), (canvHeigth/10*4), (canvWidth/12*7), (canvHeigth/10*7));
		}else if(mistakes == 7) {
			gc.strokeLine((canvWidth/12*7), (canvHeigth/10*6), (canvWidth/12*6), (canvHeigth/10*5));
		}else if(mistakes == 8) {
			gc.strokeLine((canvWidth/12*7), (canvHeigth/10*6), (canvWidth/12*8), (canvHeigth/10*5));
		}else if(mistakes == 9) {
			gc.strokeLine((canvWidth/12*7), (canvHeigth/10*7), (canvWidth/12*6), (canvHeigth/10*8));
		}else if(mistakes == 10) {
			gc.strokeLine((canvWidth/12*7), (canvHeigth/10*7), (canvWidth/12*8), (canvHeigth/10*8));
		}
	}
}