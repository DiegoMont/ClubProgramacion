import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

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
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            if(levels[currentNode] == level)
                addWatchedVideos(watchedVideos.get(currentNode));
            else {
                for(int neighbour: friends[currentNode]){
                    if(!visited[neighbour]){
                        queue.add(neighbour);
                        levels[neighbour] = levels[currentNode] + 1;
                    }
                }
            }
            visited[currentNode] = true;
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