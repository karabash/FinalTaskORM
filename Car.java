
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import org.hibernate.Session;


@Entity
@Table(name = "cars")

public  class Car extends CreateDeleteUpdateRead {
	static Scanner input = new Scanner(System.in);

	@Override
	public void create() {
		System.out.println("Enter model");
		setModel(input.next());
		System.out.println("Enter produced place");
		setProduced_place(input.nextInt());
		System.out.println("Enter owner");
		setOwner(input.nextInt());		
	}



	public void uppdate(Session session){
		Car car;
		System.out.println("enter an id number");
		int id = input.nextInt();
		create();
		car = session.get(Car.class, id);
		car.setModel(getModel());
		car.setOwner(getOwner());
		car.setProduced_place(getProduced_place());

	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name ="id")
	private int id;

	@Column(name ="model")
	private String model;

	@Column(name ="produced_place")
	private int produced_place;


	@Column(name ="owner")
	private int owner;




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getProduced_place() {
		return produced_place;
	}

	public void setProduced_place(int produced_place) {
		this.produced_place = produced_place;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", model= " + model + ",produced_place ="
				+ produced_place + "owner "+owner  + "]";
	}




}



