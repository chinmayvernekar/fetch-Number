package com.chinmay_vernekar.fetchnumbertask;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepo extends JpaRepository<NumberModel,Integer> {

    NumberModel findByCategoryCode(Integer categoryCode);
}
