package tcc.caioferraz.backendapi.domain.rooms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoomsRepository extends JpaRepository<RoomModel, UUID> {


  boolean existsByNumber(String number);
}
