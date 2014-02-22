package ru.kpfu.it;

import ru.kpfu.it.model.ToDo;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Alexander Tchitchigin
 *         Date: 2/22/14
 *         Time: 5:49 PM
 */
public interface ToDoStore {
    ToDo get(Long id);
    Collection<ToDo> getAll();
    void add(String title);
    void delete(Long id);
}
