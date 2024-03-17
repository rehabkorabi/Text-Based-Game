import java.util.ArrayList;

public class PortalGunFluid extends Item{

	public PortalGunFluid(ArrayList <Subject> subjects) {
		super("Portal Gun Fluid", subjects);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printDescription() {
		// TODO Auto-generated method stub
		UI.print("      _____\r\n"
				+ "     `.___,'\r\n"
				+ "      (___)\r\n"
				+ "      <   >\r\n"
				+ "       ) (\r\n"
				+ "      /`-.\\\r\n"
				+ "     /     \\\r\n"
				+ "    / _    _\\\r\n"
				+ "   :,' `-.' `:\r\n"
				+ "   |         |\r\n"
				+ "   :         ;\r\n"
				+ "    \\       /\r\n"
				+ "     `.___.' \r\n"
				+ "\r\n");
				
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

}
