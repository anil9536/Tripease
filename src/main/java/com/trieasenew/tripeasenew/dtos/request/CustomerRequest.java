package com.trieasenew.tripeasenew.dtos.request;

import com.trieasenew.tripeasenew.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest
{
    private String name;
    private int age;
    private String email;
    private Gender gender;
}
