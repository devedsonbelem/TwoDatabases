package br.com.prof.twodatabases.errors;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class UsersErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    private String status;
    private String error;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

     

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
