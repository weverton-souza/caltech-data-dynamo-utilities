package caltech.data.dynamo.utilities.interfaces;

import caltech.data.dynamo.utilities.abstracts.AbstractDataTransferObject;
import caltech.data.dynamo.utilities.generics.Response;

import java.io.Serializable;
import java.util.List;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
public interface IResource<D extends AbstractDataTransferObject, K extends Serializable> {
        Response save(final D resource);
        Response update(final D resource);
        Response findById(final K id);
        List<IDataTransferObject> findAll(final Iterable<K> pageable);
        void delete(K id);
}
