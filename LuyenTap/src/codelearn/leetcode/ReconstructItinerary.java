package codelearn.leetcode;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        ReconstructItinerary test = new ReconstructItinerary();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("EZE","AXA"));
        tickets.add(Arrays.asList("TIA","ANU"));
        tickets.add(Arrays.asList("ANU","JFK"));
        tickets.add(Arrays.asList("JFK","ANU"));
        tickets.add(Arrays.asList("ANU","EZE"));
        tickets.add(Arrays.asList("TIA","ANU"));
        tickets.add(Arrays.asList("AXA","TIA"));
        tickets.add(Arrays.asList("TIA","JFK"));
        tickets.add(Arrays.asList("ANU","TIA"));
        tickets.add(Arrays.asList("JFK","TIA"));
        List<String> result = test.findItinerary(tickets);
        System.out.println(result);
    }
    HashMap<String, LinkedList<String>> adj;
    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        for (List<String> item: tickets) {
            String from = item.get(0);
            String to = item.get(1);
            if (!adj.containsKey(from)) {
                adj.put(from, new LinkedList<>());
            }
            adj.get(from).add(to);
        }
        adj.forEach((k, v) -> Collections.sort(v));
        return findRouteEuler("JFK");
    }

    private List<String> findRouteEuler(String start) {
        LinkedList<String> result = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.add(start);
        while (!stack.isEmpty()) {
            String u = stack.peek();
            LinkedList<String> set = adj.get(u);
            if (set != null && !set.isEmpty()) {
                String v = set.get(0);
                stack.add(v);
                set.remove(0);
            } else {
                result.addFirst(u);
                stack.pop();
            }
        }
        return result;
    }
}
/*
"JFK","ANU","EZE","AXA","TIA","ANU","JFK","TIA","ANU","TIA","JFK"
JFK, ANU, EZE, AXA, TIA, ANU, JFK, TIA, ANU, TIA, JFK
 */