package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	static Connection con=null;
	static PreparedStatement insertQuery,deleteQuery,updateQuery;
	
	
	static {

		try {
			con=DaoDataBase.getConnection();
			 insertQuery=con.prepareStatement("INSERT INTO employee (id, name, salary, address) VALUES (?, ?, ?, ?)");
			 deleteQuery=con.prepareStatement("DELETE FROM employee WHERE id = ?");
			 updateQuery = con.prepareStatement( "UPDATE employee SET name = ?, salary = ?, address = ? WHERE id = ?");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	
	}
	
	

    @Override
    public boolean addEmployee(Employee e) {
    	
        
        try         
        {
        	insertQuery.setInt(1, e.getEid());
        	insertQuery.setString(2, e.getName());
        	insertQuery.setDouble(3, e.getSal());
        	insertQuery.setString(4, e.getAdd());

            int n = insertQuery.executeUpdate();
            return n > 0;

        } 
        catch (SQLException ex) {
        	
            ex.printStackTrace();
            
        }
        return false;
    }

    
    @Override
    public boolean deleteById(int id) {
//        String sql = "DELETE FROM employee WHERE id = ?";
        try 
        {

        	deleteQuery.setInt(1, id);
            int n = deleteQuery.executeUpdate();
            return n > 0;

        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }




	@Override
	public boolean ModifyData(int id, String name, double sal, String add) {
		try {
			updateQuery.setInt(1, id);
        	updateQuery.setString(2, name);
        	updateQuery.setDouble(3, sal);
        	updateQuery.setString(4, add);
        	
        	int n=updateQuery.executeUpdate();
        	return n > 0;
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return false;
	}
}
