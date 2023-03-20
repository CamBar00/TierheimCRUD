package com.SpringCrud.Tierheim.TierRepo;

import com.SpringCrud.Tierheim.entity.Tier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface TierRepo extends JpaRepository<Tier, Integer> {
}
