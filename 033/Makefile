CFLAGS = -c -g -Wall
FLAGS = -g -Wall
CHKFLAGS = -o nul -S
LISTNODE = /Users/tan/OneDrive/LeetCode/ListNode.o

all: main

main: main.o
	g++ $(FLAGS) main.o -o main

main.o: main.cpp
	g++ $(CFLAGS) main.cpp

check-syntax:
	g++ ${CHKFLAGS} ${CHK_SOURCES}
