package org.reman.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/task")

public class TaskResource {

	public static class Message {
		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Message(String message) {
			super();
			this.message = message;
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Message sample() {
		return new Message("Hello world!");
	}

}
