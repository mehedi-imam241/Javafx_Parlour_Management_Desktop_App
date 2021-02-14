package pojos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ParlorServices implements Serializable {

    @Id
    private Integer id;
    private String serviceName;
    private Double serviceCharge;

    public ParlorServices() {
    }

    public ParlorServices(Integer id, String serviceName, Double serviceCharge) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceCharge = serviceCharge;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

}
