package com.ssafy.edu.help;

public class ApiResult {
    private Boolean success;
    private String message;

    public ApiResult(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	@Override
	public String toString() {
		return "ApiResult [success=" + success + ", message=" + message + "]";
	}
    
}
