package tcc.caioferraz.backendapi.domain.rooms;

import lombok.Getter;

@Getter
public enum TypeRoomEnum {

  SINGLE("Solteiro"),
  COUPLE("Casal");

  private final String type;

  TypeRoomEnum(String type) {
    this.type = type;
  }

  public static TypeRoomEnum fromType(String type) {
    for (TypeRoomEnum value : values()) {
      if (value.getType().equalsIgnoreCase(type)) {
        return value;
      }
    }
    throw new IllegalArgumentException("Tipo de quarto não encontrado: " + type);
  }
}
