package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.entities.Dienthoai;

@Repository
public interface DienThoaiRepository extends JpaRepository<Dienthoai, Long> {
}
