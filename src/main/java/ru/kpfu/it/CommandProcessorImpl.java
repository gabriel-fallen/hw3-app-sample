package ru.kpfu.it;

import ru.kpfu.it.model.ToDo;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Alexander Tchitchigin
 *         Date: 2/26/14
 *         Time: 11:02 AM
 */
public class CommandProcessorImpl implements CommandProcessor {
    private ToDoStore store;

    public CommandProcessorImpl(ToDoStore store) {
        this.store = store;
    }

    @Override
    public void handleCreate(String title) {
        store.add(title);
    }

    @Override
    public boolean handleClose(Long id) {
        return false;
    }

    @Override
    public boolean handleDelete(Long id) {
        return false;
    }

    @Override
    public Collection<ToDo> handleList() {
        return null;
    }
}
