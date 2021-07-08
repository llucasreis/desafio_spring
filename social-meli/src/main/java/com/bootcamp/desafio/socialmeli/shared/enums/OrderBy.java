package com.bootcamp.desafio.socialmeli.shared.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderBy {
    NAME_ASC("name_asc"),
    NAME_DESC("name_desc"),
    DATE_ASC("date_asc"),
    DATE_DESC("date_desc");

    private String value;

    OrderBy(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @JsonCreator
    public static OrderBy fromJson(@JsonProperty("name") String name) {
        return valueOf(name);
    }
}
