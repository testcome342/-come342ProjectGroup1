package helper;
import java.util.ArrayList;
import java.util.List;

import domain.AdminStaff;
import domain.Campaign;
import domain.Client;
import domain.CreativeStaff;
import domain.PosterAdvert;
import domain.StaffMember;

public class Database {
	
	/*
	 * Database
	 * including clientList and staffMemberList
	 * including init method
	 * */
	
	public static List<Client> clientList = new ArrayList<Client>();
	public static List<StaffMember> staffMemberList = new ArrayList<StaffMember>();
	
	public static void init() {
		
		/*
		 * Ready client, campaign, creative and admin staff
		 * and added staffMemberLit and clientList
		 * */
		
		CreativeStaff ahmet = new CreativeStaff(2,"Ahmet Dursun", "20.05.2017", "ahmet@gmail.com");
		CreativeStaff mehmet = new CreativeStaff(3,"Mehmet Dursun", "20.05.2017", "ahmet@gmail.com");
		CreativeStaff sami = new CreativeStaff(4,"Sami Dursun", "20.05.2017", "ahmet@gmail.com");
		CreativeStaff ugur = new CreativeStaff(5,"Ugur Dursun", "20.05.2017", "ahmet@gmail.com");
		AdminStaff hamdi = new AdminStaff(6,"Hamdi Dursun", "20.05.2017", "ahmet@gmail.com");
		
		staffMemberList.add(ahmet);
		staffMemberList.add(mehmet);
		staffMemberList.add(sami);
		staffMemberList.add(ugur);
		staffMemberList.add(hamdi);
		
		
		
		
		Client eti = new Client(1,"ETI", "Mecidiyekoy/SISLI", "eti@eti.com.tr", "Ahmet Bey", "ahmet@eti.com.tr");
		Campaign eti_50inci_yil = new Campaign("ETI 50. YIL", "14.04.2018", "24.05.2018", 550000.0);
		PosterAdvert posterAdvert = new PosterAdvert("POSTER ETI", "20.08.2018", 5000.0, 100000.0);
		
		eti_50inci_yil.addAdvert(posterAdvert);
		eti_50inci_yil.assignStaff(ugur);
		eti.addNewCampaign(eti_50inci_yil);
		
		clientList.add(eti);

	}  
	 
}
