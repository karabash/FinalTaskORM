import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import org.hibernate.Session;

@Entity
@Table(name = "persons")

public class Person extends CreateDeleteUpdateRead{
	static Scanner input = new Scanner(System.in);

	@Override
	public void uppdate(Session session){
		Person person;
		System.out.println("Enter id");
		int id =input.nextInt();
		create();
		person = session.get(Person.class, id);
		person.setFname(getFname());
		person.setLname(getLname());
		person.setAge(getAge());
	}




	@Override
	public void create() {
		System.out.println("Enter name");
		setFname(input.next());
		System.out.println("Enter last name");
		setLname(input.next());
		System.out.println("Enter age");
		setAge(input.nextInt());		
		System.out.println("Enter a class number");
		setClassAtribute(input.nextInt());
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name ="id")
	private int id;

	@Column(name ="fname")
	private String fname;

	@Column(name ="lname")
	private String lname;


	@Column(name ="age")
	private int age;

	@Column(name ="class")
	private int classAtribute;








	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getClassAtribute() {
		return classAtribute;
	}




	public void setClassAtribute(int classAtribute) {
		this.classAtribute = classAtribute;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", fname=" + fname + ", lname="
				+ lname + ", age=" + age + ", class"+ classAtribute+ "]";
	}






}



