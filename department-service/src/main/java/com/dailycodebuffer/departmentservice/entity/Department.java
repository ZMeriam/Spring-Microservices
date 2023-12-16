package com.dailycodebuffer.departmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}