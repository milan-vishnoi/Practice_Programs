## Problem Statement:

Write a program that encodes and decodes a given string using the run-length encoding algorithm. The run-length encoding algorithm is a lossless data compression technique that replaces consecutive identical characters with a single character followed by its frequency. 

For example, “AAAABBBCCD” is encoded as “A4B3C2D1”. The program should take a string and a mode as input and print the encoded or decoded string to the console depending on the mode. The mode can be either “E” for encoding or “D” for decoding. The program should also handle the case when the string is empty or null and print a suitable message. 

For example, if the string is “WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB” and the mode is “E”, the output should be “W12B1W12B3W24B1”. If the mode is “D”, the output should be “WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWWB”.