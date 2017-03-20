package ch.heigvd.res.stpatrick;


import java.io.*;

/**
 * 
 * @author Olivier Liechti
 */
public class Application {

  IStreamProcessorsFactory processorsFactory = new StreamProcessorsFactory();
  
  public IStreamProcessorsFactory getStreamProcessorsFactory() {
    return processorsFactory;
  }

  IStreamDecoratorController getStreamDecoratorController() {
    return new IStreamDecoratorController() {
      @Override
      public Reader decorateReader(Reader inputReader) {
        return inputReader;
      }

      @Override
      public Writer decorateWriter(Writer outputWriter) {
        return new FilterWriter(outputWriter)
        {
          @Override
          public void write (String str, int off, int len) throws IOException
          {
            // JBL: ensure no reading outside array range
            len = Math.min(len, str.length() - off);

            // JBL: iterate char by char, with call to overloaded/overridden 'write (int c)'
            for (int i = 0; i < len; ++i)
            {
              write(str.charAt(off + i));
            }
          }

          @Override
          public void write (char[] cbuf, int off, int len) throws IOException
          {
            // JBL: ensure no reading outside array range
            len = Math.min(len, cbuf.length - off);

            // JBL: iterate char by char, with call to overloaded/overridden 'write (int c)'
            for (int i = 0; i < len; ++i)
            {
              write(cbuf[off + i]);
            }
          }

          @Override
          public void write (int c) throws IOException
          {
            // JBL: apply uppercase transformation, before writing char
            if (c != 'A' & c != 'a')
            {
              super.write(c);
            }
          }
        };
      }
    };
  }
}
