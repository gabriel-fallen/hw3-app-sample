package ru.kpfu.it;

import ru.kpfu.it.model.CommandArg;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Alexander Tchitchigin
 *         Date: 3/8/14
 *         Time: 4:12 AM
 */
public interface CommandParser {
    CommandArg parse(String input);
}
