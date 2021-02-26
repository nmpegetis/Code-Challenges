## Construct Binary Tree from Preorder and Inorder Traversal
---
Given two integer arrays `preorder` and `inorder` where `preorder` is the preorder traversal of a binary tree and inorder is the `inorder` traversal of the same tree, construct and return **the binary tree**.

#### Example 1:
```
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
```

#### Example 2:
```
Input: preorder = [-1], inorder = [-1]
Output: []
```

#### Constraints:

* `1 <= preorder.length <= 3000`
* `preorder.length == inorder.length`
* `-3000 <= inorder[i], preorder[i] <= 3000`
* `inorder` and `preorder` consist of **unique** values.
* Each value of `preorder` also appears in `inorder`.
* `inorder` is **guaranteed** to be the inorder traversal of the tree.
* `preorder` is **guaranteed** to be the postorder traversal of the tree.