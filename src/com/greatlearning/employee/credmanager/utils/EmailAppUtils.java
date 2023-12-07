package com.greatlearning.employee.credmanager.utils;

public class EmailAppUtils {

	public static boolean validateDepartmentCode(
		int departmentCode) {
		
		if (departmentCode >=1 && departmentCode <=4) {
			return true;
		}else {
			return false;
		}
	}
}