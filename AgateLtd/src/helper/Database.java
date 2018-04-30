package helper;
import java.util.ArrayList;
import java.util.List;

import domain.Campaign;
import domain.Client;


public class Database {
	
	public static List<Client> clientList = new ArrayList<Client>();
	
	public static void init() {
		Client eti = new Client("ETI", "Mecidiyekoy/SISLI", "eti@eti.com.tr", "Ahmet Bey", "ahmet@eti.com.tr");
		Campaign eti_50inci_yil = new Campaign("ETI 50. YIL", "14.04.2018", "24.05.2018", 550000.0);
		eti.addNewCampaign(eti_50inci_yil);
		
		clientList.add(eti);
	}
}
