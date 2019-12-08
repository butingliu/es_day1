package com.baizhi.service;

import com.baizhi.dao.DepartmentDao;
import com.baizhi.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Department> queryAllDepa() {
        return departmentDao.selectAllDepa();
    }

    @Override
    public void insertDepartment(Department department) {
        departmentDao.addDepartment(department);
    }

    @Override
    public void removeDepatrment(Integer id) {
        departmentDao.deleteDepatrment(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Department queryDepartment(Integer id) {
        return departmentDao.selectDepartment(id);
    }

    @Override
    public void updatgeDepartmrnt(Department department) {
        departmentDao.modifyDepartmrnt(department);
    }
}
