package com.dailycodebuffer.departmentservice.service;

import com.dailycodebuffer.departmentservice.entity.Department;
import com.dailycodebuffer.departmentservice.exception.DepartmentNotFoundException;
import com.dailycodebuffer.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        log.info("DepartmentService saveDepartment method");
        return departmentRepository.save(department);
    }

    public Department fetchDepartmentById(Long departmentId) {
        LOGGER.info("DepartmentService fetchDepartmentById method");
        //return departmentRepository.findById(departmentId).orElseThrow(()->new DepartmentNotFoundException("this department does not exist"));
        return departmentRepository.findByDepartmentId(departmentId);


    }
}
