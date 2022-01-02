package com.ltc.wangzheng.dfs_bfs;

/**
 * @author rwj
 * @create_time 2021/12/31
 * @description https://leetcode-cn.com/problems/jump-game-iii/
 */
public class CanReach {

    public boolean canReach(int[] arr, int start) {
        boolean[] used = new boolean[arr.length];
        return dfs(arr, start, visited);
    }
    public boolean dfs(int[] arr, int start, boolean[] used) {
        if(start < 0 || start >= arr.length || used[start]) return false;
        if(arr[start] == 0) return true;
        visited[start] = true;
        return dfs(arr, start+arr[start], visited) || dfs(arr, start-arr[start], visited);
    }

    /** 有些情况（比如分支很多的时候）用以下这种方式运行效率可能要快一些 */
    private boolean[] visited;
    private boolean reached = false;

    public boolean canReach2(int[] arr, int start) {
        int n = arr.length;
        visited = new boolean[n];
        dfs2(arr, start);
        return reached;
    }

    private void dfs2(int[] arr, int curi) {
        if(reached) return;
        if(arr[curi] == 0) {
            reached = true;
            return;
        }
        visited[curi] = true;
        int moveLeft = curi-arr[curi];
        if(moveLeft >= 0 && moveLeft < arr.length && !visited[moveLeft]) {
            dfs2(arr, moveLeft);
        }
        int moveRight = curi+arr[curi];
        if(moveRight >= 0 && moveRight < arr.length && !visited[moveRight]) {
            dfs2(arr, moveRight);
        }
    }

}
