package com.trieasenew.tripeasenew.service;

import com.trieasenew.tripeasenew.dtos.request.CabRequest;
import com.trieasenew.tripeasenew.dtos.response.CabResponse;
import org.springframework.stereotype.Service;

@Service
public interface CabService {
    CabResponse registerCab(CabRequest cabRequest, int id);
}
