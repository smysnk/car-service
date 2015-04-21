package carService.resource;

import org.springframework.hateoas.ResourceSupport;

import java.util.Date;
public class ServiceRecordResource extends ResourceSupport {

    private long serviceRecordId;
    private Date dateServiced;
    private Integer odometerReading;
    private Boolean serviceOilChanged;
    private Boolean serviceTireRotated;
    private Boolean serviceSparkPlugsChanged;

    private CarResource cars;

    public ServiceRecordResource(long serviceRecordId) {
        this.serviceRecordId = serviceRecordId;
    }

    public long getServiceRecordId() {
        return serviceRecordId;
    }

    public void setServiceRecordId(long serviceRecordId) {
        this.serviceRecordId = serviceRecordId;
    }

    public Date getDateServiced() {
        return dateServiced;
    }

    public void setDateServiced(Date dateServiced) {
        this.dateServiced = dateServiced;
    }

    public Integer getOdometerReading() {
        return odometerReading;
    }

    public void setOdometerReading(Integer odometerReading) {
        this.odometerReading = odometerReading;
    }

    public Boolean isServiceOilChanged() {
        return serviceOilChanged;
    }

    public void setServiceOilChanged(Boolean serviceOilChanged) {
        this.serviceOilChanged = serviceOilChanged;
    }

    public Boolean isServiceTireRotated() {
        return serviceTireRotated;
    }

    public void setServiceTireRotated(Boolean serviceTireRotated) {
        this.serviceTireRotated = serviceTireRotated;
    }

    public Boolean isServiceSparkPlugsChanged() {
        return serviceSparkPlugsChanged;
    }

    public void setServiceSparkPlugsChanged(Boolean serviceSparkPlugsChanged) {
        this.serviceSparkPlugsChanged = serviceSparkPlugsChanged;
    }

    public CarResource getCars() {
        return cars;
    }

    public void setCars(CarResource cars) {
        this.cars = cars;
    }

}
