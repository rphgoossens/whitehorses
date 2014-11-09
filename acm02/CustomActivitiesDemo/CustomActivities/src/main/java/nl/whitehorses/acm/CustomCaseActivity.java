package nl.whitehorses.acm;

import java.util.Map;

import oracle.bpel.services.bpm.common.IBPMContext;

import oracle.bpm.casemgmt.CaseIdentifier;
import oracle.bpm.casemgmt.caseactivity.ICaseActivityCallback;

public class CustomCaseActivity implements ICaseActivityCallback {
    public CustomCaseActivity() {
        super();
    }

    public String initiate(IBPMContext iBPMContext,
                           CaseIdentifier caseIdentifier, String string,
                           Map<String, Object> map) {
       
        // Add activity logic here
       
        return "Called class CustomCaseActivity for activity => " + string;
    }
} 