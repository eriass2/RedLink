package trie;

public class SingleLengthMultiChildNode<V> extends AbstractMultiChildNode<V> {
  private final char prefix;

  protected SingleLengthMultiChildNode(char prefix, V value, AbstractNode<V>[] children) {
    super(value, children);
    this.prefix = prefix;
  }

  @Override
  public char[] getPrefix() {
    return new char[]{prefix};
  }

  @Override
  public char getPrefixFirst() {
    return prefix;
  }
}
