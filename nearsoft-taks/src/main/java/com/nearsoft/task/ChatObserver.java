package com.nearsoft.task;

public class ChatObserver {

	private String name;
	private ChatObserver chatObserver;
	
	
	public ChatObserver(ChatObserver chatObserver, String name) {
		super();
		this.name = name;
		this.chatObserver = chatObserver;
	}


	public void update(ChatObservable chatObservable, MessageFromSender message) {
		
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chatObserver == null) ? 0 : chatObserver.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatObserver other = (ChatObserver) obj;
		if (chatObserver == null) {
			if (other.chatObserver != null)
				return false;
		} else if (!chatObserver.equals(other.chatObserver))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
	
	
}
