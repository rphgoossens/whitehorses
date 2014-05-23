package nl.whitehorses.acm.security;


/**
 * Interface for getting the credentials needed to get access to the case
 * management API
 */
public interface ICredentialService {

    /**
     * Credentials needed for getting an IBPMContext
     * @return
     */
    public Credentials getCredentials();
}
