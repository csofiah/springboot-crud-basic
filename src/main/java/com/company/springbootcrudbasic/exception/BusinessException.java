package com.company.springbootcrudbasic.exception;

public class BusinessException extends RuntimeException {

    public enum Type{
        ERROR_GENERAL_BUSINESS("Error del sistema, por favor intente de nuevo");

        private final String message;


        public BusinessException build(Throwable throwable) {
            return new BusinessException(this, throwable);
        }

        public BusinessException build() {
            return new BusinessException(this);
        }

        Type(String message) {
            this.message = message;
        }


    }

    private final BusinessException.Type type;

    private BusinessException(BusinessException.Type type) {
        super(type.message);
        this.type = type;
    }

    private BusinessException(BusinessException.Type type, Throwable throwable) {
        super(type.message, throwable);
        this.type = type;
    }

    public BusinessException.Type getType() {
        return type;
    }

}
