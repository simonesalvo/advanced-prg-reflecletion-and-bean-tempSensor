import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Simone Salvo on 21/12/2017.
 */

public class TempSensor implements Serializable , PropertyChangeListener {

    private TempSensor(){

    }

    private static TempSensor tempSensor = null;
    private static PropertyChangeSupport changes = null;

    private float currentTemp = 0;

    private static TempSensor getTempSensor(boolean reset){
        if (tempSensor == null || reset)
        {
            tempSensor = new TempSensor();
            changes = new PropertyChangeSupport(tempSensor);
        }

        return tempSensor;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changes.addPropertyChangeListener(listener);
    }

    public static TempSensor InitTempSensor(boolean reset){
        return getTempSensor(reset);
    }


    private float getCurrentTemp(){
        return this.currentTemp;
    }

    private void setCurrentTemp(float givenTemp){
        float oldTempValue = this.currentTemp;
        this.currentTemp = givenTemp;
        System.out.println("Running setCurrentTemp");
        changes.firePropertyChange("currentTemp", oldTempValue, givenTemp);
    }

    public void go(){
        if (tempSensor != null) {
            new Timer(true).schedule(new TimerTask() {
                @Override
                public void run() {
                    TempSensor tempSensor = TempSensor.getTempSensor(false);
                    float currentTemp = -20 + new Random().nextFloat() * (50 - 20);
                    float oldTempValue = tempSensor.getCurrentTemp();
                    if (currentTemp != oldTempValue) {
                        tempSensor.setCurrentTemp(currentTemp);
                    }

                }
            }, 0,1000);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
