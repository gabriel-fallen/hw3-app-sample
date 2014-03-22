package ru.kpfu.it;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.it.model.ToDo;

import javax.annotation.Nonnull;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Alexander Tchitchigin
 *         Date: 2/26/14
 *         Time: 11:10 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Nonnull
public class CommandProcessorImplTest {
    @Autowired
    private CommandProcessor processor;
    @Autowired
    private ToDoStore mockStore;

    @Test
    @DirtiesContext
    public void testHandleCreate() {
        processor.handleCreate("Test");

        verify(mockStore).add("Test");
    }

    @Test
    @DirtiesContext
    public void testHandleList() {
        processor.handleList();
        verify(mockStore).getAll();

        Collection<ToDo> list = new ArrayList<ToDo>();
        when(mockStore.getAll()).thenReturn(list);
        Collection<ToDo> actual = processor.handleList();
        assertEquals("HanleList returns what it gets", list, actual);
    }

    @Test
    @DirtiesContext
    public void testHandleDelete() {
        processor.handleDelete(1L);
        verify(mockStore).delete(1L);
        processor.handleDelete(2L);
        verify(mockStore).delete(2l);

        when(mockStore.delete(3l)).thenReturn(true);
        assertEquals("successfull delete", true, processor.handleDelete(3l));
    }

    @Test
    @DirtiesContext
    public void testHandleClose() {
        processor.handleClose(1L);
        verify(mockStore).get(1L);
        processor.handleClose(2L);
        verify(mockStore).get(2L);

        ToDo testToDo = new ToDo(4L,"Test");
        testToDo.setCompleted(false);
        when(mockStore.get(4L)).thenReturn(testToDo);
        boolean result= processor.handleClose(4L);
        assertTrue("Closing existing ToDo", result);
        assertTrue("ToDo is closed", testToDo.isCompleted()); 

        boolean actual = processor.handleClose(5L);
        assertEquals("Closing nonexisting ToDo", false, actual);

    }


    @Configuration
    @Nonnull
    static class Config {
        @Bean
        public CommandProcessor cmdProc() {
            return new CommandProcessorImpl(mockStore());
        }

        @Bean
        public ToDoStore mockStore() {
            return mock(ToDoStore.class);
        }
    }
}
