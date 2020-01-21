package caltech.data.dynamo.utilities.interfaces;

import java.io.Serializable;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
public interface IDataTransferObject extends Serializable {
    Object setId(final String id);
    String getId();
}
