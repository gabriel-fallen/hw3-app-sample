package ru.kpfu.it;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;

@Nonnull
public class App {
	private final ToDoStore store;

	public App(ToDoStore store) {
		this.store = checkNotNull(store, "Expected not null store argument.");
	}

    public void talkToUser() {
        // TODO: implement this
        System.out.println("Hello, Spring!");
    }

}
