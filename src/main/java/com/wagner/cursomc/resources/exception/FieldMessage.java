package com.wagner.cursomc.resources.exception;

public class FieldMessage {

    private String fieldName;
    private String messsage;

    public FieldMessage(String fieldName, String messsage) {
        this.fieldName = fieldName;
        this.messsage = messsage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }
}
