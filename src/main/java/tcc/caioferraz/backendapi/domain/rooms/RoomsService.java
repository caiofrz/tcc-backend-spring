package tcc.caioferraz.backendapi.domain.rooms;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tcc.caioferraz.backendapi.domain.rooms.exceptions.RoomAlreadyCreatedException;
import tcc.caioferraz.backendapi.domain.rooms.exceptions.RoomNotFoundException;
import tcc.caioferraz.backendapi.dto.RoomDTO;

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

  @Transactional
  public RoomModel save(RoomModel room) {
    if (this.repository.existsByNumber(room.getNumber())) {
      throw new RoomAlreadyCreatedException("O quarto " + room.getNumber() + " já existe!");
    }
    room.setIsOcuped(false);
    return this.repository.save(room);
  }

  @Transactional
  public RoomModel update(UUID uid, RoomDTO roomDTO) {
    RoomModel room = this.find(uid);
    BeanUtils.copyProperties(roomDTO, room);
    return this.repository.save(room);
  }

  @Transactional
  public void delete(UUID uid) {
    RoomModel room = this.find(uid);
    if (room.getIsOcuped())
      throw new DataIntegrityViolationException("Este quarto não pode ser excluído pois está vinculadoa uma hospedadem");
    this.repository.deleteById(uid);
  }

  private RoomModel find(UUID uid) {
    return this.repository.findById(uid)
            .orElseThrow(() -> new RoomNotFoundException("Quarto não encontrado!"));
  }
}
