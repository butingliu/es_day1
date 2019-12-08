package com.baizhi.dao;

import com.baizhi.entity.Department;

import java.util.List;

public interface DepartmentDao {
    //查询所有部门
    List<Department> selectAllDepa();

    //添加部门
    void addDepartment(Department department);

    //删除部门
    void deleteDepatrment(Integer id);

    //查询一条部门
    Department selectDepartment(Integer id);

    //修改部门
    void modifyDepartmrnt(Department department);
}
