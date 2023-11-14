# Scrabble
Problem Statement
Take in a list of words and sort them by how many points they would
earn in the game of Scrabble, with the lowest scoring words being
outputted first. If two words have the same Scrabble score, then they
should be sorted in alphabetical order. Letters in Scrabble earn the
following points:

1 point – A E I O U L N S T R
2 points – D G
3 points – B C M P
4 points – F H V W Y
5 points – K
8 points – J X
10 points – Q Z

Input Format
The first line is an int n indicating the quantity of strings that follow
This is followed by n words to be sorted, each on a separate line
Output Format
Output each of the words on a separate line, sorted by their Scrabble
scores, with the lowest scoring words coming first
Constraints
0≤n≤100

Sample Input
3
one
two
three

Sample Output
one
two
three
