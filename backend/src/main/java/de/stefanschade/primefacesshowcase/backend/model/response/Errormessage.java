package de.stefanschade.primefacesshowcase.backend.model.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Errormessage {

    MISSING_REQUIRED_FIELD("Missing required filed"),
    RECORD_ALREADY_EXISTS("Record already exists"),
    INTERNAL_SERVER_ERROR("Internal Server Error"),
    NO_RECORD_FOUND("No record found"),
    AUTHENTICATION_FAILED("Authentication failed"),
    COULD_NOT_UPDATE_RECORD("Could not update record"),
    COULD_NOT_DELETE_RECORD("Could not delete record"),
    EMAIL_ADDRESS_NOT_VERIFIED("Email address not verified");

    private String errorMessage;
}
