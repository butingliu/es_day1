package com.baizhi.controller;

import com.baizhi.entity.Department;
import com.baizhi.service.DepartmentService;
import com.baizhi.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("department")
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeesService employeesService;

    @RequestMapping("showdepartment")
    public String showdepartment(HttpServletRequest request) {
        System.out.println("嘿嘿");
        List<Department> list = departmentService.queryAllDepa();
        for (Department d : list) {
            System.out.println(d);
        }
        request.setAttribute("list", list);
        return "/ems/dept/deptlist";
    }

    @RequestMapping("adddepartment")
    public String addDepartment(Department department) {
        department.setId(null);
        departmentService.insertDepartment(department);
        return "redirect:/department/showdepartment";
    }

    @RequestMapping("deletedepartment")
    public String deletedepartment(Integer id) {

        if (id != null || id.equals("")) {
            employeesService.removeEmployeesByBid(id);
        }
        departmentService.removeDepatrment(id);
        return "redirect:/department/showdepartment";
    }

    @RequestMapping("updatedepartment1")
    public String updatedepartment1(Integer id, HttpServletRequest request) {
        Department department = departmentService.queryDepartment(id);
        request.setAttribute("department", department);
        return "/ems/dept/updateDept";
    }

    @RequestMapping("updatedepartment2")
    public String updatedepartment2(Department department) {
        departmentService.updatgeDepartmrnt(department);
        return "redirect:/department/showdepartment";
    }

    @RequestMapping("departmentjson")
    @ResponseBody
    public List<Department> departmentjson() {
        return departmentService.queryAllDepa();
    }
}
