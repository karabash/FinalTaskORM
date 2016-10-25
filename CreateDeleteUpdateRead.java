
import java.util.Collection;
import java.util.List;
import java.util.Scanner;










import org.hibernate.Session;
import org.hibernate.type.descriptor.java.UUIDTypeDescriptor.ToStringTransformer;
public abstract class CreateDeleteUpdateRead {
	int IdNumber;
	static Scanner sc = new Scanner(System.in);
	public abstract void create();

	public  int delete(){
		System.out.println("Enter an id");
		IdNumber = sc.nextInt();
		System.out.println("you entered "+IdNumber);
		return IdNumber;
	}

	public abstract void uppdate(Session session);
	
	@SuppressWarnings({ "rawtypes" })
	public void read(String className, Session session ) throws ClassNotFoundException {
		Collection temp = session.createQuery("from "+className).list();
		for(Object o : temp){
			System.out.println(o.toString());
		}
	}


	public void search( Session session, String className) {
		List<?> list = null;
		char c;
		do {
			System.out.println("Enter a character");
			c = sc.next().charAt(0);
		} while (!Character.isLetter(c));	

		if(className.equalsIgnoreCase(" Car ")) {
			list = session.createQuery("FROM "+ className+"  WHERE model LIKE '%"+c+"%'").list();
		}

		else if(className.equalsIgnoreCase(" Person ")){
			list = session.createQuery("FROM "+ className+"  WHERE fname LIKE '%"+c+"%'"+" OR "+ "lname LIKE '%"+c+"%'").list();
		}
		
		else if(className.equalsIgnoreCase(" Origin ")){
			list = session.createQuery("FROM "+ className+"  WHERE country LIKE '%"+c+"%'").list();
		}

		for(Object o: list){
			System.out.println(o);
		}
	}	

	public abstract String toString();
	
	public int getIdNumber() {
		return IdNumber;
	}

	public void setIdNumber(int idNumber) {
		IdNumber = idNumber;
	}
}
