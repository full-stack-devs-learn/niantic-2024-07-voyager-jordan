package com.niantic.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private String resourceType;
    private String searched;
    private String message;


    public ResourceNotFoundException(String resourceType, String searched)
    {
        this.resourceType = resourceType;
        this.searched = searched;
        this.message = String.format("%s %s couldn't be found", resourceType, searched);
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getSearched() {
        return searched;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

