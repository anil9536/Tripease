package com.trieasenew.tripeasenew.repository;

import com.trieasenew.tripeasenew.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepository extends JpaRepository<Cab,Integer> {

    @Query("select c from Cab c where c.cabAvailability = true order by rand() limit 1")
    Cab getAvailableCab();

}
