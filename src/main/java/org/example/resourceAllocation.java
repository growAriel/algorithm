package org.example;

import java.util.*;

public class resourceAllocation {
    public static void main(String[] args) {
        String input = "6 3\n" +
                "1200 1250 1\n" +
                "1210 1300 1\n" +
                "1220 1280 2\n" +
                "1230 1400 1\n" +
                "1300 1320 2\n" +
                "1310 1340 2\n";
        Scanner scanner = new Scanner(new java.io.ByteArrayInputStream(input.getBytes()));

        // Read input
        int num = scanner.nextInt();
        int constX = scanner.nextInt(); // This is always 3 per problem statement

        List<Application> applications = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int requestTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            int resourceId = scanner.nextInt();

            applications.add(new Application(requestTime, endTime, resourceId));
        }

        // Sort applications by their ending time (earliest first)
        applications.sort(Comparator.comparingInt(a -> a.endTime));

        // Track the last end time for each resource
        Map<Integer, Integer> resourceLastUsed = new HashMap<>();
        int count = 0;

        for (Application app : applications) {
            if (!resourceLastUsed.containsKey(app.resourceId) ||
                    app.requestTime >= resourceLastUsed.get(app.resourceId)) {
                // Resource is available, schedule this application
                resourceLastUsed.put(app.resourceId, app.endTime);
                count++;
            }
            // Else, skip this application as it conflicts with a previously scheduled one
        }

        System.out.println(count);
    }

    static class Application {
        int requestTime;
        int endTime;
        int resourceId;

        public Application(int requestTime, int endTime, int resourceId) {
            this.requestTime = requestTime;
            this.endTime = endTime;
            this.resourceId = resourceId;
        }
    }
}