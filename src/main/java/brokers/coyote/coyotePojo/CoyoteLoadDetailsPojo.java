package brokers.coyote.coyotePojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoyoteLoadDetailsPojo {
   private CoyoteEquipmentPojo equipment;
   private String mode;

}
