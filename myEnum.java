
public enum myEnum{
	Car(1), ORIGIN(2),PERSON(3);

	
	int value;
	private myEnum(int n){
		this.value = n;
	}
	
	public int getValue(){
		return this.value;
	}
}