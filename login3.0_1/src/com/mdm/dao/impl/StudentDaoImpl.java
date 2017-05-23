package com.mdm.dao.impl;

import com.mdm.dao.StudentDao;
import com.mdm.entity.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Student initStudentInfo() {
		Student student=new Student();
		student.setName("Jok");
		student.setAge(18);
		student.setStuno("114jok");
		student.setScore(92);
		return student;
	}

}
