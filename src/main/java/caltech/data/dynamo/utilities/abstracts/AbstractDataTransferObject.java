package caltech.data.dynamo.utilities.abstracts;

import caltech.data.dynamo.utilities.interfaces.IDataTransferObject;

import java.util.Objects;

/**
 * @author Weverton Souza.
 * Created on 30/06/19
 */
public abstract class AbstractDataTransferObject implements IDataTransferObject {
    protected String id;

    public String getId() {
        return id;
    }

    public IDataTransferObject setId(final String id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IDataTransferObject that = (IDataTransferObject) o;
        return Objects.equals(id, that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
