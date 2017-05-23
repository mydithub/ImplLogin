package com.mdm.dao;

import com.mdm.entity.Student;

public interface StudentDao {

	/**
	 * 初始化学生信息
	 * @return Student对象
	 */
	public Student initStudentInfo();
}
