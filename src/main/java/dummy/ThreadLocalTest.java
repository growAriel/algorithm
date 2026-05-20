package dummy;
import java.util.ArrayList;
import java.util.List;

public class ThreadLocalTest {
    private List<String> messages = new ArrayList<>();;

    public static final ThreadLocal<ThreadLocalTest> holder = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void addMessage(String message) {
        holder.get().messages.add(message);
    }

    public static List<String> clearMessages() {
        List<String> messages  = holder.get().messages;
        holder.remove();
        System.out.println("size: " + holder.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        ThreadLocalTest.addMessage("Hello World");
        System.out.println(holder.get().messages);
        ThreadLocalTest.clearMessages();
    }
}
