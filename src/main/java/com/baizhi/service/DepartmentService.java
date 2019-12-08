package com.baizhi.service;

import com.baizhi.entity.Department;

import java.util.List;

public interface DepartmentService {
    //查询所有部门
    List<Department> queryAllDepa();

    //添加部门
    void insertDepartment(Department department);

    //删除部门
    void removeDepatrment(Integer id);

    //查询一条部门
    Department queryDepartment(Integer id);

    //修改部门
    void updatgeDepartmrnt(Department department);
}
