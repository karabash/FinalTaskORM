
import java.util.Scanner;

public class UserInput {
	Scanner input = new Scanner(System.in);
	private String chooseTable;
	protected int intUserInput;
	private int choosenAltarnative;
	int car = myEnum.Car.getValue();
	int origin = myEnum.ORIGIN.getValue();
	int person = myEnum.PERSON.getValue();
	final String carStr = "Car";
	final String originStr = "Origin";
	final String personStr = "Origin";
	final int create =1;
	final int delete =2;
	final int search =3;
	final int update =4;
	final int yes =1;

	//	String carStr = myEnum.Car.toString();



	public void userInput() {
		System.out.println("Choose a table\n1)Cars\n2)Origin\n3)Person");
		intUserInput = input.nextInt();
		input.nextLine();
		if(intUserInput==car){
			setChooseTable(carStr);

		}
		else if(intUserInput==origin){
			setChooseTable(originStr);

		}
		else if(intUserInput==person){
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
		if(userChoosen ==yes){
			System.out.println("By!");
			returnValue = false;
		}
		else {
			return returnValue;
		}
		return returnValue;
	}

	public int crud(){
		System.out.println("Choose an altarnative\n1)Create\n2)Delete\n3)Search\n4)Uppdate");
		intUserInput = input.nextInt();
		if(intUserInput==create){
			setChoosenAltarnative(create);
			return getChoosenAltarnative();
		}
		else if(intUserInput==delete){
			setChoosenAltarnative(delete);
			return getChoosenAltarnative();
		}
		else if(intUserInput==search){
			setChoosenAltarnative(search);
			return getChoosenAltarnative();
		}
		else if(intUserInput==update){
			setChoosenAltarnative(update);
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

