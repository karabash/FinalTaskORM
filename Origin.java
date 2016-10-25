import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

@Entity
@Table(name="origin")

public class Origin extends CreateDeleteUpdateRead {
	static Scanner input = new Scanner(System.in);

	public void uppdate(Session session){

		Origin origin;
		System.out.println("Enter id");
		int id =input.nextInt();
		create();
		origin = session.get(Origin.class, id);
		origin.setCountry(country);
	}

	@Override
	public void create() {
		System.out.println("Enter country");
		setCountry(input.next());

	}


	@Override
	public String toString() {
		return "Origin [id="+ id+", country="+ country+"]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="id")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name="country")
	private String country;


}
