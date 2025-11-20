package beans;

import java.util.Objects;

public class Employee {
	private int eid;
	private String name;
	private double sal;
	private String add;
	
	

	@Override
	public boolean equals(Object obj) {
		
		Employee other = (Employee) obj;
		return eid == other.eid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public Employee(int eid, String name, double sal, String add) {
		super();
		this.eid = eid;
		this.name = name;
		this.sal = sal;
		this.add = add;
	}
	
	public Employee() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", sal=" + sal + ", add=" + add + "]";
	}
	
	
}
