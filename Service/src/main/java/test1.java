import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssh.entity.Person;
import com.ssh.service.PersonService;
@Controller
public class test1 {
	@Autowired
	private static PersonService PersonService ;
	
	public static void main(String[] args) {
		List<Person> plist = PersonService.findAll();
		
	       for (Person person : plist) {
	    	  System.out.println(person.getName());
		}
		
	}
}
