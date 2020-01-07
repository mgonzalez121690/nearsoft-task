package com.nearsoft.pair;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;

import com.nearsoft.task.ChatObservable;
import com.nearsoft.task.ChatObserver;
import com.nearsoft.task.MessageFromSender;

public class ChatObservableTest {

    ChatObservable chatObservable;

    @Before
    public void setUp() throws Exception {
        chatObservable = new ChatObservable();

        chatObservable.addObserver(new ChatObserver(null, "Santo"));
        chatObservable.addObserver(new ChatObserver(null, "Atlantis"));
        chatObservable.addObserver(new ChatObserver(null, "Blue Demon"));

    }

    @Test
    public void testGetUserList() throws Exception {
        assertThat(chatObservable.getUserList(), containsInAnyOrder("Blue Demon", "Santo", "Atlantis"));
    }

    @Test
    public void testAddObserver() throws Exception {

        chatObservable.addObserver(new ChatObserver(null, "Octagon"));

        assertThat(chatObservable.getUserList(), hasItem("Octagon"));
    }

    @Test
    public void testRemoveObserver() throws Exception {
        chatObservable.removeObserver(new ChatObserver(null, "Atlantis"));

        assertThat(chatObservable.getUserList(), not(hasItem("Atlantis")));
    }

    @Test
    public void testNotifyObservers() throws Exception {
        ChatObserver perroAguayo = mock(ChatObserver.class);
        ChatObserver milMascaras = mock(ChatObserver.class);
        chatObservable.addObserver(perroAguayo);
        chatObservable.addObserver(milMascaras);
        MessageFromSender message = new MessageFromSender("saludos", "super porky");

        chatObservable.notifyObservers(message);

        verify(perroAguayo).update(chatObservable, message);
        verify(milMascaras).update(chatObservable, message);

    }

    @Test
    public void testGetByName() throws Exception {
        ChatObserver chatObserver = chatObservable.getByName("Atlantis");

       assertThat(chatObserver, is(new ChatObserver(null, "Atlantis")));
    }
    
    
    
}