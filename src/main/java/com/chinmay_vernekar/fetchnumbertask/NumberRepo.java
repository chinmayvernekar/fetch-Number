package com.chinmay_vernekar.fetchnumbertask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface NumberRepo extends JpaRepository<NumberModel,Integer> {

    NumberModel findByCategoryCode(Integer categoryCode);

    @Query("update NumberModel set value=:value where categoryCode=:categoryCode")
    @Modifying
    Integer updateValueByCategoryCode(Integer value,Integer categoryCode);


}
