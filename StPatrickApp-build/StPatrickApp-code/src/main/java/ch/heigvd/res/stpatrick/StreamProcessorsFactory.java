package ch.heigvd.res.stpatrick;

/**
 * This class is responsible for providing different types of Stream Processors.
 * 
 * @author Olivier Liechti
 */
public class StreamProcessorsFactory implements IStreamProcessorsFactory {

  @Override
  public IStreamProcessor getProcessor() {
    return new BasicStreamProcessor();
  }

  @Override
  public IStreamProcessor getProcessor(String processorName) throws UnknownNameException {
    /*
     * Factory Design Pattern allow to select and build specific instance.
     * Therefore, I use switch-case to select right class instance according to given processor name.
     */
    switch(processorName)
    {
      case "e-remover": // used in ApplicationTest.itShouldBePossibleToGetRemoveECharactersFromAStream
        return new RemoverStreamProcessor("Ee");
      default:
        throw new UnknownNameException("The factory does not know any processor called " + processorName);
    }
  }

}
