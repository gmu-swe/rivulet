package io.rivulet.fuzz.maven.surefire.junitcore;

import java.io.*;

/* ObjectOutputStream implementation that can append primitive data types and graphs of Java objects to an already
 * existing file to which an ObjectOutputStream was written. */
public class AppendingObjectOutputStream extends ObjectOutputStream {

    /* Constructs a new object output stream from the specified stream. */
    private AppendingObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    /* Prevents writing of serialization stream header as the header is expected to have been already written when the
     * file was created. */
    @Override
    protected void writeStreamHeader() throws IOException {
        // Resets the OOS' understanding of what has already been deserialized or serialized at this point
        reset();
    }

    /* Initializes a stream from the specified file. If the specified file already exists expects that an ObjectOutputStream was
     * written to it and returns an AppendingObjectOutputStream. If the specified file was created returns a new
     * ObjectOutputStream create from the file. */
    public static synchronized ObjectOutputStream newInstance(File file) throws IOException {
        boolean existed = file.exists();
        OutputStream stream = new BufferedOutputStream((new FileOutputStream(file, true)));
        return existed ? new AppendingObjectOutputStream(stream) : new ObjectOutputStream(stream);
    }
}
