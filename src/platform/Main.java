package platform;

public class Main {

	public static void main(String[] args) throws Exception {
		Platform plataform = Platform.getInstance();
		Menu menu = Menu.getInstance();
		plataform.newBike();
		plataform.newBike();
		plataform.newBike();

		while (true) {
			menu.optionsMenu();
		}

	}

}
