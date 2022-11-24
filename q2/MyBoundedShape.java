import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class  MyBoundedShape extends MyShape {
	private boolean filling;
	
	public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean filling) {
		super(x1,y1,x2,y2,color);
		this.filling = filling;
	}
	
	
	public abstract void drawShape(GraphicsContext gc);
	
	
	public boolean isSameBoundedShape(MyShape ms1, MyShape ms2) {
		return Math.abs(ms1.getX1() - ms1.getX2()) == Math.abs(ms2.getX1() - ms2.getX2())
			&& Math.abs(ms1.getY1() - ms1.getY2()) == Math.abs(ms2.getY1() - ms2.getY2());
	}
	
	public boolean isFilling(){
		return filling;
	}
	
	public void setFilling(boolean filling) {
		this.filling  = filling;
	}
}