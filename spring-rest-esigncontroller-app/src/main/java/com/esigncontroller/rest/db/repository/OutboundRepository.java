package com.esigncontroller.rest.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esigncontroller.rest.db.entity.Outbound;

@Repository
public interface OutboundRepository extends JpaRepository<Outbound, Integer> {

	void save(Optional<Outbound> outBoundObject);
}
