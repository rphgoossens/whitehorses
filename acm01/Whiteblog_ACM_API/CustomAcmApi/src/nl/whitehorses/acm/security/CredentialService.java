package nl.whitehorses.acm.security;


public class CredentialService implements ICredentialService {
    public CredentialService() {
        super();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Credentials getCredentials() {
        return new Credentials("weblogic", "welcome1");
    }
}
