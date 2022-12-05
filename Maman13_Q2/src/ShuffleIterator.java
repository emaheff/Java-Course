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
	// the method returns a random element from the list and remove it.
	@Override
	public E next() {
		int index = getRandomIndex();		
		return elements.remove(index);
	}
	
	// the method return random index from a given list.
	private int getRandomIndex() {
		return (int)(Math.random() * elements.size());
	}
}
