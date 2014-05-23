package nl.whitehorses.acm;

import nl.whitehorses.acm.common.AcmApiException;

/**
 * Public API exposing the ACM API
 */
public interface IAcmApi {

    /**
     * Raise a user event
     * @param caseId
     * @param userEvent
     * @throws AcmApiException
     */
    void raiseCaseEvent(String caseId, String userEvent) throws AcmApiException;

    /**
     * Initialize AcmApi, used for initializing the IBPMContext
     * @throws AcmApiException
     */
    void init() throws AcmApiException;

    /**
     * Destroy AcmApi.
     */
    void destroy() throws AcmApiException;


}
