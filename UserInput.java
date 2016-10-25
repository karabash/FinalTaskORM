import java.util.Scanner;

public class UserInput {
	Scanner input = new Scanner(System.in);
	private String chooseTable;
	protected int intUserInput;
	private int choosenAltarnative;


	
	public void userInput() {
		System.out.println("Choose a table\n1)Cars\n2)Origin\n3)Person");
		intUserInput = input.nextInt();
		input.nextLine();
		if(intUserInput==1){
			setChooseTable("Car");

		}
		else if(intUserInput==2){
			setChooseTable("Origin");

		}
		else if(intUserInput==3){
			setChooseTable("Person");
		}
		else{
			System.out.println("There is not an altarnative as "+ intUserInput+"\nBye!");
			System.exit(0);
		}


	}
	
	public boolean quit(){
		boolean returnValue = true;
		System.out.println("Do you wanna quit\n1)Yes\n2)No");
		int  userChoosen = input.nextInt();
		if(userChoosen ==1){
			System.out.println("By!");
			returnValue = false;
		}
		else {
			return returnValue;
		}
		 return returnValue;
	}
	
	public int crud(){
		System.out.println("Choose a table\n1)Create\n2)Delete\n3)Search\n4)Uppdate");
		intUserInput = input.nextInt();
		if(intUserInput==1){
			setChoosenAltarnative(1);
			return getChoosenAltarnative();
		}
		else if(intUserInput==2){
			setChoosenAltarnative(2);
			return getChoosenAltarnative();
		}
		else if(intUserInput==3){
			setChoosenAltarnative(3);
			return getChoosenAltarnative();
		}
		else if(intUserInput==4){
			setChoosenAltarnative(4);
			return getChoosenAltarnative();
		}


		else{
			System.out.println("There is not an altarnative as "+ intUserInput+"\nBye!");
			System.exit(0);
		}
		return getChoosenAltarnative();


	}
	public String getChooseTable() {
		return chooseTable;
	}
	public void setChooseTable(String chooseTable) {
		this.chooseTable = chooseTable;
	}
	
	public int getChoosenAltarnative() {
		return choosenAltarnative;
	}
	public void setChoosenAltarnative(int choosenAltarnative) {
		this.choosenAltarnative = choosenAltarnative;
	}
		

}

