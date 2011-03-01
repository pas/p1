import java.util.ArrayList;

// Braucht es ein Handling, wenn beispielsweise null übergeben wird anstatt ein String. Oder z.B. neg. Zahl?

public class testEmployeeList {
	  public static void main(String args[]) {
		  Employee putzfachassistent = new Employee("Guiseppe Lambda", 2400);
		  Manager nichtstunabervielverdiener = new Manager("Hans Meier", 1000000, "Businessreiseprechecking");
		  EmployeeList liste = new EmployeeList(putzfachassistent, nichtstunabervielverdiener);
		  System.out.println(liste);
	  }	
}

class EmployeeList {
	protected ArrayList<Employee> members = new ArrayList<Employee>();

	public EmployeeList (Employee ... toAdd) {
		for (int i=0; i<toAdd.length; i++) {
			members.add(toAdd[i]);
		}
	}
	
	public String toString() {
		String string = "";
		for(Employee member: members) {
			string = string + member + "\n";
		}
		return string;
	}
}

class Employee {
	protected String name;
	protected int salary;
	
	public Employee (String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	// Soll hier das DecimalFormat gebraucht werden?
	
	public String toString() {
		return (name + " owns " + salary + " sFr. per month");
	}
}

class Manager extends Employee {
	protected String departement;
	
	public Manager (String name, int salary, String departement) {
	  super(name, salary);
	  this.departement = departement;
	}
	
	public String toString() {
	  return (super.toString() + " and works in departement " + departement);
	}
}
