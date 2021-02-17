##  Binary Tree Postorder Traversal
---

Given the `root` of a binary tree, return the **inorder traversal** of its nodes' values.

#### Example 1:
```
Input: root = [1,null,2,3]
Output: [3,2,1]
```

#### Example 2:
```
Input: root = []
Output: []
```

#### Example 3:
```
Input: root = [1]
Output: [1]
```

#### Example 4:
```
Input: root = [1,2]
Output: [2,1]
```

#### Example 5:
```
Input: root = [1,null,2]
Output: [2,1]
```

#### Example 6:
```
Input: [1,2,5,3,4]
Output: [3,4,2,5,1]
```

#### Constraints:

* The number of nodes in the tree is in the range `[0, 100]`.
* `-100 <= Node.val <= 100`

**Follow up:** Recursive solution is trivial, could you do it iteratively?