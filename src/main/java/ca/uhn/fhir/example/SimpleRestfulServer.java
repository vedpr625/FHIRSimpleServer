package ca.uhn.fhir.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.server.RestfulServer;
import ca.uhn.fhir.rest.server.interceptor.ResponseHighlighterInterceptor;

@WebServlet("/*")
public class SimpleRestfulServer extends RestfulServer {

	@Override
	protected void initialize() throws ServletException {
		// Create a context for the appropriate version
		setFhirContext(FhirContext.forR4());
		
		// Register resource providers
		//registerProvider(new PatientResourceProvider());
		//registerProvider(new CompositionResourceProvider());
		//registerProvider(new EncounterResourceProvider());
		//registerProvider(new OrganizationResourceProvider());
		//registerProvider(new BundleResourceProvider());
		registerProvider(new NRCESDischargeProvider());
		




		// Format the responses in nice HTML
		registerInterceptor(new ResponseHighlighterInterceptor());
	}
}
