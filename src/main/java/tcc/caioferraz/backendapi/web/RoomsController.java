package tcc.caioferraz.backendapi.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcc.caioferraz.backendapi.domain.rooms.RoomMapper;
import tcc.caioferraz.backendapi.domain.rooms.RoomModel;
import tcc.caioferraz.backendapi.domain.rooms.RoomsService;
import tcc.caioferraz.backendapi.dto.RoomDTO;

import java.util.UUID;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomsController {

  private final RoomsService service;
  private final RoomMapper mapper;

  @GetMapping
  public ResponseEntity<Page<RoomModel>> findAll(Pageable pageable) {
    return ResponseEntity.ok(this.service.findAll(pageable));
  }

  @GetMapping("/{uid}")
  public ResponseEntity<RoomModel> findOne(@PathVariable UUID uid) {
    return ResponseEntity.ok(this.service.findOne(uid));
  }

  @PostMapping
  public ResponseEntity<RoomModel> save(@Valid @RequestBody RoomDTO roomDTO) {
    RoomModel room = mapper.toEntity(roomDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(room));
  }

  @PutMapping("/{uid}")
  public ResponseEntity<RoomModel> update(@PathVariable UUID uid,
                                          @Valid @RequestBody RoomDTO roomDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.update(uid, roomDTO));
  }

  @DeleteMapping("/{uid}")
  public ResponseEntity<RoomModel> update(@PathVariable UUID uid) {
    this.service.delete(uid);
    return ResponseEntity.noContent().build();
  }
}
