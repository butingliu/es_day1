package com.baizhi.service;

import com.baizhi.dao.EmployeesDao;
import com.baizhi.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeesServiceImpl implements EmployeesService {
    @Autowired
    private EmployeesDao employeesDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Employees queryEmployess(Integer id) {
        return employeesDao.selectEmployess(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Employees> queryByBid(Integer bid) {
        return employeesDao.selectByBid(bid);
    }

    @Override
    public void removeEmployees(Integer id) {
        employeesDao.deleteEmployees(id);
    }

    @Override
    public void removeEmployeesByBid(Integer bid) {
        employeesDao.deleteEmployeesByBid(bid);
    }

    @Override
    public void updateEmployess(Employees employees) {
        employeesDao.modifyEmployess(employees);
    }

    @Override
    public void insertEmployees(Employees employees) {
        employeesDao.addEmployees(employees);
    }

    @Override
    public List<Employees> queryByPage(Integer currentPage, Integer pageSize, Integer bid) {
        return employeesDao.selectByPage(currentPage, pageSize, bid);
    }
}
