package ru.kpfu.it;

import ru.kpfu.it.model.ToDo;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Alexander Tchitchigin
 *         Date: 2/26/14
 *         Time: 10:59 AM
 */
public interface CommandProcessor {
    void handleCreate(String title);
    boolean handleClose(Long id);
    boolean handleDelete(Long id);
    Collection<ToDo> handleList();
}
