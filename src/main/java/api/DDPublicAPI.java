package api;

import stubs.billing.BillingWebService;
import stubs.billing.BillingWebServiceService;
import stubs.customer.CustomerWebService;
import stubs.customer.CustomerWebServiceService;
import stubs.delivery.DeliveryWebService;
import stubs.delivery.DeliveryWebServiceService;
import stubs.drone.DroneWebService;
import stubs.drone.DroneWebServiceService;
import stubs.packageR.PackageRegisterWebService;
import stubs.packageR.PackageWebServiceService;
import stubs.planning.PlanningWebService;
import stubs.planning.PlanningWebServiceService;
import stubs.provider.ProviderWebService;
import stubs.provider.ProviderWebServiceService;

import javax.xml.ws.BindingProvider;
import java.net.URL;

public class DDPublicAPI {

    public CustomerWebService cws;
    public ProviderWebService pws;
    public PackageRegisterWebService packws;
    public DroneWebService dws;
    public PlanningWebService plws;
    public DeliveryWebService dews;
    public BillingWebService bws;


    public DDPublicAPI(String host, String port) {
        initCWS(host, port);
        initPWS(host, port);
        initPackWS(host, port);
        initDWS(host, port);
        initPLWS(host, port);
        initDDES(host, port);
        initBBS(host,port);
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

    private void initPLWS(String host, String port) {
        URL wsdlLocation = DDPublicAPI.class.getResource("/PlanningWebService.wsdl");
        PlanningWebServiceService factory = new PlanningWebServiceService(wsdlLocation);
        this.plws = factory.getPlanningWebServicePort();
        String address = "http://" + host + ":" + port + "/Web/webservices/PlanningWS";
        ((BindingProvider) plws).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }

    private void initDDES(String host, String port) {
        URL wsdlLocation = DDPublicAPI.class.getResource("/DeliveryWebService.wsdl");
        DeliveryWebServiceService factory = new DeliveryWebServiceService(wsdlLocation);
        this.dews = factory.getDeliveryWebServicePort();
        String address = "http://" + host + ":" + port + "/Web/webservices/DeliveryWS";
        ((BindingProvider) dews).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }

    private void initBBS(String host, String port) {
        URL wsdlLocation = DDPublicAPI.class.getResource("/BillingWebService.wsdl");
        BillingWebServiceService factory = new BillingWebServiceService(wsdlLocation);
        this.bws = factory.getBillingWebServicePort();
        String address = "http://" + host + ":" + port + "/Web/webservices/BillingWS";
        ((BindingProvider) bws).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
    }
}
