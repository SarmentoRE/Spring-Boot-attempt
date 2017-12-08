package service;

import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDAO;
import model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = this.employeeDAO.findEmployee(username);
		
		 if (employee == null) {
	            System.out.println("User not found! " + username);
	            throw new UsernameNotFoundException("User " + username + " was not found in the database");
	     }
		 
		 System.out.println("Found user: "+username);
		 
		 String role = employee.getRole();
		 
		 List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
         GrantedAuthority authority = new SimpleGrantedAuthority(role);
         grantList.add(authority);
         
         UserDetails userDetails = (UserDetails) new User(employee.getUsername(), employee.getPassword(), grantList);
         return userDetails;
	}
	
	
}
