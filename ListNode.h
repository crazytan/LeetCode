#ifndef __LISTNODE_H__
#define __LISTNODE_H__

#include <cstdlib>

struct ListNode {
	int val;
	ListNode *next;
ListNode(int x): val(x), next(NULL) {}
};

ListNode *createList(int vals[], int n);

void deleteList(ListNode *head);

void printList(ListNode *head);

#endif /* __LISTNODE_H__ */
