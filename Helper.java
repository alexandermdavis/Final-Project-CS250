import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

	Date currentDate = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	SimpleDateFormat clockFormat = new SimpleDateFormat("h:mm a z");
	
	protected String name;
	
	public Helper(String name) {
		this.name = name;
	}
	
	public void getTime() {
		System.out.println(dateFormat.format(currentDate));
		System.out.println(clockFormat.format(currentDate));
	}
}
