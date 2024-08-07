package com.live.backend.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.live.backend.models.Jobs;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long> {
}
