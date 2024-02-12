package tcc.caioferraz.backendapi.domain.rooms;

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
public class RoomModel {

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
