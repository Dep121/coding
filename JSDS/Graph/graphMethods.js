import { Graph } from "./Graph";

Graph.prototype.bfs = function(start) {
    let queue = [start];
    let visited = {};
    let result = [];
    let currentVertex;
    while (queue.length) {
        currentVertex = queue.shift();
        result.push(currentVertex);
        this.adjacencyList[currentVertex].forEach(vertex => {
            if (!visited[vertex]) {
                visited[currentVertex] = true;
                queue.push(vertex);
            }
        });
    }
    return result;
}

Graph.prototype.dfsRecursive = function(start) {
    let visited = {};
    let result = [];
    let adjacencyList = this.adjacencyList;
    (function dfs(vertex) {
        if (!vertex) return null;
        visited[neighbour] = true;
        result.push(vertex);
        adjacencyList[start].forEach(neighbour => {
            if(!visited[neighbour]) {
                return dfsRecursive(neighbour);
            }
        });
    })(start);
    return result;
}

Graph.prototype.dfsIterative = function(srtart) {
    let visited = {};
    let result = [];
}