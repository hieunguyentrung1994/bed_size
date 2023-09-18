package ra.securotyProject.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatagoryResponse {
    private Long id;
    private String catagoryName;
    private boolean status;
}
