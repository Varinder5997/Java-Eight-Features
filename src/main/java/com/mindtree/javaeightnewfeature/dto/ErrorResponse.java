package com.mindtree.javaeightnewfeature.dto;

public class ErrorResponse {
	 private String errorMessage;
	    
	    public ErrorResponse()
	    {
	        super();
	    }
		public String getErrorMessage() {
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public ErrorResponse(String errorMessage) {
			super();
			this.errorMessage = errorMessage;
		}

}
