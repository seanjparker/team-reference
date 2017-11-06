//where b is int array, acts as fenwick tree -- must be init
int sum(int i) {
  int s = 0;
  while (i > 0) {
    s += b[i - 1];
    i -= i & -i;
  }
  return s;
}
void add(int i, int x) {
  while (i < b.length) {
    b[i] += x;
    i += (i + 1) & -(i + 1);
  }
}
int range(int i, int j) {
  int s = 0;
  while (j > i) s += b[j - 1]; j -= j & -j;
  while (i > j) s -= b[i - 1]; i -= i & -i;
  return s;
}
int get(int i) { return range(i, i + 1); }
void set(int v, int i) { add(v - get(i), i); }
void init() {
  for (int i = 0; i < b.length; i++) {
    int j = i + ((i + 1) & -(i + 1));
    if (j < b.length)
      b[j] += b[i];
  }
}
