public class BinarySearchTree extends MyTree implements IDataStructure {

    private BinarySearchTree left;
    private BinarySearchTree right;

    public BinarySearchTree(String name, double value) {
        super(name, value);
        this.left = null;
        this.right = null;
    }

    public BinarySearchTree getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTree left) {
        this.left = left;
    }

    public BinarySearchTree getRight() {
        return right;
    }

    public void setRight(BinarySearchTree right) {
        this.right = right;
    }


    @Override
    public void add(double newValue) {
        if (newValue > this.value) {
            if (this.right == null) {
                this.right = new BinarySearchTree(this.name, newValue);
            } else {
                this.right.add(newValue);
            }
        } else {
            if (this.left == null) {
                this.left = new BinarySearchTree(this.name, newValue);
            } else {
                this.left.add(newValue);
            }
        }
    }


    @Override
    public double max() {
        BinarySearchTree current = this;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }


    @Override
    public double min() {
        BinarySearchTree current = this;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }


    @Override
    public boolean contains(double searchValue) {
        if (this.value == searchValue) {
            return true;
        } else if (searchValue < this.value) {
            return (this.left != null) && this.left.contains(searchValue);
        } else {
            return (this.right != null) && this.right.contains(searchValue);
        }
    }


    @Override
    public void clear(double value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }


    @Override
    public void sort() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.value);
        sb.append(" (");

        // lewe poddrzewo
        if (this.left == null) {
            sb.append("_");
        } else {
            sb.append(this.left.toString());
        }

        sb.append(", ");

        // prawe poddrzewo
        if (this.right == null) {
            sb.append("_");
        } else {
            sb.append(this.right.toString());
        }

        sb.append(")");
        return sb.toString();
    }

}
