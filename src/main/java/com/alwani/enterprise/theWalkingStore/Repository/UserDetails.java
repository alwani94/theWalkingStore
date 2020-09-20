package com.alwani.enterprise.theWalkingStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alwani.enterprise.theWalkingStore.bean.Partner;

@Repository
public interface UserDetails extends JpaRepository<Partner, Integer>,UserDetailsCustom {}

