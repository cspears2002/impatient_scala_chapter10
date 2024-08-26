package propertyChangeSupport:

    import java.awt.Point
    import java.beans.PropertyChangeListener
    import java.beans.PropertyChangeSupport
    import java.beans.PropertyChangeEvent


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

        def firePropertyChange(propertyName: String, oldValue: Double, newValue: Double): Unit = 
            this.pcs.firePropertyChange(propertyName, oldValue, newValue)

        def setX(x: Double): Unit =
            val oldX = this.getX()
            val newX = oldX + x
            this.pcs.firePropertyChange("x", oldX, newX)

        def setY(y: Double): Unit =
            val oldY = this.getY()
            val newY = oldY + y
            this.pcs.firePropertyChange("y", oldY, newY)
    }


    class PointPropertyListener extends PropertyChangeListener {
        def propertyChange(evt: PropertyChangeEvent): Unit = 
            val propName = evt.getPropertyName()
            val oldVal = evt.getOldValue()
            val newVal = evt.getNewValue()
            println(s"Changed $propName from $oldVal to $newVal")
    }