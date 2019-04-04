package trees;

public class CheckMirror {

	TNode a, b;

	public void ifMirror() {
		boolean ans = ifMirror(a, b);
		System.out.println(ans);
	}

	public boolean ifMirror(TNode a, TNode b) {

		if (a == null && b == null)
			return true;
		if (a == null || b == null)
			return false;
		/*
		 * if(a.val==b.val) return true;
		 */
		return a.val == b.val && ifMirror(a.left, b.right) && ifMirror(a.right, b.left);
	}

	public static void main(String[] args) {

		CheckMirror obj = new CheckMirror();
		obj.a = new TNode(1);
		obj.a.left = new TNode(3);
		obj.a.right = new TNode(2);
		obj.a.right.left = new TNode(5);
		obj.a.right.right = new TNode(4);

		obj.b = new TNode(1);
		obj.b.left = new TNode(2);
		obj.b.right = new TNode(3);
		obj.b.left.right = new TNode(5);
		obj.b.left.left = new TNode(4);

		obj.ifMirror();

	}
}
