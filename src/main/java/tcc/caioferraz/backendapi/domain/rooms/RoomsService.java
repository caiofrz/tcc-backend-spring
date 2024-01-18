package tcc.caioferraz.backendapi.domain.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tcc.caioferraz.backendapi.domain.rooms.exceptions.RoomAlreadyCreatedException;
import tcc.caioferraz.backendapi.domain.rooms.exceptions.RoomNotFoundException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomsService {

  private final RoomsRepository repository;

  public Page<RoomModel> findAll(Pageable pageable) {
    return this.repository.findAll(pageable);
  }

  public RoomModel findOne(UUID uid) {
    return this.find(uid);
  }

  private RoomModel find(UUID uid) {
    return this.repository.findById(uid)
            .orElseThrow(() -> new RoomNotFoundException("Quarto não encontrado!"));
  }

  public RoomModel save(RoomModel room) {
    if (this.repository.existsByNumber(room.getNumber())) {
      throw new RoomAlreadyCreatedException("O quarto " + room.getNumber() + " já existe!");
    }

    return this.repository.save(room);
  }
}
