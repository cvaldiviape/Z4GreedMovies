package com.shared.enums;

public enum ControllerMessageEnum {

    FIND_ALL("Listado de elementos"),
    FIND_BY_IO("Buscar elemento por Id"),
    CREATE("Creación exitosa"),
    UPDATE("Actualización exitosa"),
    DELETE("Eliminación exitosa");

    private final String value;

    private ControllerMessageEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }
}
