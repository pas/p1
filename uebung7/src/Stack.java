import java.util.EmptyStackException;

/* Programmierung 1 HS 2010 Aufgabe 7-2 */

public class Stack {
  
  StackItem lastItem = null;
	
  public void push (Object o) {
	  lastItem = new StackItem(o, lastItem);
  }

  public Object pop() throws EmptyStackException {
	 if (lastItem == null) throw new EmptyStackException();
	 Object object = lastItem.object();
	 lastItem = lastItem.reference();
	 return(object); 
  }
 
  public String toString() {
	  String string = "";
	  StackItem item = lastItem;
	  while (item != null) {
		  string = string + " " + item.object;
		  item = item.reference();
	  }
	  return string;
  }
}

class StackItem {
	Object object;
	StackItem nextStackItem;
	
	public StackItem(Object o, StackItem stackItem) {
	  nextStackItem = stackItem;
	  object = o;
	}
	
	public Object object() {
	  return object;
	}
	
	public StackItem reference() {
	  return nextStackItem;
	}
}