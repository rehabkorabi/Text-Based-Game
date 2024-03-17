import java.util.ArrayList;

public class MagicBox {

ArrayList <Item> itemList;

	MagicBox()
	{
		this.itemList= new ArrayList <Item> ();
	}
	
	public void addItem(Item item)
	{
		itemList.add(item);
	}

	public void dropItem(Item item)
	{
		if(!itemList.isEmpty()) 
		{
			int index = this.checkForItem(item);
			
			if(index!=-1) {
				
				itemList.remove(index);
				UI.print(item.itemName + " has been removed from the magic box\n");
				}
		}
		else {UI.print("Cannot remove any more items because the box is empty!\n");}
	}
	
	public int checkForItem(Item item) {
		int index = -1;
		for(int i=0; i<itemList.size(); i++) 
		{
			if(itemList.get(i).itemName.equals(item.itemName)) 
			{
				index = i;
			}
		}
		return index;
	}
	
	public void checkMagicBox() {
		
		if(!itemList.isEmpty()) {
		UI.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
				+ "✨ Magic Box ✨");
		for(int i=0; i<itemList.size(); i++) 
		{
			UI.print((i + 1) + ". " + itemList.get(i).itemName);
		}
		UI.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		}
		else 
		{
			UI.print("Magic Box is empty!\n"
					+ "You already took all the items :)\n");
		}
		
	}
	
}
