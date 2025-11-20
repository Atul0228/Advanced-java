package dao;

import beans.Employee;

public interface EmployeeDao {

	boolean addEmployee(Employee e);



	boolean deleteById(int id);



	boolean ModifyData(int id, String name, double sal, String add);

}
