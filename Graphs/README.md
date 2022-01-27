# Problem Description

The creator of Squid Game decided to add one more game for the
players. The players are required to form a team of k members to cover a land separated
into fields of different areas. Each player must be assigned a number of contiguous fields
in the land where he/she have to go through the entire field to collect hidden coins.
Assuming that each field can be assigned to only one player, all players must be assigned
to at least one field, and that it takes a player 1 unit of time to cover 1 m2 of land, you
are required to find an assignment for the players to the fields such that the maximum
time it takes a player in the team to cover his/her assigned fields is minimized. The land
is represented by an array of integers representing the areas of its fields in m2
.
For example, if k = 2 and l = [100, 100, 100, 100], then the optimal solution is to assign
Player 1 to the first two fields and to assign Player 2 to the last two fields making the
maximum time a player needs 200 units of time. However, if k = 2 and l = [10, 20, 30, 40],
then the best solution is to assign Player 1 to the first three fields requiring 60 units
of time and to assign Player 2 to the last field requiring 40 units of time making the
maximum time a player needs 60 units of time.

# Techniques Used
- Brute Force
- Dynamic Programming(Top Down - Memoization)

# Methods
- public static String naive (int k, int[] l) that implements a naive brute
force solution for the problem.

- public static String efficient (int k, int[] l) that implements the most
efficient solution you can think of for the problem.

- Both methods return a string encoding of the solution represented as follows:
    maxTime; P1 f ields; P2 f ields; . . . ; Pk f ields
where maxTime is the minimized maximum time for a player and Pi fields for 1 ≤ i ≤ k
are the areas of the fields assigned to Player i separated by commas.

# Sample Input/Output
k=2, l=[100,100,100,100]
Output: 200;100,100;100,100
k=2, l=[10,20,30,40]
Output: 60;10,20,30;40
