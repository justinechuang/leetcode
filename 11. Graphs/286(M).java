/*286. Walls & Gates (Medium)
This solution is a "multisource" BFS
works by first finding all the gates and putting them in queue.
Then for every direction starting from the gate where the room is empty
it marks the path with how far it is from the gate (+1)
and then adds that spot to the queue for future processing (for the future emtpy spots)
*/

class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return; 
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<rooms.length; i++){
            for(int j=0; j<rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!queue.isEmpty()){
            int[] temp = queue.poll(); 
            int r = temp[0];
            int c = temp[1];
            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >= 0 && nr < rooms.length && nc >= 0 && nc < rooms[0].length && rooms[nr][nc] == Integer.MAX_VALUE){
                    rooms[nr][nc] = rooms[r][c] + 1; 
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}