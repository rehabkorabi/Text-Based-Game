import java.util.ArrayList;

public class Inventory 
{	
	ArrayList <Item> itemList;
	
	Inventory()
	{
		this.itemList= new ArrayList <Item> ();
	}
	
	public void addItem(Item item)
	{
		if(this.checkForItem(item)==-1) 
		{
			item.printDescription();
			itemList.add(item);
			UI.print(item.itemName + " has been added to your inventory...\n");
		}
		else {UI.print(" is already in your inventory!\n");}
		
	}

	public void dropItem(Item item)
	{
		if(!itemList.isEmpty()) 
		{
			int index = this.checkForItem(item);
			
			if(index!=-1) {
				
				itemList.remove(index);
				UI.print(item.itemName + " has been removed from your inventory...\n");
				}
			else {UI.print(item.itemName + " does not exist in your inventory!\n");}	
		}
		else {UI.print("Cannot remove items because your inventory is empty!\n");}
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
	
	public void checkInventory() {
		
		if(!itemList.isEmpty()) {
		UI.print("------------------------------------------\n"
				+ "Current Inventory:");
		for(int i=0; i<itemList.size(); i++) 
		{
			UI.print((i + 1) + ". " + itemList.get(i).itemName);
		}
		UI.print("------------------------------------------\n");
		}
		else 
		{
			UI.print("Inventory is still empty!");
		}
		
	}
	
	public void chooseAWeapon() 
	{
		if(!itemList.isEmpty()) {
			UI.print("------------------------------------------\n"
					+ "⚔ Current Weapons ⚔");
			int j=0;
			for(int i=0; i<itemList.size(); i++) 
			{
				if(itemList.get(i).itemName.equals("Sword")||itemList.get(i).itemName.equals("Plasma Gun")) 
				{
					UI.print((j + 1) + ". " + itemList.get(i).itemName);
					j++;
				}
			}
			UI.print("------------------------------------------\n");
			}
			else 
			{
				UI.print("No weapons in your inventory!");
			}
	}

}
