package service;

public interface EmployeeService {

	boolean addEmployee();

	boolean deleteById(int id);



	boolean ModifyData(int id, String name, double sal, String add);

}
