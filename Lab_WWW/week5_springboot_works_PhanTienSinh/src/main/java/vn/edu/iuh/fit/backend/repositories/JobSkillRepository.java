package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.ids.JobSkillId;
import vn.edu.iuh.fit.backend.entities.JobSkill;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillId> {
}