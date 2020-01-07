package com.nearsoft.task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChatObservable {

	List<ChatObserver> listOfChatObserver = new ArrayList<>();
	
	public void addObserver( ChatObserver chatObserver) {
		this.listOfChatObserver.add(chatObserver);
	}
	
	public ChatObserver getByName (String name) {
		return listOfChatObserver
				.stream().filter(item -> item.getName().equals(name)).findAny().get();
	}
	
	public void removeObserver(ChatObserver chatObserver) {
		this.listOfChatObserver.remove(chatObserver);
	}
	
	public List<String> getUserList() {
		return this.listOfChatObserver
				.stream()
				.map(item -> item.getName())
				.collect(Collectors.toList());
	}
	
	public void notifyObservers(MessageFromSender message)	{
		this.listOfChatObserver.forEach(
				item -> item.update(this, message)			
		);
		
	}
	
}
