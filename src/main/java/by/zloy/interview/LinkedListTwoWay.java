package by.zloy.interview;

public class LinkedListTwoWay {

    Object obj;
    LinkedListTwoWay next;
    LinkedListTwoWay prev;

    public static void main(String[] args) {
        LinkedListTwoWay v1 = new LinkedListTwoWay();
        v1.add("Test1");
        v1.add("Test2");
        v1.add("Test3");
        v1.add("Test4");
        System.out.println(v1.reverse());
    }

    public void add(Object value) {
        if (this.obj == null) {
            this.obj = value;
            return;
        }
        if (this.next == null) {
            this.next = new LinkedListTwoWay();
        }
        this.next.add(value);
        this.next.prev = this;
    }

    public LinkedListTwoWay reverse() {
        LinkedListTwoWay current = this;
        LinkedListTwoWay temp = null;

        // Проходим по всему списку и меняем местами next и prev для каждого узла
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // Переходим к следующему узлу (который теперь доступен через prev!)
            current = current.prev;
        }

        // После цикла temp указывает на бывший предпоследний узел
        if (temp != null) {
            return temp.prev;
        } else {
            return this;
        }
    }

    public String toString() {
        return toStringRecursive(new StringBuilder(), this);
    }

    public String toStringRecursive(StringBuilder sb, LinkedListTwoWay node) {
        if (node.obj != null) {
            sb.append(node.obj);
            if (node.next != null) {
                sb.append(" -> ");
                toStringRecursive(sb, node.next);
            }
        }
        return sb.toString();
    }
}
