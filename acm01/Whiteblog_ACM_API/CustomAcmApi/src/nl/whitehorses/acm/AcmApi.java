package nl.whitehorses.acm;

import nl.whitehorses.acm.common.AcmApiException;
import nl.whitehorses.acm.security.Credentials;
import nl.whitehorses.acm.security.ICredentialService;

import oracle.bpel.services.bpm.common.IBPMContext;

import oracle.bpm.casemgmt.CaseIdentifier;
import oracle.bpm.casemgmt.CaseServiceException;
import oracle.bpm.casemgmt.ICaseService;
import oracle.bpm.casemgmt.persistence.factory.CaseEventFactory;
import oracle.bpm.casemgmt.persistence.model.CaseEvent;
import oracle.bpm.services.authentication.IBPMUserAuthenticationService;
import oracle.bpm.services.common.exception.BPMException;


public class AcmApi implements IAcmApi {

    private ICaseService caseService;
    private IBPMUserAuthenticationService bpmUserAuthenticationService;
    private ICredentialService credentialService;
    private Credentials credentials;

    public AcmApi(ICredentialService credentialService) {
        this.credentialService = credentialService;
    }

    /**
     * Raise a user event
     * @param caseId
     * @param userEvent
     * @throws AcmApiException
     */
    @Override
    public void raiseCaseEvent(String caseId, String userEvent) throws AcmApiException {
   
        IBPMContext adminContext = null;

        try {
            // 1. get IBPMContext
            adminContext = bpmUserAuthenticationService.authenticate(this.credentials.getUsername(), this.credentials.getPassword().toCharArray(), null);
            
            // 2. get CaseIdentifier
            CaseIdentifier caseIdentifier = CaseIdentifier.getCaseIdentifierBasedOnCaseId(caseId);
            
            // 3. call CaseService
            CaseEvent caseEvent =
                CaseEventFactory.createUserDefinedEvent(userEvent, null, null);
            caseService.raiseCaseEvent(adminContext, caseIdentifier, caseEvent);
        }
        catch (CaseServiceException e) {
            throw new AcmApiException(e);
        }
        catch (BPMException e) {
            throw new AcmApiException(e);
        }
        finally {
            try {
                bpmUserAuthenticationService.destroyBPMContext(adminContext);
            }
            catch (BPMException e) {
                throw new AcmApiException(e);
            }
        }

      
    }

    public void setCaseService(ICaseService caseService) {
        this.caseService = caseService;
    }

    public void setBpmUserAuthenticationService(IBPMUserAuthenticationService bpmUserAuthenticationService) {
        this.bpmUserAuthenticationService = bpmUserAuthenticationService;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void init() {
        this.credentials = credentialService.getCredentials();
    }

    /**
     * @inheritDoc
     */
    @Override
    public void destroy() {
    }

}

