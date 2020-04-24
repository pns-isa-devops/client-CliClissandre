package api;

import stubs.customer.CustomerWebService;
import stubs.customer.CustomerWebServiceService;
import stubs.drone.DroneWebService;
import stubs.drone.DroneWebServiceService;
import stubs.packageR.PackageRegisterWebService;
import stubs.packageR.PackageWebServiceService;
import stubs.provider.ProviderWebService;
import stubs.provider.ProviderWebServiceService;

import javax.xml.ws.BindingProvider;
import java.net.URL;

public class DDPublicAPI {

    public CustomerWebService cws;
    public ProviderWebService pws;
    public PackageRegisterWebService packws;
    public DroneWebService dws;

    public DDPublicAPI(String host, String port) {
        initCWS(host, port);
        initPWS(host, port);
        initPackWS(host, port);
        initDWS(host, port);
    }

    private void initCWS(String host, String port) {
        URL wsdlLocation = DDPublicAPI.class.getResource("/CustomerWebService.wsdl");
        CustomerWebServiceService factory = new CustomerWebServiceService(wsdlLocation);
        this.cws = factory.getCustomerWebServicePort();
        String address = "http://" + host + ":" + port + "/Web/webservices/CustomerWS";
        ((BindingProvider) cws).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }

    private void initPWS(String host, String port) {
        URL wsdlLocation = DDPublicAPI.class.getResource("/ProviderWebService.wsdl");
        ProviderWebServiceService factory = new ProviderWebServiceService(wsdlLocation);
        this.pws = factory.getProviderWebServicePort();
        String address = "http://" + host + ":" + port + "/Web/webservices/ProviderWS";
        ((BindingProvider) pws).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }

    private void initPackWS(String host, String port) {
        URL wsdlLocation = DDPublicAPI.class.getResource("/PackageWebService.wsdl");
        PackageWebServiceService factory = new   PackageWebServiceService(wsdlLocation);
        this.packws = factory.getPackageWebServicePort();
        String address = "http://" + host + ":" + port + "/Web/webservices/PackageWS";
        ((BindingProvider) packws).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }

    private void initDWS(String host, String port) {
        URL wsdlLocation = DDPublicAPI.class.getResource("/DroneWebService.wsdl");
        DroneWebServiceService factory = new DroneWebServiceService(wsdlLocation);
        this.dws = factory.getDroneWebServicePort();
        String address = "http://" + host + ":" + port + "/Web/webservices/DroneWS";
        ((BindingProvider) dws).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }
}
