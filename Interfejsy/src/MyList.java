public class MyList implements IDataStructure {

    private double value;
    private MyList next;

    public MyList(double value) {
        this.value = value;
        this.next = null;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public MyList getNext() {
        return next;
    }

    public void setNext(MyList next) {
        this.next = next;
    }

    @Override
    public void add(double value) {
        MyList current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new MyList(value);
    }

    @Override
    public double max() {
        double maxValue = this.value;
        MyList current = this.next;

        while (current != null) {
            if (current.value > maxValue) {
                maxValue = current.value;
            }
            current = current.next;
        }
        return maxValue;
    }

    @Override
    public double min() {
        double minValue = this.value;
        MyList current = this.next;

        while (current != null) {
            if (current.value < minValue) {
                minValue = current.value;
            }
            current = current.next;
        }
        return minValue;
    }


    @Override
    public boolean contains(double value) {
        MyList current = this;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    @Override
    public void clear(double value) {
        this.value = value;
        this.next = null;
    }


    @Override
    public void sort() {
        if (this.next == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            MyList current = this;
            while (current.next != null) {
                if (current.value > current.next.value) {
                    double temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void changeat(double oldValue, double newValue) {
        MyList current = this;
        while (current != null) {
            if (current.value == oldValue) {
                current.value = newValue;
                return;
            }
            current = current.next;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        MyList current = this;
        sb.append("[");
        while (current != null) {
            sb.append(current.value);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}