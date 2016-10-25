
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Run{

	public  Run() throws ClassNotFoundException {
		UserInput user = new UserInput();
		SessionFactory factory = null;
		Session session;
		Car car =  new Car();
		Person person = new Person();
		Origin origin = new Origin();
		
		boolean check = true;

		final String strCar = "Car";
		final int CREATE = 1;
		final int DELETE = 2;
		final int SEARCH = 3;
		final int UPDATE = 4;

		try{		
			//create  car object

			while(check){
				user.userInput();
				user.crud();

				// create session factory(reads the hibarnCateonfig file)
				factory = new Configuration().configure("hb.xml").addAnnotatedClass(Class.forName(user.getChooseTable())).buildSessionFactory();

				//create session
				session = factory.getCurrentSession();

				session.beginTransaction();
				//CREATE
				if(user.getChooseTable().equals(strCar) && user.getChoosenAltarnative()==CREATE){

					car.create();
					session.save(car);
					car.read(user.getChooseTable(), session);
					check =  user.quit();
				}

				else if(user.getChooseTable().equals("Person") && user.getChoosenAltarnative()==CREATE){
					person.create();
					session.save(person);
					person.read(user.getChooseTable(), session);
					check =  user.quit();
				}

				else if(user.getChooseTable().equals("Origin") && user.getChoosenAltarnative()==CREATE){
					origin.create();
					session.save(origin);
					origin.read(user.getChooseTable(), session);
					check =  user.quit();
				}

				// DELETE
				else	if(user.getChooseTable().equals("Car") && user.getChoosenAltarnative()==DELETE){
					car.read(user.getChooseTable(), session);

					session.clear();
					int getDelValue	= car.delete();
					car.setId(getDelValue);
					session.delete(car);
					car.read(user.getChooseTable(), session);
					check =  user.quit();

				}

				else	if(user.getChooseTable().equals("Origin") && user.getChoosenAltarnative()==DELETE){
					origin.read(user.getChooseTable(), session);

					session.clear();
					int getDelValue	= car.delete();
					origin.setId(getDelValue);
					session.delete(origin);
					origin.read(user.getChooseTable(), session);
					check =  user.quit();

				}

				else	if(user.getChooseTable().equals("Person") && user.getChoosenAltarnative()==DELETE){
					person.read(user.getChooseTable(), session);

					session.clear();
					int getDelValue	= person.delete();
					person.setId(getDelValue);
					session.delete(person);
					person.read(user.getChooseTable(), session);
					check =  user.quit();


				}
				//SEARCH
				else	if(user.getChooseTable().equals("Car") && user.getChoosenAltarnative()==SEARCH){
					car.search(session,  " Car " );
					check =  user.quit();


				}

				else	if(user.getChooseTable().equals("Origin") && user.getChoosenAltarnative()==SEARCH){
					origin.search(session, " Origin " );
					check =  user.quit();


				}


				else	if(user.getChooseTable().equals("Person") && user.getChoosenAltarnative()==SEARCH){
					person.search(session, " Person ");
					check =  user.quit();


				}

				//UPDATE
				else	if(user.getChooseTable().equals("Car") && user.getChoosenAltarnative()==UPDATE){
					car.read(user.getChooseTable(), session);
					car.uppdate(session);
					check =  user.quit();
					car.read(user.getChooseTable(), session);

				}


				else	if(user.getChooseTable().equals("Origin") && user.getChoosenAltarnative()==UPDATE){
					origin.read(user.getChooseTable(), session);
					origin.uppdate(session);
					origin.read(user.getChooseTable(), session);
					check =  user.quit();

				}


				else	if(user.getChooseTable().equals("Person") && user.getChoosenAltarnative()==UPDATE){
					person.read(user.getChooseTable(), session);
					person.uppdate(session);
					check =  user.quit();
					person.read(user.getChooseTable(), session);
				}
				// commit transaction
				session.getTransaction().commit();
			}
		}

		finally{
			factory.close();

		}
	}


}


