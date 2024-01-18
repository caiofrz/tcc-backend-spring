package tcc.caioferraz.backendapi.domain.rooms;

import lombok.Getter;

@Getter
public enum TypeRoomEnum {

  SINGLE("Casal"),
  COUPLE("Solteiro");

  private final String type;

  TypeRoomEnum(String type) {
    this.type = type;
  }
}
