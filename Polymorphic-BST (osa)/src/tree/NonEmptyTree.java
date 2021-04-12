package tree;

import java.util.Collection;

/**
 * This class represents a non-empty search tree. An instance of this class
 * should contain:
 * <ul>
 * <li>A key
 * <li>A value (that the key maps to)
 * <li>A reference to a left Tree that contains key:value pairs such that the
 * keys in the left Tree are less than the key stored in this tree node.
 * <li>A reference to a right Tree that contains key:value pairs such that the
 * keys in the right Tree are greater than the key stored in this tree node.
 * </ul>
 *  
 */

public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {

	/* Provide whatever instance variables you need */
	K key;
	V value;
	Tree<K,V> left,right;

	/**
	 * Only constructor we need.
	 * @param key
	 * @param value
	 * @param left
	 * @param right..
	 */
	public NonEmptyTree(K key, V value, Tree<K,V> left, Tree<K,V> right) {
		this.key = key;
		this.value = value;
		this.left =left;
		this.right=right;
	}

	public V search(K key) {
		int comparator = key.compareTo(this.key);

		if (comparator == 0) {
			return this.value;
		} else if (comparator < 0) {
			return left.search(key);
		} else {
			return right.search(key);
		}


	}

	public NonEmptyTree<K, V> insert(K key, V value) {
		int comparator = this.key.compareTo(key);
		if(comparator == 0) {
			this.value = value;

		}
		else
			if(comparator > 0) { 
				this.left = this.left.insert(key, value);
			}
			else {
				this.right = this.right.insert(key, value);

			}
		return this;


	}

	public Tree<K, V> delete(K key) {
		K root;
		V rootVal;

		int comp = key.compareTo(this.key);

		if (comp == 0) {
			try {
				root = left.max();
				rootVal = left.search(root);
				this.key = root;
				this.value = rootVal;
				left = left.delete(root);
			} catch (TreeIsEmptyException e) {
				return this.left;
			}
		}else {
			if (comp < 0) {
				left = left.delete(key);
			} else if (comp > 0) {
				right = right.delete(key);
			}
		}

		return this;


	}

	public K max() {
		try {
			return right.max();
		}catch(TreeIsEmptyException e) {
			return this.key;
		}

	}

	public K min() {
		try {
			return left.min();
		}catch(TreeIsEmptyException e) {
			return this.key;
		}

	}

	public int size() {
		return 1 + left.size()+right.size();
	}

	public void addKeysToCollection(Collection<K> c) {
		c.add(this.key);
		this.left.addKeysToCollection(c);
		this.right.addKeysToCollection(c);

	}

	public Tree<K,V> subTree(K fromKey, K toKey) {



		//NonEmptyTree<K,V>  rndm = new NonEmptyTree<K, V>(this.key,this.value, this.left,this.right) ;

		int comparatorFrom = fromKey.compareTo(this.key);
		int comparatorTo =  toKey.compareTo(this.key);

		if (comparatorFrom <= 0 && comparatorTo >= 0) {
			return new NonEmptyTree<K, V>(this.key,this.value, this.left.subTree(fromKey,toKey), this.right.subTree(fromKey, toKey));

		} else if (comparatorTo < 0) {
			return 
					left.subTree(fromKey, toKey);
		} else {
			return 
					right.subTree(fromKey, toKey);
		}

	}

	public int height() {
		if(left.height()> right.height()) {
			return 1 + left.height();
		}else {
			return 1 + right.height();
		}

	}

	public void inorderTraversal(TraversalTask<K,V> p) {

		left.inorderTraversal(p);
		p.performTask(this.key, this.value);
		right.inorderTraversal(p);

	}

	public void rightRootLeftTraversal(TraversalTask<K,V> p) {
		right.inorderTraversal(p);
		p.performTask(this.key, this.value);
		left.inorderTraversal(p);	
	}	

}