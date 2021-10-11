import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] friends = {{1,2},{0,3},{0,3},{1,2}};
        List<List<String>> watchedVideos = new LinkedList<>();
        String[] arreglo = {"A", "B"};
        watchedVideos.add(Arrays.asList(arreglo));
        String[] arreglo1 = {"C"};
        watchedVideos.add(Arrays.asList(arreglo1));
        String[] arreglo2 = {"B", "C"};
        watchedVideos.add(Arrays.asList(arreglo2));
        String[] arreglo3 = {"D"};
        watchedVideos.add(Arrays.asList(arreglo3));
        System.out.println(s.watchedVideosByFriends(watchedVideos, friends, 0, 2));
    }
}

class Solution {
    private int n;
    private HashMap<String, Integer> videos = new HashMap<>();
    private LinkedList<String> result = new LinkedList<String>();
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        n = friends.length;
        boolean[] visited = new boolean[n];
        int[] levels = new int[n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(id);
        visited[id] = true;
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            if(levels[currentNode] == level)
                addWatchedVideos(watchedVideos.get(currentNode));
            else {
                for(int neighbour: friends[currentNode]){
                    if(!visited[neighbour]){
                        queue.add(neighbour);
                        visited[neighbour] = true;
                        levels[neighbour] = levels[currentNode] + 1;
                    }
                }
            }
        }
        
        // Order videos
        Collections.sort(result, new Comparator<String>(){
            public int compare(String v1, String v2){
                int comparison = videos.get(v1).compareTo(videos.get(v2));
                if(comparison == 0)
                    return v1.compareTo(v2);
                return comparison;

            }
        });
        return result;
    }
    
    private void addWatchedVideos(List<String> watchedVideos){
        for(String video: watchedVideos){
            if(videos.containsKey(video)){
                int frequency = videos.get(video);
                frequency++;
                videos.put(video, frequency);
            } else {
                videos.put(video, 1);
                result.push(video);
            }
        }
    }
}