package com.trieasenew.tripeasenew.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CabRequest
{
    private String cabNumber;
    private String cabModel;
    private double perKmRate;
}
