package ra.securotyProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.securotyProject.model.domain.OrderDetail;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Long> {
//    @Query("select od from OrderDetail od where od.product = :productId and od.user = :userId and od.color = :color")
//    OrderDetail findByProductAndUserAndColor(Long productId, Long userId,Long color);

    OrderDetail findByProductAndUserAndColor(Long productId, Long userId,Long colorId);

}
