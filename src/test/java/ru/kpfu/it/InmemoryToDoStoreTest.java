package ru.kpfu.it;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ru.kpfu.it.model.ToDo;

import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Alexander Tchitchigin
 *         Date: 2/26/14
 *         Time: 9:48 AM
 */
@RunWith(JUnit4.class)
public class InmemoryToDoStoreTest {
    private ToDoStore store;

    @Before
    public void setUp() {
        store = new InmemoryToDoStore();
    }

    @Test
    public void testGetAll() {
        assertEquals("Initiaaly empty store", 0, store.getAll().size());
        store.add("Test");
        final Collection<ToDo> todos = store.getAll();
        assertEquals("Store with 1 element", 1, todos.size());
        final ToDo t = todos.iterator().next();
        assertEquals("Correst title", "Test", t.getTitle());
    }

    @Test
    public void testGet() {
        assertNull("Unexisting element", store.get(99L));
        store.add("Test");
        final ToDo todo = store.get(1L);
        assertEquals("Correct element", "Test", todo.getTitle());
    }
}
