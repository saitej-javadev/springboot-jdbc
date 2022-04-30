package com.saitej.springbootjdbc.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    private int id;
    private  String first_name;
    private String last_name;
    private String email;
}
