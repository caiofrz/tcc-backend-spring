package tcc.caioferraz.backendapi.domain.expenses;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_expenses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExpenseModel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID uid;

  @Column(nullable = false, length = 60)
  private String title;

  @Column(nullable = false)
  private BigDecimal amount;

  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private LocalDateTime date;

  @Column(nullable = false)
  private String description;
}
