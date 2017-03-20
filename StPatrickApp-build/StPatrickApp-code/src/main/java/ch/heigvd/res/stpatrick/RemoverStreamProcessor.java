package ch.heigvd.res.stpatrick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * CLASS: remove specified chars (by user) from input stream.
 *
 * @author Julien Baeriswyl
 * @since  2017-03-20
 */
class RemoverStreamProcessor implements IStreamProcessor {
    private String excludedChars;

    public RemoverStreamProcessor(String excludedChars)
    {
        this.excludedChars = excludedChars;
    }

    @Override
    public void process(Reader in, Writer out) throws IOException {
        BufferedReader br = new BufferedReader(in);
        BufferedWriter bw = new BufferedWriter(out);
        int c = br.read();
        while (c != -1) {
            if (excludedChars.indexOf(c) == -1) // check if char is different from removed ones
            {
                out.write(c);
            }
            c = br.read();
        }
        bw.flush();
    }

}
