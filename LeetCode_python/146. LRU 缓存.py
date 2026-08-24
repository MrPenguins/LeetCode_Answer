class LRUCache:
    class DoubleLinkedList:
        def __init__(self, key, val, prev=None, nxt=None):
            self.key = key
            self.val = val
            self.prev = prev
            self.nxt = nxt

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cnt = 0
        self.hashmap = {}
        self.dummy_head = self.DoubleLinkedList(-1, 0)
        self.dummy_tail = self.DoubleLinkedList(-1, 0)
        self.dummy_head.nxt = self.dummy_tail
        self.dummy_tail.prev = self.dummy_head

    def remove_tail(self):
        self.hashmap.pop(self.dummy_tail.prev.key)
        self.dummy_tail.prev.prev.nxt = self.dummy_tail
        self.dummy_tail.prev = self.dummy_tail.prev.prev

    def delete_node(self, node):
        node.prev.nxt = node.nxt
        node.nxt.prev = node.prev

    def add_head(self, node):
        node.prev = self.dummy_head
        node.nxt = self.dummy_head.nxt
        node.nxt.prev = node
        self.dummy_head.nxt = node

    def get(self, key: int) -> int:
        if self.hashmap.get(key):
            node = self.hashmap[key]
            self.delete_node(node)
            self.add_head(node)
            return node.val
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if self.hashmap.get(key):
            node = self.hashmap[key]
            self.delete_node(node)
            self.add_head(node)
            node.val = value
        else:
            node = self.DoubleLinkedList(key, value)
            self.hashmap[key] = node
            self.add_head(node)
            if self.cnt == self.capacity:
                self.remove_tail()
            else:
                self.cnt += 1

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
