package com.alayam.core;

public class Employee {

	int _id;
	String _firstName;
	String _lastName;

	
	Employee(int id, String firstName, String lastName){
		_id = id;
		_firstName = firstName;
		_lastName = lastName;
	}

	
	
	//@Override	
	public boolean equals(Employee other) {
		
		if (!_firstName.equals(other._firstName)) {
			return false;
		}
			
			
		return true;
		
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_firstName == null) ? 0 : _firstName.hashCode());
		result = prime * result + _id;
		result = prime * result
				+ ((_lastName == null) ? 0 : _lastName.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (_firstName == null) {
			if (other._firstName != null)
				return false;
		} else if (!_firstName.equals(other._firstName))
			return false;
		if (_id != other._id)
			return false;
		if (_lastName == null) {
			if (other._lastName != null)
				return false;
		} else if (!_lastName.equals(other._lastName))
			return false;
		return true;
	}
	
	
}
