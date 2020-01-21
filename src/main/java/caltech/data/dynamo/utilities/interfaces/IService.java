package caltech.data.dynamo.utilities.interfaces;

import java.io.Serializable;
import java.util.List;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
public interface IService<D extends IDataTransferObject, K extends Serializable> {
    IDataTransferObject saveOrUpdate(final D resource);
    IDataTransferObject findById(final K id) throws Exception;
    List<IDataTransferObject> findAll(final Iterable<K> ids);
    void delete(K id) throws Exception;
}
