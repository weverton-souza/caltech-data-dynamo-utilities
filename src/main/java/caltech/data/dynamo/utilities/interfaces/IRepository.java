package caltech.data.dynamo.utilities.interfaces;

import caltech.data.dynamo.utilities.abstracts.AbstractDomain;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * @author Weverton Souza.
 * Created on 19/09/19
 */
@EnableScan
public interface IRepository<D extends AbstractDomain, K extends Serializable> extends CrudRepository<D, K> {
}
