package app.utils;

import app.services.*;
import app.services.impl.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ServiceFactory {

    private static final String SERVER_HOSTNAME = "http://localhost:8080/";

    public BrigadeService getBrigadeService() {
        return new BrigadeServiceImpl(SERVER_HOSTNAME);
    }

    public BrigadierService getBrigadierService() {
        return new BrigadierServiceImpl(SERVER_HOSTNAME);
    }

    public DepartmentRegionService getDepartmentRegionService() {
        return new DepartmentRegionServiceImpl(SERVER_HOSTNAME);
    }

    public DepartmentChiefServiceImpl getDepartmentChiefService() {
        return new DepartmentChiefServiceImpl(SERVER_HOSTNAME);
    }

    public DepartmentRegionChiefService getDepartmentRegionChiefService() {
        return new DepartmentRegionChiefServiceImpl(SERVER_HOSTNAME);
    }

    public TestService getTestService() {
        return new TestServiceImpl(SERVER_HOSTNAME);
    }

    public DepartmentService getDepartmentService() {
        return new DepartmentServiceImpl(SERVER_HOSTNAME);
    }

    public EmployeeCategoryService getEmployeeCategoryService() {
        return new EmployeeCategoryServiceImpl(SERVER_HOSTNAME);
    }

    public EmployeeCategoryTypeService getEmployeeCategoryTypeService() {
        return new EmployeeCategoryTypeServiceImpl(SERVER_HOSTNAME);
    }

    public EmployeeService getEmployeeService() {
        return new EmployeeServiceImpl(SERVER_HOSTNAME);
    }

    public EquipmentService getEquipmentService() {
        return new EquipmentServiceImpl(SERVER_HOSTNAME);
    }

    public LaboratoryOrderService getLaboratoryOrderService() {
        return new LaboratoryOrderServiceImpl(SERVER_HOSTNAME);
    }

    public LaboratoryService getLaboratoryService() {
        return new LaboratoryServiceImpl(SERVER_HOSTNAME);
    }

    public MasterService getMasterService(){
        return new MasterServiceImpl(SERVER_HOSTNAME);
    }

    public ProductCategoryTypeService getProductCategoryTypeService() {
        return new ProductCategoryTypeServiceImpl(SERVER_HOSTNAME);
    }

    public ProductService getProductService() {
        return new ProductServiceImpl(SERVER_HOSTNAME);
    }

    public TesterService getTesterService() {
        return new TesterServiceImpl(SERVER_HOSTNAME);
    }
}
