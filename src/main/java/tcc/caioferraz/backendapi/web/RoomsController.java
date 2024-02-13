package tcc.caioferraz.backendapi.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcc.caioferraz.backendapi.domain.rooms.RoomMapper;
import tcc.caioferraz.backendapi.domain.rooms.RoomModel;
import tcc.caioferraz.backendapi.domain.rooms.RoomsService;
import tcc.caioferraz.backendapi.dto.PageResponseDTO;
import tcc.caioferraz.backendapi.dto.RoomDTO;
import tcc.caioferraz.backendapi.shared.exception.ErrorResponse;

import java.util.UUID;

@RestController
@RequestMapping("/rooms")
@Tag(name = "Rooms", description = "Resources API Endpoints for Rooms")
@CrossOrigin
@RequiredArgsConstructor
public class RoomsController {

  private final RoomsService service;
  private final RoomMapper mapper;


  @Operation(
          summary = "Retrieve a paginated list of rooms",
          tags = {"Rooms"})
  @ApiResponses({
          @ApiResponse(responseCode = "200",
                  content = {@Content(
                          schema = @Schema(implementation = PageResponseDTO.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "401",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "403",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "500",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
  })
  @Parameters({
          @Parameter(name = "page", description = "Page number, starting with 0"),
          @Parameter(name = "size", description = "Number of items per page"),
  })
  @GetMapping
  public ResponseEntity<PageResponseDTO> findAll(Pageable pageable) {
    return ResponseEntity.ok(this.service.findAll(pageable));
  }

  @Operation(
          summary = "Retrieve a specific room by uid",
          tags = {"Rooms"})
  @ApiResponses({
          @ApiResponse(responseCode = "200",
                  content = {@Content(
                          schema = @Schema(implementation = RoomModel.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "401",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "403",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "404",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "500",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
  })
  @GetMapping("/{uid}")
  public ResponseEntity<RoomModel> findOne(@PathVariable UUID uid) {
    return ResponseEntity.ok(this.service.findOne(uid));
  }

  @Operation(
          summary = "Create a new room",
          tags = {"Rooms"})
  @ApiResponses({
          @ApiResponse(responseCode = "201",
                  content = {@Content(
                          schema = @Schema(implementation = RoomModel.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "400",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "401",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "403",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "409",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "500",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
  })
  @PostMapping
  public ResponseEntity<RoomModel> save(@Valid @RequestBody RoomDTO roomDTO) {
    RoomModel room = mapper.toEntity(roomDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(room));
  }

  @Operation(
          summary = "Update a room by uid",
          tags = {"Rooms"})
  @ApiResponses({
          @ApiResponse(responseCode = "201",
                  content = {@Content(
                          schema = @Schema(implementation = RoomModel.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "400",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "401",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "403",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "404",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "409",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "500",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
  })
  @PutMapping("/{uid}")
  public ResponseEntity<RoomModel> update(@PathVariable UUID uid,
                                          @Valid @RequestBody RoomDTO roomDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.update(uid, roomDTO));
  }

  @Operation(
          summary = "Delete a room by uid",
          tags = {"Rooms"})
  @ApiResponses({
          @ApiResponse(responseCode = "204",
                  content = {@Content(
                          schema = @Schema(implementation = RoomModel.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "400",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "401",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "403",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "404",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "409",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
          @ApiResponse(responseCode = "500",
                  content = {@Content(
                          schema = @Schema(implementation = ErrorResponse.class),
                          mediaType = "application/json")}),
  })
  @DeleteMapping("/{uid}")
  public ResponseEntity<RoomModel> update(@PathVariable UUID uid) {
    this.service.delete(uid);
    return ResponseEntity.noContent().build();
  }
}
