/*
* 
* Author: Judith Fuog / Pascal Zaugg
* Matrikelnr.: 09-926-809 / 05-299-425
* Excercice 7-2
* Last modified: 17.12.2010
* 
*/

import java.util.EmptyStackException;

public class Stack {

  private class StackItem {
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