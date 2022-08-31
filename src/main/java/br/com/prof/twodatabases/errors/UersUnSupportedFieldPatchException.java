package br.com.prof.twodatabases.errors;

import java.util.Set;

public class UersUnSupportedFieldPatchException extends RuntimeException {

    public UersUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }

}
