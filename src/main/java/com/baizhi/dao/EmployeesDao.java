package com.baizhi.dao;

import com.baizhi.entity.Employees;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeesDao {
    //查询一条员工
    Employees selectEmployess(Integer id);

    //根据部门查询员工
    List<Employees> selectByBid(Integer bid);

    //根据id删除员工
    void deleteEmployees(Integer id);

    //根据bid删除员工
    void deleteEmployeesByBid(Integer bid);

    //修改员工
    void modifyEmployess(Employees employees);

    //添加员工
    void addEmployees(Employees employees);

    //根据页码查询数据
    List<Employees> selectByPage(
            @Param("currentPage") Integer currentPage,
            @Param("pageSize") Integer pageSize,
            @Param("bid") Integer bid);
}
