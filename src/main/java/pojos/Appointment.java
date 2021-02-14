package pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    @Column(nullable = false)
    private String name;
    private String email;
    @Column(nullable = false)
    private String selectedService;
    @Column(nullable = false)
    private String appointmentDate;
    @Column(nullable = false)
    private String appointmentTime;
    @Column(nullable = false)
    private String phoneNumber;

    public Appointment() {
    }

    public Appointment(Integer appointmentId, String name, String email,
            String selectedService, String appointmentDate,
            String appointmentTime, String phoneNumber) {
        this.appointmentId = appointmentId;
        this.name = name;
        this.email = email;
        this.selectedService = selectedService;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.phoneNumber = phoneNumber;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSelectedService() {
        return selectedService;
    }

    public void setSelectedService(String selectedService) {
        this.selectedService = selectedService;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
