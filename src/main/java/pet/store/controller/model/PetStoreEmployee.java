package pet.store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Employee;

@Data
@NoArgsConstructor 
public class PetStoreEmployee {
	//@Id
	//@GeneratedValue
	private int employeeId;
	
	//@Id
	//@GeneratedValue
	//private int petStoreId;
	
	private String employeeFirstName;
	private String employeeLastName;
	private String employeePhone;
	private String employeeJobTitle;
	
	public void PetStoreEmployee(Employee e) {
		
	}
}
