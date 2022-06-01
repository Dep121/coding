There is a building with 2 floors ( ground floor and first floor), connected by a staircase consisting of 'n' steps. 
You start from the ground floor and are moving up the staircase. 
You can hop either 1 step, 2 steps, or 3 steps at a time. 
Given 'n', implement a method to count how many possible ways are there for you to reach the top.

eg: if n=3
ans: 4

ways:
1,1,1
1,2
2,1
3


int ways = 0
int steps = 3

int d[partialStep][x] = new int[][]



count(int partialSteps, b) {
    if (partialSteps > steps) {
        return 
    }
    if(partialSteps == steps) {
        ways += 1
        d[partialSteps][b] = ways
        return
    }
    
    for(int x = 1; x <= 3; x++) {
        if(d[partialSteps][x] != -1) {
            ways += d[partialSteps][x]
        } else {
            count(partialSteps + x, x)
        }
    }
}

count(0)

1,1,1 ==> [3][3] = 1
1,1,2 ==> X
1,1,3 ===> X
1,2  [3][2] = 1
1,3
2,1 ===> [3][1] = 1





