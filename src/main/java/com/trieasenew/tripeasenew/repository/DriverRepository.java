package com.trieasenew.tripeasenew.repository;

import com.trieasenew.tripeasenew.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository  extends JpaRepository<Driver,Integer>
{


    @Query(value = "SELECT * FROM `driver table` where cab_id = :id",nativeQuery = true)
    Driver getDriverByCabId(@Param("id") int id);
    @Query(value = "SELECT * FROM `driver table` where age > :age",nativeQuery = true)
    List<Driver> findByAge(@Param("age")int age);

}
