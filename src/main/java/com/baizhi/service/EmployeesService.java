package com.baizhi.service;

import com.baizhi.entity.Employees;

import java.util.List;

public interface EmployeesService {
    //查询一条员工
    Employees queryEmployess(Integer id);

    //根据部门查询员工
    List<Employees> queryByBid(Integer bid);

    //根据id删除员工
    void removeEmployees(Integer id);

    //根据bid删除员工
    void removeEmployeesByBid(Integer bid);

    //修改员工
    void updateEmployess(Employees employees);

    //添加员工
    void insertEmployees(Employees employees);

    List<Employees> queryByPage(Integer currentPage, Integer pageSize, Integer bid);
}
