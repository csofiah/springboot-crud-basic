package com.company.springbootcrudbasic.exception;

public class PersonException extends RuntimeException {

    public enum Type{
        ERROR_INSERT_PERSON("Error creando la persona"),
        ERROR_GET_LIST_PERSON("Error listando personas"),
        ERROR_DELETE_PERSON("Error eliminando persona"),
        ERROR_UPDATE_PERSON("Error actualizando persona, ya que no se consiguio la persona en bd"),
        ERROR_NOT_FOUND_PERSON("Error al buscar la persona");

        private final String message;


        public PersonException build(Throwable throwable) {
            return new PersonException(this, throwable);
        }

        public PersonException build() {
            return new PersonException(this);
        }

        Type(String message) {
            this.message = message;
        }


    }

    private final PersonException.Type type;

    private PersonException(PersonException.Type type) {
        super(type.message);
        this.type = type;
    }

    private PersonException(PersonException.Type type, Throwable throwable) {
        super(type.message, throwable);
        this.type = type;
    }

    public PersonException.Type getType() {
        return type;
    }


}
