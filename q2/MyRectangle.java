import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyRectangle extends MyBoundedShape {
	
	public MyRectangle(int x1, int y1, int x2, int y2, Color color, boolean filling) {
		super(x1,y1,x2,y2,color,filling);
	}
	
	public void drawShape(GraphicsContext gc) {
		if(this.isFilling()) {
        	gc.setFill(this.getColor());
        	gc.fillRect(this.getX1(),this.getY1(),this.getX2(),this.getY2());
        }else {
        	gc.strokeRect(this.getX1(),this.getY1(),this.getX2(),this.getY2());
        }
	}
	
	@Override
    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (this == obj) return true;
        if (!(obj instanceof MyRectangle)) return false;
        MyRectangle that = (MyRectangle) obj;
        return isSameBoundedShape(this, that);
    }
}