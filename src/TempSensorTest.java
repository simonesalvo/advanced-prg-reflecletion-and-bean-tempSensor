import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Simone Salvo on 10/01/2018.
 */
class TempSensorTest implements PropertyChangeListener {

    private TempSensor tempSensor = null;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("Running setUp test");
        tempSensor = TempSensor.InitTempSensor(false);
        tempSensor.addPropertyChangeListener(this);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("Running tear down test");
    }

    @org.junit.jupiter.api.Test
    void initTempSensor() {
        System.out.println("Running init temp sensor test");
    }

    @org.junit.jupiter.api.Test
    void go() {
        System.out.println("Running go test");
        tempSensor.go();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Property change");
        System.out.println(evt);
    }
}