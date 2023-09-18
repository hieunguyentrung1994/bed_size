package ra.securotyProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ra.securotyProject.model.domain.RoleOrder;
import ra.securotyProject.model.domain.RoleOrderName;

import java.util.Optional;

@Repository
public interface IRoleOrderRepository extends JpaRepository<RoleOrder,Long> {
    Optional<RoleOrder> findByRoleOrderName(RoleOrderName roleOrderName);
}
