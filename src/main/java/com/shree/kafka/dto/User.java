package com.shree.kafka.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    @JsonIgnore
    private String address;
}
