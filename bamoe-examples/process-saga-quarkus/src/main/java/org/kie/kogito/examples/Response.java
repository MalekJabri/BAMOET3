package org.kie.kogito.examples;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Response {

    enum Type {
        SUCCESS,
        ERROR
    }

    private Type type;
    private String resourceId;

    public Response() {
    }

    public Response(Type type, String resourceId) {
        this.type = type;
        this.resourceId = resourceId;
    }

    public static Response success(String payload) {
        return new Response(Type.SUCCESS, payload);
    }

    public static Response error(String payload) {
        return new Response(Type.ERROR, payload);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return Type.SUCCESS.equals(type);
    }
}