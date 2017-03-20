package ch.heigvd.res.stpatrick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * CLASS: remove 'E' and 'e' chars from input stream.
 *
 * @author Julien Baeriswyl
 * @since  2017-03-20
 */
class ERemoverStreamProcessor implements IStreamProcessor {

    @Override
    public void process(Reader in, Writer out) throws IOException {
        BufferedReader br = new BufferedReader(in);
        BufferedWriter bw = new BufferedWriter(out);
        int c = br.read();
        while (c != -1) {
            if (c != 'e' & c != 'E') // check if char is different from removed ones
            {
                out.write(c);
            }
            c = br.read();
        }
        bw.flush();
    }

}
