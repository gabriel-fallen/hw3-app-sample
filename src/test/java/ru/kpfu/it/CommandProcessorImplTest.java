package ru.kpfu.it;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.kpfu.it.model.ToDo;

import javax.annotation.Nonnull;

import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    public void testHandleCreate() {
        processor.handleCreate("Test");

        verify(mockStore).add("Test");
    }

    @Test
    public void testHandleList() {
        processor.handleList();

        verify(mockStore).getAll();
    }

    @Configuration
    @Nonnull
    static class Config {
        @Bean CommandProcessor cmdProc() {
            return new CommandProcessorImpl(mockStore());
        }

        @Bean
        public ToDoStore mockStore() {
            return mock(ToDoStore.class);
        }
    }
}
