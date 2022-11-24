import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyLine extends MyShape {
	
	public MyLine(int x1, int y1, int x2, int y2, Color color) {
		super(x1,y1,x2,y2,color);
	}
	
	
	public boolean isSameSizeLine(MyShape ms1, MyShape ms2) {
		// dist((x1,y1),(x2,y2)) = sqrt((x1-x2)^2 + (y1-y2)^2)
		double lineLength1 = Math.sqrt(Math.pow((ms1.getX1() - ms1.getX2()), 2) + Math.pow((ms1.getY1() - ms1.getY2()), 2));
		double lineLength2 = Math.sqrt(Math.pow((ms2.getX1() - ms2.getX2()), 2) + Math.pow((ms2.getY1() - ms2.getY2()), 2));
		
		return lineLength1 == lineLength2;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (null == obj) return false;
        if (this == obj) return true;
        if (!(obj instanceof MyLine)) return false;
        MyLine that = (MyLine) obj;
        return isSameSizeLine(this, that);
        
    }
	
	public void drawShape(GraphicsContext gc) {
		gc.setStroke(this.getColor());
		gc.setLineWidth(1);
		gc.strokeLine(this.getX1(),this.getY1(),this.getX2(),this.getY2());
	}

}
