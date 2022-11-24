import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class AppController {

    @FXML
    private Canvas canv;
    private GraphicsContext gc;
    private final int RANDOM_RANGE = 200;
    private final int CHANGE_POINT = 10;


    public void initialize() {
    	gc = canv.getGraphicsContext2D();
    	List<MyShape> shapeList =  createShapeList();
    	
    	for(MyShape ms: shapeList) {
    		ms.drawShape(gc);
    	}
    	
    	List<MyShape> cloneShapeList = cloneMyList(shapeList);
    	
    	changeList(cloneShapeList);
    	for(MyShape ms: cloneShapeList) {
    		ms.drawShape(gc);
    	}
    }
    
    public int getRandompoint() {
    	return (int)(Math.random() * RANDOM_RANGE);
    }
    
	public List<MyShape> createShapeList(){
		List<MyShape> shapeList = new ArrayList<>();
		
		MyShape line1 = new MyLine(getRandompoint(),getRandompoint(),getRandompoint(),getRandompoint(),Color.RED);
		shapeList.add(line1);
		MyShape line2 = new MyLine(getRandompoint(),getRandompoint(),getRandompoint(),getRandompoint(),Color.RED);
		shapeList.add(line2);
		
		MyShape oval1 = new MyOval(getRandompoint(),getRandompoint(),getRandompoint(),getRandompoint(),Color.RED, true);
		shapeList.add(oval1);
		MyShape oval2 = new MyOval(getRandompoint(),getRandompoint(),getRandompoint(),getRandompoint(),Color.RED, true);
		shapeList.add(oval2);


		MyShape rectangle1 = new MyRectangle(getRandompoint(),getRandompoint(),getRandompoint(),getRandompoint(),Color.RED, true);
		shapeList.add(rectangle1);
		MyShape rectangle2 = new MyRectangle(getRandompoint(),getRandompoint(),getRandompoint(),getRandompoint(),Color.RED, true);
		shapeList.add(rectangle2);

		return shapeList;
		
	}
	
	public List<MyShape> cloneMyList(List<MyShape> toClone){
		List<MyShape> shapeList = new ArrayList<>();
		for(MyShape ms: toClone) {
			try {
				shapeList.add((MyShape)ms.clone());
			} catch(CloneNotSupportedException e) {
				System.out.println("error");
			}
		}
		return shapeList;
	}
	
	public void changeList(List<MyShape> toChange){
		
		for(MyShape ms: toChange) {
			ms.setX1(ms.getX1()+ CHANGE_POINT);
			ms.setY1(ms.getY1()+ CHANGE_POINT);
			ms.setColor(Color.GREEN);
			if(ms instanceof MyBoundedShape) {
				((MyBoundedShape)ms).setFilling(false);
			}
		}
	}
}