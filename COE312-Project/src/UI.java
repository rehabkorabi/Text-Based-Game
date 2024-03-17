
public class UI extends ConcreteSubject implements Runnable{

	Message m;

	UI()
	{	
		Thread t = new Thread(this);
		t.start();
	}


	public static synchronized void print(String str) 
	{
		System.out.println(str);
	}

	public static synchronized void printSequentially(String text) {

		int i;
		for(i = 0; i < text.length(); i++){
			System.out.print(text.charAt(i));
			try{
				Thread.sleep(15);//0.015s pause between characters
			}catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
		}
	}


	@Override
	public void run()
	{
		UserInput input = new UserInput();
		while(true) 
		{
			m = new Message(this, "UI", input.read());
			publishMessage(m);
		}
	}

}