package com.baizhi.controller;

import com.baizhi.entity.Department;
import com.baizhi.entity.Employees;
import com.baizhi.service.DepartmentService;
import com.baizhi.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("employees")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("showemployees")
    public String showemployees(Integer id, Integer currentPage, Integer pageSize, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (id == null || id.equals("")) {
            id = (Integer) session.getAttribute("id");
        }
        if (currentPage == null || currentPage.equals("")) {
            currentPage = 1;
        }
        pageSize = 2;
        Integer heihei = 0;
        if (currentPage > 0) {
            heihei = (currentPage - 1) * pageSize;
        }
        System.out.println(heihei);
        List<Employees> list = employeesService.queryByPage(heihei, pageSize, id);
        List<Employees> list1 = employeesService.queryByBid(id);
        int size = list1.size();
        int count = 0;
        if (size % 2 == 0) {
            count = size / pageSize;
        } else {
            count = size / pageSize + 1;
        }
        request.setAttribute("list", list);
        request.setAttribute("id", id);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("list1", list1);
        return "/ems/emp/emplist";
    }

    @RequestMapping("addemployees")
    public String addemployees(Employees employees, HttpServletRequest request) {
        employees.setId(null);
        Department d = departmentService.queryDepartment(employees.getDepartment().getId());
        employees.setDepartment(d);
        employeesService.insertEmployees(employees);
        HttpSession session = request.getSession();
        session.setAttribute("id", employees.getDepartment().getId());
        return "forward:/employees/showemployees";
    }

    @RequestMapping("updateemployees1")
    public String updateemployees1(Integer id, Model model) {
        Employees em = employeesService.queryEmployess(id);
        model.addAttribute("employees", em);
        return "/ems/emp/updateEmp";
    }

    @RequestMapping("updateemployees2")
    public String updateemployees2(Employees employees, HttpServletRequest request) {
        System.out.println(employees);
        HttpSession session = request.getSession();
        System.out.println(employees.getDepartment().getId());
        Department d = departmentService.queryDepartment(employees.getDepartment().getId());
        employees.setDepartment(d);
        System.out.println(employees);

        employeesService.updateEmployess(employees);
        session.setAttribute("id", employees.getDepartment().getId());
        return "redirect:/employees/showemployees";
    }

    @RequestMapping("deleteemployees")
    public String deleteemployees(Integer id) {
        employeesService.removeEmployees(id);
        return "redirect:/employees/showemployees";
    }

}
