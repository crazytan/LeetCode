CFLAGS = -c -g -Wall
FLAGS = -g -Wall
CHKFLAGS = -S -o nul
LISTNODE = /Users/tan/OneDrive/LeetCode/ListNode.o

all: main

main: main.o ${LISTNODE}
	g++ $(FLAGS) main.o ${LISTNODE} -o main

main.o: main.cpp
	g++ $(CFLAGS) main.cpp

check-syntax:
	g++ ${CHKFLAGS} ${CHK_SOURCES}
