import java.util.ArrayList;

public abstract class Item extends ConcreteObserver implements Use{

	String itemName;

    public Item(String itemName, ArrayList <Subject> subjects){
        super(subjects);
    	this.itemName = itemName;
    }
        
    public abstract void printDescription();

    public abstract void use();
    
}
