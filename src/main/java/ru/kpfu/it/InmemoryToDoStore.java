package ru.kpfu.it;

import ru.kpfu.it.model.ToDo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Alexander Tchitchigin
 *         Date: 2/22/14
 *         Time: 5:50 PM
 */
public class InmemoryToDoStore implements ToDoStore {
    private long nextId = 0;

    private Set<ToDo> todos = new HashSet<ToDo>();

    @Override
    public ToDo get(Long id) {
        for (ToDo todo : todos) {
            if (todo.getId().equals(id)) return todo;
        }
        return null;
    }

    @Override
    public Collection<ToDo> getAll() {
        return Collections.unmodifiableSet(todos);
    }

    @Override
    public void add(String title) {
        final ToDo todo = new ToDo(++nextId, title);
        todos.add(todo);
    }

    @Override
    public void delete(Long id) {
        ToDo todo = null;
        for (ToDo t : todos) {
            if (t.getId().equals(id)) {
                todo = t;
                break;
            }
        }
        if (todo != null) {
            todos.remove(todo);
        }
    }
}
