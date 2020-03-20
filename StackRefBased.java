public class StackRefBased<T> implements Stack<T> {
	private StackNode<T> top;
	int count;

    public StackRefBased() {
    	top = null;
    	count = 0;
    }

    public int size() {
        return count;
    }


    public boolean isEmpty() {
        if(top == null){
        	return true;
        }
        else{
        	return false;
        }
    }


    public void push(T data) {
        StackNode<T> temp = top;
        top = new StackNode<T>(data);
        top.next = temp;
        count++;
    }


    public T pop() throws StackEmptyException {
    	if(this.isEmpty()){
    		throw new StackEmptyException("Empty stack.");
    	}
    	else{
        	T item = top.data;
        	top = top.next;
        	count--;
        	return item;
        }
    }


    public T peek() throws StackEmptyException {
        if(isEmpty()){
        	throw new StackEmptyException("Empty stack.");
        }
        else{
        	return top.data;
        }
    }


    public void makeEmpty() {
    	while(top != null){
    		top = null;
    	}
    	count = 0;
    }


    public String toString() {
        StackNode<T> temp = top;
        String s = "";
        while(temp != null){
        	s += temp.data;
        	if(temp.next != null){
        		s += " ";
        	}
        	temp = temp.next;
        }
        return s;
    }
}

