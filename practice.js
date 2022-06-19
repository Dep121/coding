/*
There are N people who want to visit the haunted house. The person will only go if at least L other people will go with them. Additionally, that person doesn't want to go with more than H other people, since it would ruin the experience for them. Find the maximum number of people that can go to the haunted house at a time.

Input:

6
1 2
1 4
0 3
0 1
3 4
0 2

7, 8, 9 -> 11

6
3 4
5 1000000
5 100
3 4
3 4
3 4

*/

/*
0, 1, 2, 3, 4, 5, 6 <- group count
      a  a
      b        b
   c        c
   d  d
            e  e
   f     f

1-2 -> l, h
*/

const input = [
  [1, 2],
[1, 4],
[0, 3],
[0, 1],
[3, 4],
[0, 2],
];

let mat = []

for(let i = input.length; i>=0; ++i) {
  if(!Array.isArray(mat) {
      mat[i] = []
  }
  mat[i][input[i][0]] = i
  mat[i][input[i][1]] = i
}


