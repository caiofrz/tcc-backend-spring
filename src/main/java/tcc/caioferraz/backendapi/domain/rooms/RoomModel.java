package tcc.caioferraz.backendapi.domain.rooms;

import jakarta.persistence.*;
import lombok.*;

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

  @Column(unique = true, nullable = false)
  @Enumerated(EnumType.STRING)
  private TypeRoomEnum type;

  @Column(unique = true, nullable = false)
  private Integer bedQuantity;

  @Column(unique = true, nullable = false)
  private String description;

  @Column(unique = true, nullable = false)
  private Double dailyRate;

  @Column(unique = true, nullable = false)
  private Boolean isOcuped;
}
