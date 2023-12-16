package com.example.userservice.service;

import com.example.userservice.VO.Department;
import com.example.userservice.VO.ResponseTemplate;
import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    public ResponseTemplate getUserWithDepartment(Long userId) {
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject(
                "http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),
                Department.class);

        return new ResponseTemplate(user,department);

//        ResponseTemplate responseTemplate = new ResponseTemplate();
//        responseTemplate.setDepartment(department);
//        responseTemplate.setUser(user);

    }


    public User saveUser(User user) {
        LOGGER.info("UserService saveUser"+user);
        return userRepository.save(user);
    }
}
