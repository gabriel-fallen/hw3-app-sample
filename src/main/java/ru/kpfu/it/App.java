package ru.kpfu.it;

import ru.kpfu.it.model.CommandArg;
import ru.kpfu.it.model.ToDo;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

@Nonnull
public class App {
    private final CommandParser parser;
    private final CommandProcessor processor;

    public App(CommandParser parser, CommandProcessor processor) {
        this.parser = parser;
        this.processor = processor;
    }

    public void talkToUser() throws IOException {
        // TODO: implement this
        System.out.println("ToDo manager");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean exiting = false;
        while (!exiting) {
            System.out.print("> ");
            String input = in.readLine();

            if (input == null || input.isEmpty()) {
                exiting = true;
                continue;
            }

            final CommandArg commandArg = parser.parse(input);
            switch (commandArg.getCommand()) {
                case LIST:
                    final Collection<ToDo> toDos = processor.handleList();
                    // FIXME: implement
                    break;
                case CREATE:
                    // FIXME: implement
                    break;
                case CLOSE:
                    // FIXME: implement
                    break;
                case DELETE:
                    // FIXME: implement
                    break;
            }
        }
    }

}
