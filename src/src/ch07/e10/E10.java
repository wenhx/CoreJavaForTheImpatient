package ch07.e10;

import java.util.*;

public class E10 {
    public static void run() {
        Map<String, Set<Neighbor>> cityMap = buildMap();
        runDijkstraAlgorithm(cityMap, "A", "E");
        runDijkstraAlgorithm(cityMap, "D", "J");
        runDijkstraAlgorithm(cityMap, "S", "E");
    }

    private static void runDijkstraAlgorithm(Map<String, Set<Neighbor>> cityMap, String startPoint, String endPoint) {
        List<String> path = getShortestPath(cityMap, startPoint, endPoint);
        for (String p : path) {
            System.out.print(p + (p == endPoint ? "\n" : " -> "));
        }
    }

    private static List<String> getShortestPath(Map<String, Set<Neighbor>> cityMap, String startPoint, String endPoint) {
        PriorityQueue<Neighbor> queue = new PriorityQueue<>((n1, n2) -> n1.getDistance() - n2.getDistance());
        HashMap<String, Integer> distancesFromStartPoint = new HashMap<>();
        HashMap<String, String> previous = new HashMap<>();
        for (String cityName : cityMap.keySet()) {
            distancesFromStartPoint.put(cityName, cityName == startPoint ? 0 : Integer.MAX_VALUE);
            previous.put(cityName, "");
        }
        queue.offer(new Neighbor(startPoint, 0));

        while (!queue.isEmpty()) {
            Neighbor shortest = queue.poll();
            if (shortest.getCityName() == endPoint)
                break;

            Set<Neighbor> neighbors = cityMap.get(shortest.getCityName());
            for (Neighbor neighbor : neighbors) {
                String neighborCity = neighbor.getCityName();
                int nextCityDistance = distancesFromStartPoint.get(shortest.getCityName()) + neighbor.getDistance();
                if (nextCityDistance < distancesFromStartPoint.get(neighborCity)) {
                    distancesFromStartPoint.put(neighborCity, nextCityDistance);
                    previous.put(neighborCity, shortest.getCityName());
                    queue.offer(new Neighbor(neighborCity, nextCityDistance));
                }
            }
        }
        System.out.println("Shortest paths from " + startPoint + " to " + endPoint + " :");
        for (Map.Entry<String, Integer> entry : distancesFromStartPoint.entrySet()) {
            System.out.printf("%s: %d %s%n", entry.getKey(), entry.getValue(), entry.getKey() == endPoint ? " *** " : "");
        }
        ArrayList<String> path = new ArrayList<>();
        String prevFromToCity = endPoint;
        while (prevFromToCity != "") {
            path.add(prevFromToCity);
            prevFromToCity = previous.get(prevFromToCity);
        }
        Collections.reverse(path);
        return path;
    }

    private static Map<String, Set<Neighbor>> buildMap() {
        HashMap<String, Set<Neighbor>> cities = new HashMap<>();
        HashSet<Neighbor> neighborsOfA = new HashSet<>();
        neighborsOfA.add(new Neighbor("S", 7));
        neighborsOfA.add(new Neighbor("B", 3));
        neighborsOfA.add(new Neighbor("D", 4));
        cities.put("A", neighborsOfA);
        HashSet<Neighbor> neighborsOfB = new HashSet<>();
        neighborsOfB.add(new Neighbor("S", 2));
        neighborsOfB.add(new Neighbor("D", 4));
        neighborsOfB.add(new Neighbor("A", 3));
        neighborsOfB.add(new Neighbor("H", 1));
        cities.put("B", neighborsOfB);
        HashSet<Neighbor> neighborsOfC = new HashSet<>();
        neighborsOfC.add(new Neighbor("S", 3));
        neighborsOfC.add(new Neighbor("L", 2));
        cities.put("C", neighborsOfC);
        HashSet<Neighbor> neighborsOfD = new HashSet<>();
        neighborsOfD.add(new Neighbor("A", 4));
        neighborsOfD.add(new Neighbor("B", 4));
        neighborsOfD.add(new Neighbor("F", 5));
        cities.put("D", neighborsOfD);
        HashSet<Neighbor> neighborsOfE = new HashSet<>();
        neighborsOfE.add(new Neighbor("G", 2));
        neighborsOfE.add(new Neighbor("K", 5));
        cities.put("E", neighborsOfE);
        HashSet<Neighbor> neighborsOfF = new HashSet<>();
        neighborsOfF.add(new Neighbor("D", 5));
        neighborsOfF.add(new Neighbor("H", 3));
        cities.put("F", neighborsOfF);
        HashSet<Neighbor> neighborsOfG = new HashSet<>();
        neighborsOfG.add(new Neighbor("H", 2));
        neighborsOfG.add(new Neighbor("E", 2));
        cities.put("G", neighborsOfG);
        HashSet<Neighbor> neighborsOfH = new HashSet<>();
        neighborsOfH.add(new Neighbor("B", 1));
        neighborsOfH.add(new Neighbor("F", 3));
        neighborsOfH.add(new Neighbor("G", 2));
        cities.put("H", neighborsOfH);
        HashSet<Neighbor> neighborsOfI = new HashSet<>();
        neighborsOfI.add(new Neighbor("L", 4));
        neighborsOfI.add(new Neighbor("J", 6));
        neighborsOfI.add(new Neighbor("K", 4));
        cities.put("I", neighborsOfI);
        HashSet<Neighbor> neighborsOfJ = new HashSet<>();
        neighborsOfJ.add(new Neighbor("L", 4));
        neighborsOfJ.add(new Neighbor("I", 6));
        neighborsOfJ.add(new Neighbor("K", 4));
        cities.put("J", neighborsOfJ);
        HashSet<Neighbor> neighborsOfK = new HashSet<>();
        neighborsOfK.add(new Neighbor("I", 4));
        neighborsOfK.add(new Neighbor("J", 4));
        neighborsOfK.add(new Neighbor("E", 5));
        cities.put("K", neighborsOfK);
        HashSet<Neighbor> neighborsOfL = new HashSet<>();
        neighborsOfL.add(new Neighbor("C", 2));
        neighborsOfL.add(new Neighbor("I", 4));
        neighborsOfL.add(new Neighbor("J", 4));
        cities.put("L", neighborsOfL);
        HashSet<Neighbor> neighborsOfS = new HashSet<>();
        neighborsOfS.add(new Neighbor("A", 7));
        neighborsOfS.add(new Neighbor("B", 2));
        neighborsOfS.add(new Neighbor("C", 3));
        cities.put("S", neighborsOfS);
        return cities;
    }
}
