package com.suvodip.posts.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String entityName;
	private String fieldName;
	private String fieldValue;

	public ResourceNotFoundException(String entityName, String fieldName, String fieldValue) {
		super(String.format("%s %s: %s is not present", entityName, fieldName, fieldValue));
		this.entityName = entityName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getEntityName() {
		return entityName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}
}
