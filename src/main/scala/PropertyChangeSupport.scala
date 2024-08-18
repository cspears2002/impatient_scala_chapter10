import java.awt.Point
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

trait PropertyChangeSupportTrait {
    def addPropertyChangeListener(listener: PropertyChangeListener): Unit
    def addPropertyChangeListener(propertyName: String, listener: PropertyChangeListener): Unit
    def removePropertyChangeListener(listener: PropertyChangeListener): Unit
    def removePropertyChangeListener(propertyName: String, listener: PropertyChangeListener): Unit

    def getPropertyChangeListeners(): Array[PropertyChangeListener]
    def getPropertyChangeListeners(propertyName: String): Array[PropertyChangeListener]

    def firePropertyChange(propertyName: String, oldValue: Int, newValue: Int): Unit
}

class MyPoint(x: Int, y: Int) extends Point(x: Int, y: Int) with PropertyChangeSupportTrait {
    val pcs: PropertyChangeSupport = PropertyChangeSupport(this)

    def addPropertyChangeListener(listener: PropertyChangeListener): Unit =
        this.pcs.addPropertyChangeListener(listener)

    def addPropertyChangeListener(propertyName: String, listener: PropertyChangeListener): Unit =
        this.pcs.addPropertyChangeListener(propertyName, listener)

    def removePropertyChangeListener(listener: PropertyChangeListener): Unit = 
        this.pcs.removePropertyChangeListener(listener)

    def removePropertyChangeListener(propertyName: String, listener: PropertyChangeListener): Unit = 
        this.pcs.removePropertyChangeListener(propertyName, listener)

    def getPropertyChangeListeners(): Array[PropertyChangeListener] = 
        this.pcs.getPropertyChangeListeners()

    def getPropertyChangeListeners(propertyName: String): Array[PropertyChangeListener] = 
        this.pcs.getPropertyChangeListeners(propertyName)

    def firePropertyChange(propertyName: String, oldValue: Int, newValue: Int): Unit = 
        this.pcs.firePropertyChange(propertyName, oldValue, newValue)
}