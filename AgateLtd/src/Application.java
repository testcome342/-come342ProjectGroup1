
import helper.Database;
import helper.PrintHelper;
import helper.ScanHelper;
import ui.AddNewAdvertToCampaignUI;
import ui.AddNewCampaignUI;
import ui.AddNewClientUI;
import ui.AddNewMemberStaffUI;
import ui.AssignStaffOnCampaignUI;

public class Application {

	public static void main(String[] args) {
		Database.init();
		int choice;
				
		while(true) {
			//Brand UI
			PrintHelper.printLine(49);
			PrintHelper.print("|                                               |");
			PrintHelper.print("|                   AGATE LTD                   |");
			PrintHelper.print("|                                               |");
			
			//Menu UI
			PrintHelper.printLine(49);
			PrintHelper.print("|     1- Add a new client                       |");
			PrintHelper.print("|     2- Add a new campaign                     |");
			PrintHelper.print("|     5- Assign staff to work on a campaign     |");
			PrintHelper.print("|     11- Add a new advert to a campaign        |");
			PrintHelper.print("|     12- Add a new member of staff             |");
			PrintHelper.print("|     999- Exit                                 |");
			PrintHelper.printLine(49);
			
			PrintHelper.print("Enter a number=> ", true);
			choice = ScanHelper.scanInt();
			PrintHelper.printLine(10);
			switch(choice) {
				
				case 1:
					AddNewClientUI.getInstance();
					break;
				case 2:
					AddNewCampaignUI.getInstance();
					break;
				case 5:
					AssignStaffOnCampaignUI.getInstance();
					break;
				case 11:
					AddNewAdvertToCampaignUI.getInstance();
					break;
				case 12:
					AddNewMemberStaffUI.getInstance();
					break;
				case 999:
					PrintHelper.print("exit");
					System.exit(0);
					break;
				default:
					PrintHelper.print("error, try enter a number");
					break;
			}
			PrintHelper.printRow(10);
		}
		
	}

}
