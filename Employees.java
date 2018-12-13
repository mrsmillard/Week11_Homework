package edu.dmacc.coma502;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.LinkedList;

import edu.dmacc.coma502.provided.Employee;
import edu.dmacc.coma502.provided.SearchResult;

public class Employees {
	private ArrayList<Employee> employees;
		
	public Employees(List<Employee> list) {
		this.employees = new ArrayList<>(list);
	}

	public List<Employee> getEmployees() {
		final List<Employee> copyOfList;
		copyOfList = new ArrayList<>(employees);
		return copyOfList;
	}

	public void addEmployee(Employee newEmployee) {
		employees.add(newEmployee);
		
	}

	public List<Employee> querySalaryGreaterThan(double salary) {
		List<Employee> highEarners = new ArrayList<>();
		for(Employee employee: employees) {
			if (employee.salary > salary) {
				highEarners.add(employee);
			}
		}
		return highEarners;
	}

	public SearchResult<Employee> findEmployeeById(String id) {
		for(Employee employee: employees) {
			if(employee.id.equals(id)) {
				return SearchResult.of(employee);
			}
		}
		return SearchResult.none();
	}

	public boolean updateSalary(String employeeId, double newSalary) {
		for (Employee employee : employees) {
			if (employee.id.equals(employeeId)) {
				int i = employees.indexOf(employee);
				if(i == -1) { 
					return false;
				}	
				Employee oldEmployee = employees.get(i);
				Employee newEmployee = new Employee(
							employeeId,
							oldEmployee.name,
							oldEmployee.department,
							newSalary);
					employees.set(i, newEmployee);
					return true;
			}
		}
		return false;
	}

	public List<Employee> findEmployeeByName(String employeeName) {
		List<Employee> returnedList = new ArrayList<Employee>();
		for(Employee employee: employees) {
			if(employee.name.equals(employeeName)) {
				returnedList.add(employee);
			}
		}
		return returnedList;
	}

	public List<Employee> findEmployeeByPartialName(String pattern) {
		List<Employee> returnedList = new ArrayList<Employee>();
		for(Employee employee: employees) {
			if(employee.name.contains(pattern)) {
				returnedList.add(employee);
			}
		}
		return returnedList;
	}

	public boolean removeEmployee(String employeeId) {
		ListIterator<Employee> iter = employees.listIterator();
		while( iter.hasNext()) {
			if(iter.next().id.equals(employeeId)) {
				iter.remove();
				return true;
			}
		}
		return false;
	}

	public boolean removeEmployee(Employee employee) {
		String employeeId = employee.id;
		ListIterator<Employee> iter = employees.listIterator();
		while(iter.hasNext()) {
			if(iter.next().id.equals(employeeId)) {
				iter.remove();
				return true;
			}
		}
		return false;
	}
}
