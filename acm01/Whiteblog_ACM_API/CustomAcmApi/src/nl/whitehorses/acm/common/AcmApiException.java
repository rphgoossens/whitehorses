package nl.whitehorses.acm.common;

/**
 * General custum acm api exception
 */
public class AcmApiException extends Exception {

    @SuppressWarnings("compatibility:-3095718888854392993")
    private static final long serialVersionUID = 4156597730690053307L;

    public AcmApiException(Throwable throwable) {
        super(throwable);
    }

    public AcmApiException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public AcmApiException(String string) {
        super(string);
    }

    public AcmApiException() {
        super();
    }
}
