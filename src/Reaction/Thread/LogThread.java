package reaction.thread;


import constant.FilePath;
import logger.Log;
import logger.LogWriter;
import reaction.buffer.Buffers;

import java.io.File;
import java.io.IOException;

/**
 * A <i>Log thread</i> is a thread of execution in a program. The Java
 * Virtual Machine allows an application to have multiple threads of
 * execution running concurrently.
 * <p/>
 * This class consumes  {@link Log}
 * object while method {@code run} is invoked.
 *
 * @author OGUNDE KEHINDE
 * @see java.lang.Thread
 * @see java.lang.Runnable
 * @see reaction.Reaction
 * @see logger.Log
 * @see java.util.concurrent.ArrayBlockingQueue
 * @since 1.7
 */
public class LogThread implements Runnable {

    private LogWriter logWriter;

    /**
     * Construct this class
     *
     * @throws IOException if error occurs
     */
    public LogThread() throws IOException {
        File file = new File(FilePath.LOG_FILE_PATH.toString());
        logWriter = new LogWriter(file);
    }

    @Override
    public void run() {
        consume();
    }

    /**
     * consume {@link logger.Log} from {@link reaction.buffer.Buffers#logBuffer}
     */
    private void consume() {
        Log log;
        try {
            while ((log = Buffers.logBuffer.take()) != null) {
                logWriter.write(log);
                if (!Buffers.isRunning())
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
