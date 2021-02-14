package dbOperations;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import pojos.Appointment;
import pojos.Service;

public class DbServices {

    private static DbServices dbServices = null;
    private final EntityManager entityManager;

    private DbServices() {
        entityManager = Persistence.createEntityManagerFactory("rahi").createEntityManager();
    }

    public static DbServices getInstance() //Making this service class singleton
    {
        if (dbServices == null) {
            dbServices = new DbServices();
        }
        return dbServices;
    }

    //Appointment operations
    public synchronized String addAnAppoinment(Appointment appointment) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(appointment);
            entityManager.getTransaction().commit();
            return "Successfully made an appoinment. Appointment number is: " + String.valueOf(appointment.getAppointmentId());
        } catch (Exception e) {
            return "Can not make an appointment, please try again";
        }
    }

    //Adding new service
    public synchronized String addNewService(Service service) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(service);
            entityManager.getTransaction().commit();
            return "Successfully added new service";
        } catch (Exception e) {
            return "Can not add new service, please try again";
        }
    }

    public synchronized List<String> getServicesList() {
        try {
            entityManager.getTransaction().begin();
            List<String> servicesList = entityManager.createQuery("SELECT t.serviceName FROM Service t").getResultList();
            entityManager.getTransaction().commit();
            return servicesList;
        } catch (Exception e) {
            return null;
        }
    }
}
