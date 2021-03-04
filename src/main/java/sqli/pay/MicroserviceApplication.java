package sqli.pay;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);

	}
	
	   /* public void run() {

			Admin a = new Admin(4000L, "manaleeeeee", "manal", "ffff", "hgyg", "7777");
			Admin s = AdminRepository.insert(a);
			System.out.println("hi id    " + s.getId());
	    }*/
}
