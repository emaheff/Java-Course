import java.util.Iterator;
import java.util.List;

public class ShuffleIterator<E> implements Iterator<E>{
	
	private List<E> elements; 

	public ShuffleIterator (List<E> elements) {
		this.elements = elements;
	}
	
	@Override
	public boolean hasNext() {
		return !elements.isEmpty();
	}

	@Override
	public E next() {
		int index = getRandomIndex();		
		return elements.remove(index);
	}
	
	private int getRandomIndex() {
		return (int)(Math.random() * elements.size());
	}
}
