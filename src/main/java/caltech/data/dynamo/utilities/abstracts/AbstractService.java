package caltech.data.dynamo.utilities.abstracts;

import caltech.data.dynamo.utilities.exceptions.ResourceNotFoundException;
import caltech.data.dynamo.utilities.interfaces.IDataTransferObject;
import caltech.data.dynamo.utilities.interfaces.IDomainMapper;
import caltech.data.dynamo.utilities.interfaces.IRepository;
import caltech.data.dynamo.utilities.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Weverton Souza.
 * Created on 16/06/19
 */
@SuppressWarnings("ALL")
public abstract class AbstractService<D extends AbstractDataTransferObject, K extends Serializable>
        implements IService<D, K> {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    protected IRepository repository;
    protected final IDomainMapper mapper;

    protected AbstractService(final IRepository repository, final IDomainMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public IDataTransferObject saveOrUpdate(D dto) {
        if (null == dto.id) {
            dto.id = UUID.randomUUID().toString();
        }
        return this.mapper.toDTO((AbstractDomain) this.repository.save(this.mapper.toDomain(dto)));
    }

    @Override
    public IDataTransferObject findById(K id) {
        Optional<IDataTransferObject> optionalResource = (Optional<IDataTransferObject>) this.repository.findOne(id);
        return this.mapper.toDTO((AbstractDomain) optionalResource.orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public List<IDataTransferObject> findAll(final Iterable<K> ids) {
        final List<IDataTransferObject> dataTransferObjects = new ArrayList<>();
        this.repository
                .findAll(ids).forEach(p -> dataTransferObjects.add((IDataTransferObject) p));
        return dataTransferObjects;
    }

    @Override
    public void delete(K id) {
        Optional<IDataTransferObject> optionalResource = (Optional<IDataTransferObject>) this.repository.findOne(id);
        this.repository.delete(optionalResource.orElseThrow(ResourceNotFoundException::new));
    }
}
