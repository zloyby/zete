package by.zloy.interview;

public class LinkedListOneWay {

    Object obj;
    LinkedListOneWay next;

    public static void main(String[] args) {
        LinkedListOneWay v1 = new LinkedListOneWay();
        v1.add("Test1");
        v1.add("Test2");
        v1.add("Test3");
        System.out.println(v1.getByIndex(0)); //Test1
        System.out.println(v1.getByIndex(1)); //Test2
        System.out.println(v1.getByIndex(2)); //Test3
        System.out.println(v1.getByIndex(100)); //null
        System.out.println(v1.getByIndex(-10)); //null
        System.out.println(v1.reverseList());
    }

    public void add(Object value) {
        if (this.obj == null) {
            this.obj = value;
            return;
        }
        if (this.next == null) {
            this.next = new LinkedListOneWay();
        }
        this.next.add(value);
    }

    public Object getByIndex(int index) {
        if (index < 0) {
            return null;
        }
        if (index == 0) {
            return this.obj;
        }
        if (this.next == null) {
            return null;
        }
        return this.next.getByIndex(index - 1);
    }

    @Override
    public String toString() {
        return toStringRecursive(new StringBuilder(), this);
    }

    public String toStringRecursive(StringBuilder sb, LinkedListOneWay node) {
        if (node.obj != null) {
            sb.append(node.obj);
            if(node.next != null) {
                sb.append(" -> ");
                toStringRecursive(sb, node.next);
            }
        }
        return sb.toString();
    }

    public LinkedListOneWay reverseList() {
        LinkedListOneWay prev = null;
        LinkedListOneWay current = this;

        while (current != null) {
            LinkedListOneWay nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }
}
