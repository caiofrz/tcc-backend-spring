package tcc.caioferraz.backendapi.domain.rooms;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_rooms")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Schema(description = "Room Model Information")
public class RoomModel {

  @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Room Uid", example = "86219ee6-aefc-4ed8-b59d-c0b5b3f1a3e3")
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID uid;

  @Column(unique = true, nullable = false)
  private String number;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private TypeRoomEnum type;

  @Column(nullable = false)
  private Integer bedQuantity;

  @Column(nullable = false)
  private String description;

  @Column(nullable = false)
  private BigDecimal dailyRate;

  @Column(nullable = false)
  private Boolean isOcuped;
}
