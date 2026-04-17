package hokotro.util;

import java.util.Collection;
import java.util.stream.Collectors;

public class Logger {
    public static void logOK(String log) {
        System.out.println("OK " + log);
    }

    public static void logERROR(String message) {
        System.out.println("ERROR " + message);
    }

    public static String buildStringFromCollection(Collection<?> collection, char prefix, char suffix, CharSequence separator) {
        if (collection == null || collection.isEmpty()) {
            return prefix + "" + suffix;
        }

        String content = collection.stream()
            .map(Object::toString)
            .collect(Collectors.joining(separator));

        return prefix + content + suffix;
    }
}
