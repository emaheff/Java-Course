import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyOval extends MyBoundedShape {
	
	public MyOval(int x1, int y1, int x2, int y2, Color color, boolean filling) {
		super(x1,y1,x2,y2,color, filling);
	}
	
	public void drawShape(GraphicsContext gc) {
		if(this.isFilling()) {
	       	gc.setFill(this.getColor());
	       	gc.fillOval(this.getX1(),this.getY1(),this.getX2(),this.getY2());
		}else {
			gc.strokeOval(this.getX1(),this.getY1(),this.getX2(),this.getY2());
	    }
	}
	
	@Override
    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (this == obj) return true;
        if (!(obj instanceof MyLine)) return false;
        MyOval that = (MyOval) obj;
        return isSameBoundedShape(this, that);
        
    }
}