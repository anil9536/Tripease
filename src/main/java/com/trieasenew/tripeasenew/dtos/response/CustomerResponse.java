package com.trieasenew.tripeasenew.dtos.response;

import com.trieasenew.tripeasenew.enums.Gender;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {
    private String name;
    private int age;
    private String email;

}
