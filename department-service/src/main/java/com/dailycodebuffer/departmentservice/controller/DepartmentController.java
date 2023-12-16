package com.dailycodebuffer.departmentservice.controller;

import com.dailycodebuffer.departmentservice.entity.Department;
import com.dailycodebuffer.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j//simple logging facade for java
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("DepartmentController saveDepartment method");
        return departmentService.saveDepartment(department);

    }
    @GetMapping("/{departmentId}")
    public Department fetchDepartmentById(@PathVariable Long departmentId){
        log.info("DepartmentController fetchDepartmentById method");
        return departmentService.fetchDepartmentById(departmentId);
    }
}
